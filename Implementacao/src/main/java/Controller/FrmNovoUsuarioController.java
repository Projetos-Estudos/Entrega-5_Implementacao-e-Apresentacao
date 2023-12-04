/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import View.frmNovoUsuarioVIEW;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 * Classe FrmNovoUsuarioController: Controla a lógica de interação entre a
 * interface gráfica e a camada de acesso a dados para a criação de novos
 * usuários.
 *
 * Autor: Erick Lopes
 */
public class FrmNovoUsuarioController {

    private frmNovoUsuarioVIEW view;
    private UsuarioDAO usuarioDAO;

    /**
     * Construtor da classe.
     *
     * @param view Instância da interface gráfica associada a este controlador.
     */
    public FrmNovoUsuarioController(frmNovoUsuarioVIEW view) {
        this.view = view;
        usuarioDAO = new UsuarioDAO();
    }

    /**
     * Limpa os campos da interface gráfica relacionados à criação de novos
     * usuários.
     *
     * @param view
     */
    public void limparCampos(frmNovoUsuarioVIEW view) {
        view.txtNomeAcesso.setText("");
        view.txtNomeUsuario.setText("");
        view.txtSenhaUsuario.setText("");
        view.txtValidaSenhaUsuario.setText("");
        view.txtDescricaoEmail.setText("");
        view.txtObsUsuario.setText("");
    }

    /**
     * Limpa os campos da interface gráfica relacionados à criação de novos
     * usuários.
     */
    public void limparCampos() {
        view.txtNomeAcesso.setText("");
        view.txtNomeUsuario.setText("");
        view.txtDescricaoEmail.setText("");
        view.txtSenhaUsuario.setText("");
        view.txtValidaSenhaUsuario.setText("");
        view.txtObsUsuario.setText("");
    }

    /**
     * Cadastra um novo usuário com base nos dados fornecidos pela interface
     * gráfica.
     *
     * @param view Instância da interface gráfica com os dados do usuário.
     */
    public void cadastrarUsuario(frmNovoUsuarioVIEW view) {
        String nomeAcesso = view.txtNomeAcesso.getText();
        String nomeUsuario = view.txtNomeUsuario.getText();
        String senhaUsuario = view.txtSenhaUsuario.getText();
        String validaSenhaUsuario = view.txtValidaSenhaUsuario.getText();
        String descricaoEmail = view.txtDescricaoEmail.getText();
        String obsUsuario = view.txtObsUsuario.getText();

        if (camposObrigatoriosNaoPreenchidos(nomeAcesso, nomeUsuario, senhaUsuario)) {
            mostrarMensagem("Os campos Nome de Acesso, Nome de Usuário e Senha são obrigatórios.");
        } else if (senhasNaoCoincidem(senhaUsuario, validaSenhaUsuario)) {
            mostrarMensagem("As senhas não coincidem. Por favor, insira senhas iguais.");
        } else if (nomeAcessoJaExiste(nomeAcesso)) {
            mostrarMensagem("O nome de acesso especificado já existe. Por favor, escolha outro nome de acesso.");
        } else {
            processarCadastroUsuario(nomeAcesso, nomeUsuario, senhaUsuario, descricaoEmail, obsUsuario);
        }
    }

    /**
     * Verifica se os campos obrigatórios para o cadastro de usuário não foram
     * preenchidos.
     *
     * @param nomeAcesso O nome de acesso do usuário.
     * @param nomeUsuario O nome do usuário.
     * @param senhaUsuario A senha do usuário.
     * @return true se algum dos campos obrigatórios não estiver preenchido,
     * caso contrário, false.
     */
    private boolean camposObrigatoriosNaoPreenchidos(String nomeAcesso, String nomeUsuario, String senhaUsuario) {
        return nomeAcesso.isEmpty() || nomeUsuario.isEmpty() || senhaUsuario.isEmpty();
    }

    /**
     * Verifica se as senhas fornecidas coincidem.
     *
     * @param senhaUsuario A senha do usuário.
     * @param validaSenhaUsuario A senha validada do usuário.
     * @return true se as senhas não coincidirem, caso contrário, false.
     */
    private boolean senhasNaoCoincidem(String senhaUsuario, String validaSenhaUsuario) {
        return !senhaUsuario.equals(validaSenhaUsuario);
    }

    /**
     * Verifica se um nome de acesso já existe no banco de dados.
     *
     * @param nomeAcesso O nome de acesso a ser verificado.
     * @return true se o nome de acesso já existe, caso contrário, false.
     */
    private boolean nomeAcessoJaExiste(String nomeAcesso) {
        return usuarioDAO.nomeAcessoExistente(nomeAcesso);
    }

    /**
     * Processa o cadastro do usuário com base nos dados fornecidos.
     *
     * @param nomeAcesso Nome de acesso do usuário.
     * @param nomeUsuario Nome do usuário.
     * @param senhaUsuario Senha do usuário.
     * @param descricaoEmail Descrição do e-mail do usuário.
     * @param obsUsuario Observações sobre o usuário.
     */
    private void processarCadastroUsuario(String nomeAcesso, String nomeUsuario, String senhaUsuario, String descricaoEmail, String obsUsuario) {
        try {
            Usuario usuarioDTO = criarUsuarioDTO(nomeAcesso, nomeUsuario, senhaUsuario, descricaoEmail, obsUsuario);

            boolean inseridoComSucesso = usuarioDAO.inserirUsuario(usuarioDTO);

            if (inseridoComSucesso) {
                mostrarMensagem("Usuário cadastrado com sucesso!");
                limparCampos(view);
                retornarParaLogin();
            } else {
                mostrarMensagem("Falha ao cadastrar usuário.");
            }
        } catch (HeadlessException e) {
            mostrarMensagem("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    /**
     * Cria e retorna um objeto da classe Usuario com os dados fornecidos.
     *
     * @param nomeAcesso O nome de acesso do usuário.
     * @param nomeUsuario O nome do usuário.
     * @param senhaUsuario A senha do usuário.
     * @param descricaoEmail A descrição de e-mail do usuário.
     * @param obsUsuario Observações associadas ao usuário.
     * @return Um objeto Usuario com os dados fornecidos.
     */
    private Usuario criarUsuarioDTO(String nomeAcesso, String nomeUsuario, String senhaUsuario, String descricaoEmail, String obsUsuario) {
        Usuario usuarioDTO = new Usuario();
        usuarioDTO.setNomeAcesso(nomeAcesso);
        usuarioDTO.setNomeUsuario(nomeUsuario);
        usuarioDTO.setSenhaUsuario(senhaUsuario);
        usuarioDTO.setDescricaoEmail(descricaoEmail);
        usuarioDTO.setObsUsuario(obsUsuario);
        return usuarioDTO;
    }

    /**
     * Exibe uma mensagem na interface gráfica usando a classe JOptionPane.
     *
     * @param mensagem A mensagem a ser exibida.
     */
    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Retorna para a tela de login.
     */
    public void retornarParaLogin() {
        View.frmLoginVIEW loginView = new View.frmLoginVIEW();
        loginView.setVisible(true);
        view.dispose();
    }

    /**
     * Alterna a visibilidade da senha na interface gráfica.
     */
    public void mostrarSenha() {
        if (view.btnMostrarSenha.isSelected()) {
            view.txtSenhaUsuario.setEchoChar((char) 0);
            view.txtValidaSenhaUsuario.setEchoChar((char) 0);
        } else {
            view.txtSenhaUsuario.setEchoChar('\u25cf');
            view.txtValidaSenhaUsuario.setEchoChar('\u25cf');
        }
    }

}
