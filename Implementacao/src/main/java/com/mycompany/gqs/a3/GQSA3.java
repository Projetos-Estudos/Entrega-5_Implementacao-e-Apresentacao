/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gqs.a3;

/**
 * Classe principal que contém o método main e controla o fluxo de execução do sistema GQSA3.
 * Responsável por iniciar a aplicação, gerenciar o login do usuário e controlar a navegação entre telas.
 *
 * A classe utiliza o padrão MVC (Model-View-Controller), onde a classe GQSA3 atua como o controlador (Controller).
 * É responsável por instanciar a interface gráfica de login (frmLoginVIEW), autenticar o usuário e direcionar
 * para a tela principal (frmPrincipalVIEW) ou para a tela de criação de novo usuário (frmNovoUsuarioVIEW).
 *
 * Também incorpora a funcionalidade de mostrar/ocultar senha e configura o visual da aplicação usando o FlatLaf.
 *
 * @author Erick Lopes
 */
import View.frmLoginVIEW;
import Model.Usuario;
import DAO.UsuarioDAO;
import Model.SessaoUsuario;
import View.frmNovoUsuarioVIEW;
import View.frmPrincipalVIEW;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;


public class GQSA3 {
    
    // Referência à interface gráfica de login
    private frmLoginVIEW view; 

    /**
     * Cria uma nova instância da classe GQSA3.
     *
     * @param view A interface gráfica de login associada a este controlador.
     */
    public GQSA3(frmLoginVIEW view) {
        this.view = view;
    }
    
    /**
     * Método principal para realizar o login do usuário. Recebe o nome de acesso e a senha,
     * valida os dados, e se a autenticação for bem-sucedida, direciona para a tela principal.
     *
     * @param nomeAcesso O nome de acesso fornecido pelo usuário.
     * @param senhaUsuario A senha fornecida pelo usuário.
     */
    public void logar(String nomeAcesso, String senhaUsuario) {
        try {
            if (nomeAcesso == null || nomeAcesso.isEmpty() || senhaUsuario == null || senhaUsuario.isEmpty()) {
                exibirMensagemErro("Nome de usuário ou senha não podem estar em branco.");
            } else {
                Usuario objusuariodto = new Usuario();
                objusuariodto.setNomeAcesso(nomeAcesso);
                objusuariodto.setSenhaUsuario(senhaUsuario);

                UsuarioDAO objusuariodao = new UsuarioDAO();
                java.sql.ResultSet rs = objusuariodao.autenticacaoUsuario(objusuariodto);

                if (rs.next()) {
                    SessaoUsuario sessao = SessaoUsuario.getInstance();
                    sessao.setCOD_USUARIO(rs.getInt("COD_USUARIO"));
                    abrirFrmPrincipal();
                } else {
                    exibirMensagemErro("Nome de usuário ou senha incorretos.");
                }
            }
        } catch (Exception erro) {
            exibirMensagemErro("Erro: " + erro.getMessage());
        }
    }

    /**
     * Abre a tela principal após a autenticação bem-sucedida.
     */
    public void abrirFrmPrincipal() {
        frmPrincipalVIEW objfrmprincipalview = new frmPricipalVIEW();
        objfrmprincipalview.setVisible(true);
        view.dispose();
    }
    
    /**
     * Abre a tela de criação de novo usuário.
     */
    public void abrirFrmNovoUsuario() {
        frmNovoUsuarioVIEW objfrmnovousuarioview = new frmNovoUsuarioVIEW();
        objfrmnovousuarioview.setVisible(true);
        view.dispose();
    }

    /**
     * Exibe uma mensagem de erro em uma caixa de diálogo.
     *
     * @param mensagem A mensagem de erro a ser exibida.
     */
    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    /**
     * Alterna a visibilidade da senha no campo de senha da interface gráfica.
     */
    public void mostrarSenha() {
        if (view.btnMostrarSenha.isSelected()) {
            view.txtSenhaUsuario.setEchoChar((char) 0);
        } else {
            view.txtSenhaUsuario.setEchoChar('\u25cf');
        }
    }
    
    /**
     * Método main que inicia a aplicação. Configura o visual usando o FlatLaf e exibe a tela de login.
     *
     * @param args Os argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        frmLoginVIEW view = new frmLoginVIEW();
        view.setVisible(true);
    }
    
    /**
     * Classe interna que estende frmPrincipalVIEW para fornecer uma instância
     * de tela principal específica para esta aplicação.
     */
    private static class frmPricipalVIEW extends frmPrincipalVIEW {

        public frmPricipalVIEW() {
        }
    }
}
