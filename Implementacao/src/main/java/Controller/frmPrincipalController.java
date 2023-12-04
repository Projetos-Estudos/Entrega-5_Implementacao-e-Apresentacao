/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.SessaoUsuario;
import View.frmConsultarProjetosVIEW;
import View.frmCriarProjetoVIEW;
import View.frmLoginVIEW;
import View.frmPrincipalVIEW;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * Controlador responsável por gerenciar a lógica de negócios associada à
 * interface principal do sistema. Controla o login, a criação e listagem de
 * projetos, e outras operações relacionadas à interface principal.
 *
 * @author Erick Lopes
 */
public class frmPrincipalController {

    private frmPrincipalVIEW view;

    /**
     * Construtor que recebe a referência para a view principal.
     *
     * @param view A instância da view principal.
     */
    public frmPrincipalController(frmPrincipalVIEW view) {
        this.view = view;
    }

    /**
     * Método realiza o logout do usuário, encerrando a sessão e redirecionando
     * para a tela de login.
     */
    public void logout() {
        SessaoUsuario sessao = SessaoUsuario.getInstance();
        sessao.setCOD_USUARIO(0);
        frmLoginVIEW loginView = new frmLoginVIEW();
        loginView.setVisible(true);
        view.dispose();
    }

    /**
     * Método verifica se uma determinada tela já está aberta na área de
     * trabalho.
     *
     * @param classe A classe da tela desejada.
     * @return true se a tela estiver aberta, false caso contrário.
     */
    private boolean isTelaAberta(Class<?> classe) {
        JInternalFrame[] janelas = view.jDesktopPane1.getAllFrames();
        for (JInternalFrame janela : janelas) {
            if (classe.isInstance(janela)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método abre a tela de criação de projeto se ela ainda não estiver aberta
     * na área de trabalho. Caso contrário, exibe uma mensagem informando que a
     * tela já está aberta.
     */
    public void CriarProjeto() {
        if (!isTelaAberta(frmCriarProjetoVIEW.class)) {
            frmCriarProjetoVIEW obj = new frmCriarProjetoVIEW();
            view.jDesktopPane1.add(obj);
            obj.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "A tela está aberta na area de trabalho.");
        }
    }

    /**
     * Método abre a tela de listagem de projetos se ela ainda não estiver
     * aberta na área de trabalho. Caso contrário, exibe uma mensagem informando
     * que a tela já está aberta.
     */
    public void ListarProjeto() {
        if (!isTelaAberta(frmConsultarProjetosVIEW.class)) {
            frmConsultarProjetosVIEW obj = new frmConsultarProjetosVIEW();
            view.jDesktopPane1.add(obj);
            obj.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "A tela está aberta na area de trabalho.");
        }
    }
}
