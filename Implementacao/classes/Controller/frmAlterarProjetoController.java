/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.frmAlterarProjetoVIEW;
import javax.swing.*;
import Model.Projeto;
import DAO.ProjetoDAO;
import java.awt.HeadlessException;
import java.util.Date;
import java.util.function.Consumer;

/**
 * É parte do sistema de controle de projetos e tem como objetivo gerenciar a
 * atualização de informações relacionadas a um projeto. Ela recebe interações
 * do usuário por meio da interface gráfica e, com base nessas interações,
 * valida e atualiza os dados do projeto no banco de dados.
 *
 * @author Erick Lopes
 */
public class frmAlterarProjetoController {

    // A referência à interface gráfica associada
    private frmAlterarProjetoVIEW view;
    
    /**
     * Cria uma nova instância do controlador.
     *
     * @param view A interface gráfica associada a este controlador.
     */
    public frmAlterarProjetoController(frmAlterarProjetoVIEW view) {
        this.view = view;
    }

    /**
     * Método responsável por obter os dados fornecidos pelo usuário através da
     * interface gráfica, validar esses dados e, em seguida, chamar o método
     * adequado na camada de acesso a dados para efetuar a atualização no banco.
     *
     * @param view A instância da classe frmAlterarProjetoVIEW contendo os dados
     * do projeto.
     */
    public void AtualizarProjeto(frmAlterarProjetoVIEW view) {
        int codigoProjeto = Integer.parseInt(view.CodProjeto.getText());
        String nomeProjeto = view.txtNomeProjeto1.getText();
        Date dataCtrInicio = view.DataCtrInicio.getDate();
        Date dataCtrPrevisaoTermino = view.DataCtrPrevisaoTermino1.getDate();
        Date dataCtrTermino = view.DataCtrTermino.getDate();
        String descricaoProjeto = view.txtDescricaoProjeto.getText();

        if (camposObrigatoriosNaoPreenchidos(nomeProjeto, dataCtrInicio)) {
            mostrarMensagem("Os campos Nome do Projeto e Data de Início são obrigatórios.");
        } else {
            try {
                Projeto projetoDTO = criarProjetoDTO(codigoProjeto, nomeProjeto, dataCtrInicio, dataCtrPrevisaoTermino, dataCtrTermino, descricaoProjeto);

                ProjetoDAO projetoDAO = new ProjetoDAO();
                boolean atualizadoComSucesso = projetoDAO.atualizarProjeto(projetoDTO);

                if (atualizadoComSucesso) {
                    mostrarMensagem("Projeto atualizado com sucesso!");
                    view.dispose();
                } else {
                    mostrarMensagem("Falha ao atualizar o projeto.");
                }
            } catch (HeadlessException e) {
                mostrarMensagem("Erro ao acessar o banco de dados: " + e.getMessage());
            }
        }
    }

    /**
     * Método auxiliar para verificar se os campos obrigatórios, como nome do
     * projeto e data de início, foram preenchidos. Retorna true se algum desses
     * campos não estiver preenchido.
     *
     * @param nomeProjeto O nome do projeto a ser verificado.
     * @param dataCtrInicio A data de início do projeto a ser verificada.
     * @return Retorna true se algum dos campos obrigatórios não estiver
     * preenchido.
     */
    private boolean camposObrigatoriosNaoPreenchidos(String nomeProjeto, Date dataCtrInicio) {
        return nomeProjeto.isEmpty() || dataCtrInicio == null;
    }

    /**
     * Método auxiliar para criar um objeto Projeto com base nos dados
     * fornecidos. Permite tratar casos em que alguns campos podem ser nulos ou
     * vazios.
     *
     * @param codigoProjeto O código do projeto.
     * @param nomeProjeto O nome do projeto.
     * @param dataCtrInicio A data de início do projeto.
     * @param dataCtrPrevisaoTermino A data prevista para término do projeto.
     * @param dataCtrTermino A data real de término do projeto.
     * @param descricaoProjeto A descrição do projeto.
     * @return Um objeto Projeto configurado com os dados fornecidos.
     */
    private Projeto criarProjetoDTO(int codigoProjeto, String nomeProjeto, Date dataCtrInicio, Date dataCtrPrevisaoTermino, Date dataCtrTermino, String descricaoProjeto) {
        Projeto projetoDTO = new Projeto();
        projetoDTO.setCodProjeto(codigoProjeto);
        projetoDTO.setNomeProjeto(nomeProjeto);
        projetoDTO.setDataCtrInicio(dataCtrInicio);

        adicionaDataSeNaoNula(projetoDTO::setDataCtrPrevisaoTermino, dataCtrPrevisaoTermino);
        adicionaDataSeNaoNula(projetoDTO::setDataCtrTermino, dataCtrTermino);
        adicionaDescricaoSeNaoNulaOuVazia(projetoDTO::setDescricaoProjeto, descricaoProjeto);

        return projetoDTO;
    }

    /**
     * Método auxiliar para adicionar dados ao objeto Projeto apenas se eles não
     * forem nulos ou vazios.
     *
     * @param setter
     * @param data
     */
    private void adicionaDataSeNaoNula(Consumer<Date> setter, Date data) {
        if (data != null) {
            setter.accept(data);
        }
    }

    /**
     * Método auxiliar para adicionar dados ao objeto Projeto apenas se eles não
     * forem nulos ou vazios.
     *
     * @param setter
     * @param descricao
     */
    private void adicionaDescricaoSeNaoNulaOuVazia(Consumer<String> setter, String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            setter.accept(descricao);
        }
    }

    /**
     * Método responsável por exibir mensagens ao usuário, utilizando caixas de
     * diálogo.
     *
     * @param mensagem
     */
    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
