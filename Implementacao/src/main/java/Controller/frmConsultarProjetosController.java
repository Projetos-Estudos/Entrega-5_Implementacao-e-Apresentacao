/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProjetoDAO;
import DAO.UsuarioDAO;
import Model.SessaoUsuario;
import View.frmAlterarProjetoVIEW;
import View.frmAlterarTarefasVIEW;
import View.frmConsultarProjetosVIEW;
import java.awt.Dialog;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JTable;

/**
 * Classe responsável por controlar as interações entre a interface gráfica de
 * consulta de projetos (frmConsultarProjetosVIEW) e o modelo de dados
 * relacionado a projetos.
 *
 * @author Erick Lopes
 */
public class frmConsultarProjetosController {

    private frmConsultarProjetosVIEW view;

    public frmConsultarProjetosController(frmConsultarProjetosVIEW view) {
        this.view = view;
    }

    /**
     * Método responsável por atualizar a tabela de projetos na interface
     * gráfica com dados do banco de dados.
     */
    public void atualizarTabelaProjeto() {
        SessaoUsuario sessaoUsuario = SessaoUsuario.getInstance();
        int codUsuario = sessaoUsuario.getCOD_USUARIO();

        ProjetoDAO projetoDAO = new ProjetoDAO();
        ResultSet rs = projetoDAO.ConsultarProjetos(codUsuario);

        DefaultTableModel tableModel = new DefaultTableModel();

        try {
            tableModel.setColumnIdentifiers(new String[]{"Código", "Nome", "Data de Inicio", "Previsão Término", "Data de Término", "Descrição", "Data de inclusão"});

            if (rs != null) {
                java.sql.ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    tableModel.addRow(row);
                }
            }

            view.getjTable1().setModel(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela: " + e.getMessage());
        }
    }

    /**
     * Método responsável por atualizar a tabela de participantes de um projeto
     * específico na interface gráfica.
     *
     * @param codProjeto O código que identifica o projeto.
     */
    public void atualizarTabelaParticipantes(int codProjeto) {
        try {
            ProjetoDAO projetoDAO = new ProjetoDAO();
            ResultSet rs = projetoDAO.ConsultarParticipantes(codProjeto);

            if (rs != null) {
                DefaultTableModel tableModel = new DefaultTableModel();

                tableModel.setColumnIdentifiers(new String[]{"Código", "Nick Acesso", "Nome Usuário", "E-mail"});

                java.sql.ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    tableModel.addRow(row);
                }

                view.getjTable2().setModel(tableModel);
            } else {
                DefaultTableModel emptyModel = new DefaultTableModel();
                emptyModel.setColumnIdentifiers(new String[]{"Código", "Nick Acesso", "Nome Usuário", "E-mail"});
                view.getjTable2().setModel(emptyModel);
                JOptionPane.showMessageDialog(null, "Nenhum participante encontrado para o projeto.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela de participantes: " + e.getMessage());
        }
    }

    /**
     * Método permite a alteração de dados de um projeto selecionado.
     */
    public void alterarProjeto() {
        int linhaSelecionada = view.getjTable1().getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view, "Por favor, selecione um projeto na grade.");
        } else {
            DefaultTableModel model = (DefaultTableModel) view.getjTable1().getModel();
            Object codigo = model.getValueAt(linhaSelecionada, 0);
            Object nome = model.getValueAt(linhaSelecionada, 1);
            Object previsaoTermino = model.getValueAt(linhaSelecionada, 3);
            Object inicio = model.getValueAt(linhaSelecionada, 2);
            Object termino = model.getValueAt(linhaSelecionada, 4);
            Object descricao = model.getValueAt(linhaSelecionada, 5);

            frmAlterarProjetoVIEW telaAlterarProjeto = new frmAlterarProjetoVIEW();
            telaAlterarProjeto.preencherCamposProjeto(codigo, nome, previsaoTermino, inicio, termino, descricao);

            telaAlterarProjeto.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

            telaAlterarProjeto.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    atualizarTabelaProjeto();
                }
            });

            telaAlterarProjeto.setVisible(true);
        }
    }

    /**
     * Método permite a exclusão de um projeto, considerando diferentes casos,
     * como permissões de administrador.
     */
    public void excluirProjeto() {
        int selectedRow = view.jTable1.getSelectedRow();

        if (selectedRow == -1) {
            exibirMensagem("Por favor, selecione um registro para exclusão.", "Nenhuma seleção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int codigoProjeto = (int) view.jTable1.getValueAt(selectedRow, 0);

        try {
            ProjetoDAO projetoDAO = new ProjetoDAO();
            SessaoUsuario sessaoUsuario = SessaoUsuario.getInstance();
            int codUsuario = sessaoUsuario.getCOD_USUARIO();

            if (projetoDAO.administradorDoProjeto(codUsuario, codigoProjeto)) {
                realizarExclusaoComoAdministrador(projetoDAO, codigoProjeto);
            } else if (!projetoDAO.usuariosAssociadosAoProjeto(codigoProjeto)) {
                realizarExclusao(projetoDAO, codigoProjeto);
            } else {
                exibirMensagem("Você não tem permissão para excluir este projeto.", null, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException e) {
            exibirMensagem("Erro ao acessar o banco de dados: " + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método realiza a exclusão de um projeto quando o usuário que está
     * executando a ação é um administrador. Isso envolve a remoção de todos os
     * usuários associados ao projeto e, em seguida, a exclusão do próprio
     * projeto.
     *
     * @param projetoDAO Uma instância de ProjetoDAO para interagir com o banco
     * de dados.
     * @param codigoProjeto O código único que identifica o projeto a ser
     * excluído.
     */
    private void realizarExclusaoComoAdministrador(ProjetoDAO projetoDAO, int codigoProjeto) {
        int confirmacao = exibirConfirmacao("Você é um administrador. Deseja continuar com a exclusão?", "Confirmação");

        if (confirmacao == JOptionPane.YES_OPTION) {
            if (projetoDAO.removerUsuariosAssociadosAoProjeto(codigoProjeto)) {
                boolean excluidoComSucesso = projetoDAO.excluirProjeto(codigoProjeto);

                if (excluidoComSucesso) {
                    exibirMensagem("Projeto excluído com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    exibirMensagem("Falha ao excluir o projeto.", null, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                exibirMensagem("Falha ao remover usuários associados ao projeto.", null, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            exibirMensagem("Exclusão cancelada.", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método realiza a exclusão de um projeto quando o usuário que está
     * executando a ação não é um administrador. Este método apenas tenta
     * excluir o projeto diretamente sem remover usuários associados, pois não é
     * esperado que o usuário comum tenha permissão para remover outros usuários
     * associados ao projeto.
     *
     * @param projetoDAO Uma instância de ProjetoDAO para interagir com o banco
     * de dados.
     * @param codigoProjeto O código único que identifica o projeto a ser
     * excluído.
     */
    private void realizarExclusao(ProjetoDAO projetoDAO, int codigoProjeto) {
        boolean excluidoComSucesso = projetoDAO.excluirProjeto(codigoProjeto);

        if (excluidoComSucesso) {
            exibirMensagem("Projeto excluído com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            exibirMensagem("Falha ao excluir o projeto.", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método exibe uma caixa de diálogo com uma mensagem específica.
     *
     * @param mensagem A mensagem a ser exibida na caixa de diálogo.
     * @param titulo O título da caixa de diálogo.
     * @param tipo O tipo da caixa de diálogo, como
     * JOptionPane.INFORMATION_MESSAGE ou JOptionPane.ERROR_MESSAGE.
     */
    private void exibirMensagem(String mensagem, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }

    /**
     * Método exibe uma caixa de diálogo de confirmação com uma mensagem
     * específica.
     *
     * @param mensagem A mensagem a ser exibida na caixa de diálogo.
     * @param titulo O título da caixa de diálogo de confirmação.
     * @return Um inteiro indicando a opção selecionada pelo usuário
     * (JOptionPane.YES_OPTION ou JOptionPane.NO_OPTION).
     */
    private int exibirConfirmacao(String mensagem, String titulo) {
        return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION);
    }

    /**
     * Método adiciona um participante a um projeto específico.
     */
    public void adicionarParticipanteAoProjeto() {
        int linhaSelecionada = view.getjTable1().getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view, "Por favor, selecione um projeto na grade.");
            return;
        }

        String txtAdicionarPartcipProj = view.txtAdicionarPartcipProj.getText();
        if (txtAdicionarPartcipProj.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, insira o Nick de acesso do participante.");
            return;
        }

        int codigoProjeto = (int) view.getjTable1().getValueAt(linhaSelecionada, 0);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int codigoUsuario = usuarioDAO.obterCodigoUsuarioPorNomeAcesso(txtAdicionarPartcipProj);

        if (codigoUsuario != -1) {
            ProjetoDAO projetoDAO = new ProjetoDAO();
            boolean inseridoComSucesso = projetoDAO.inserirParticipanteNoProjeto(codigoProjeto, String.valueOf(codigoUsuario));

            if (inseridoComSucesso) {
                JOptionPane.showMessageDialog(view, "Participante adicionado com sucesso ao projeto.");
                atualizarTabelaParticipantes(codigoProjeto);
            } else {
                JOptionPane.showMessageDialog(view, "Falha ao adicionar o participante ao projeto.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Usuário com o Nick de acesso especificado não existe.");
        }
    }

    /**
     * Método remove um participante de um projeto, considerando casos
     * especiais, como o último participante.
     */
    public void removerParticipanteDoProjeto() {
        int linhaProjetoSelecionada = view.getjTable1().getSelectedRow();
        int linhaParticipanteSelecionada = view.getjTable2().getSelectedRow();

        if (linhaProjetoSelecionada == -1) {
            exibirMensagem("Por favor, selecione um projeto na grade.");
            return;
        }

        if (linhaParticipanteSelecionada == -1) {
            exibirMensagem("Por favor, selecione um participante na grade.");
            return;
        }

        int codigoProjeto = getCodigoSelecionado(view.getjTable1(), linhaProjetoSelecionada);
        int codigoParticipante = getCodigoSelecionado(view.getjTable2(), linhaParticipanteSelecionada);

        ProjetoDAO projetoDAO = new ProjetoDAO();

        if (projetoDAO.unicoParticipante(codigoProjeto)) {
            tratarUnicoParticipante(projetoDAO, codigoProjeto, codigoParticipante);
        } else {
            tratarRemocaoParticipante(projetoDAO, codigoProjeto, codigoParticipante);
        }
    }

    /**
     * Método trata a exclusão quando há apenas um participante vinculado ao
     * projeto. Se o usuário confirmar, o participante é removido e o projeto é
     * excluído. A tabela de participantes e projetos é atualizada após a
     * operação bem-sucedida.
     *
     * @param projetoDAO Objeto ProjetoDAO para realizar operações no banco de
     * dados.
     * @param codigoProjeto Código do projeto a ser manipulado.
     * @param codigoParticipante Código do participante a ser removido.
     */
    private void tratarUnicoParticipante(ProjetoDAO projetoDAO, int codigoProjeto, int codigoParticipante) {
        int confirmacao = exibirConfirmacao("Este participante é o único vinculado ao projeto. Se você continuar, o projeto também será excluído. Deseja continuar?", "Confirmação");

        if (confirmacao == JOptionPane.YES_OPTION) {
            boolean participanteRemovido = projetoDAO.removerParticipanteDoProjeto(codigoProjeto, codigoParticipante);

            if (participanteRemovido) {
                projetoDAO.excluirProjeto(codigoProjeto);
                exibirMensagem("Projeto e participante removidos com sucesso.");
                atualizarTabelaParticipantes(codigoProjeto);
                atualizarTabelaProjeto();
            } else {
                exibirMensagem("Falha ao remover o participante do projeto.");
            }
        }
    }

    /**
     * Método trata a remoção de um participante do projeto, verificando se o
     * participante é administrador e se pode ser removido. A tabela de
     * participantes é atualizada após a remoção bem-sucedida.
     *
     * @param projetoDAO Objeto ProjetoDAO para realizar operações no banco de
     * dados.
     * @param codigoProjeto Código do projeto a ser manipulado.
     * @param codigoParticipante Código do participante a ser removido.
     */
    private void tratarRemocaoParticipante(ProjetoDAO projetoDAO, int codigoProjeto, int codigoParticipante) {
        if (!projetoDAO.administradorDoProjeto(codigoParticipante, codigoProjeto)) {
            boolean removidoComSucesso = projetoDAO.removerParticipanteDoProjeto(codigoProjeto, codigoParticipante);

            if (removidoComSucesso) {
                exibirMensagem("Participante removido com sucesso do projeto.");
                atualizarTabelaParticipantes(codigoProjeto);
            } else {
                exibirMensagem("Falha ao remover o participante do projeto.");
            }
        } else {
            exibirMensagem("Somente o administrador do projeto não pode ser removido.");
        }
    }

    /**
     * Exibe uma mensagem utilizando a classe JOptionPane.
     *
     * @param mensagem A mensagem a ser exibida.
     */
    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(view, mensagem);
    }

    /**
     * Obtém o código selecionado em uma determinada linha de uma tabela.
     *
     * @param table Tabela a ser consultada.
     * @param selectedRow Índice da linha selecionada.
     * @return O código associado à linha selecionada na tabela.
     */
    private int getCodigoSelecionado(JTable table, int selectedRow) {
        return ((Number) table.getValueAt(selectedRow, 0)).intValue();
    }

    /**
     * Método permite a adição de uma nova tarefa a um projeto selecionado.
     */
    public void adicionarTarefa() {
        int linhaSelecionada = view.getjTable1().getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view, "Por favor, selecione um projeto na grade.");
        } else {
            DefaultTableModel model = (DefaultTableModel) view.getjTable1().getModel();
            Object codigo = model.getValueAt(linhaSelecionada, 0);
            Object nome = model.getValueAt(linhaSelecionada, 1);

            frmAlterarTarefasVIEW telaAlterarTarefa = new frmAlterarTarefasVIEW();
            telaAlterarTarefa.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            //telaAlterarProjeto.setDadosProjeto(codigo, nome); // Criar o método para passar os dados para a tela de alteração
            telaAlterarTarefa.setVisible(true);
        }
    }

    /**
     * Método limpa os campos de entrada na interface gráfica.
     */
    public void limparCampos() {
        view.txtNomeProjeto.setText("");
        view.DataPeriodoInicio.setDate(null);
        view.DataPeriodoTermino.setDate(null);
    }
}
