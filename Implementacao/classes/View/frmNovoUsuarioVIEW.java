/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.FrmNovoUsuarioController;
import java.awt.Frame;

/**
 * Classe que representa a interface gráfica de cadastro de novo usuário no
 * sistema. Utiliza a classe FrmNovoUsuarioController como controlador para
 * gerenciar as interações e a lógica. Permite que o usuário insira informações
 * para criar uma nova conta.
 *
 * @author Erick Lopes
 */
public class frmNovoUsuarioVIEW extends javax.swing.JFrame {

    // Controlador associado a esta interface
    private FrmNovoUsuarioController controller;

    /**
     * Cria uma nova instância da classe frmNovoUsuarioVIEW. Inicializa os
     * componentes da interface e instancia o controlador.
     */
    public frmNovoUsuarioVIEW() {
        initComponents();
        controller = new FrmNovoUsuarioController(this); // Inicialize o controlador
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EncerrarView = new javax.swing.JButton();
        MinimizarView = new javax.swing.JButton();
        txtNomeAcesso = new javax.swing.JTextField();
        txtNomeUsuario = new javax.swing.JTextField();
        txtDescricaoEmail = new javax.swing.JTextField();
        EncerrarView1 = new javax.swing.JButton();
        MinimizarView1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BtnRetornaFrmLoginVIEW = new javax.swing.JToggleButton();
        LimparCampos = new javax.swing.JToggleButton();
        CadastrarUsuario = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObsUsuario = new javax.swing.JEditorPane();
        txtValidaSenhaUsuario = new javax.swing.JPasswordField();
        txtSenhaUsuario = new javax.swing.JPasswordField();
        btnMostrarSenha = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        EncerrarView.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        EncerrarView.setForeground(new java.awt.Color(0, 0, 0));
        EncerrarView.setText("X");
        EncerrarView.setContentAreaFilled(false);
        EncerrarView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncerrarViewActionPerformed(evt);
            }
        });

        MinimizarView.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MinimizarView.setForeground(new java.awt.Color(0, 0, 0));
        MinimizarView.setText("-");
        MinimizarView.setContentAreaFilled(false);
        MinimizarView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinimizarViewActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 300));
        setUndecorated(true);
        getContentPane().setLayout(null);

        txtNomeAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAcessoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomeAcesso);
        txtNomeAcesso.setBounds(30, 100, 150, 22);
        getContentPane().add(txtNomeUsuario);
        txtNomeUsuario.setBounds(30, 150, 150, 22);

        txtDescricaoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescricaoEmail);
        txtDescricaoEmail.setBounds(30, 200, 150, 22);

        EncerrarView1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        EncerrarView1.setForeground(new java.awt.Color(255, 255, 255));
        EncerrarView1.setText("X");
        EncerrarView1.setBorder(null);
        EncerrarView1.setContentAreaFilled(false);
        EncerrarView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncerrarView1ActionPerformed(evt);
            }
        });
        getContentPane().add(EncerrarView1);
        EncerrarView1.setBounds(620, 0, 50, 30);

        MinimizarView1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MinimizarView1.setForeground(new java.awt.Color(255, 255, 255));
        MinimizarView1.setText("-");
        MinimizarView1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MinimizarView1.setBorderPainted(false);
        MinimizarView1.setContentAreaFilled(false);
        MinimizarView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinimizarView1ActionPerformed(evt);
            }
        });
        getContentPane().add(MinimizarView1);
        MinimizarView1.setBounds(570, 0, 50, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome de Acesso:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 150, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome do Usuário:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 150, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("E-mail:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 180, 150, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Senha:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(200, 80, 150, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Confirme sua senha:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(200, 130, 150, 20);

        BtnRetornaFrmLoginVIEW.setText("Voltar");
        BtnRetornaFrmLoginVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornaFrmLoginVIEWActionPerformed(evt);
            }
        });
        getContentPane().add(BtnRetornaFrmLoginVIEW);
        BtnRetornaFrmLoginVIEW.setBounds(30, 20, 70, 23);

        LimparCampos.setText("Limpar");
        LimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(LimparCampos);
        LimparCampos.setBounds(360, 320, 100, 23);

        CadastrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CadastrarUsuario.setText("Cadastre-se");
        CadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(CadastrarUsuario);
        CadastrarUsuario.setBounds(360, 290, 100, 23);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Observação:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 230, 150, 20);

        jScrollPane1.setViewportView(txtObsUsuario);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 250, 320, 90);
        getContentPane().add(txtValidaSenhaUsuario);
        txtValidaSenhaUsuario.setBounds(200, 150, 150, 22);
        getContentPane().add(txtSenhaUsuario);
        txtSenhaUsuario.setBounds(200, 100, 150, 22);

        btnMostrarSenha.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarSenha.setText("Visualizar");
        btnMostrarSenha.setBorder(null);
        btnMostrarSenha.setContentAreaFilled(false);
        btnMostrarSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrarSenha);
        btnMostrarSenha.setBounds(200, 180, 80, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CadastrarUser2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-100, 0, 770, 380);

        setSize(new java.awt.Dimension(670, 376));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Realiza a ação quando o botão de encerrar a interface é acionado. Este
     * método encerra a aplicação.
     *
     * @param evt O evento de ação que desencadeou este método.
     */
    private void EncerrarViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncerrarViewActionPerformed
        System.exit(0); // Encerre o programa
    }//GEN-LAST:event_EncerrarViewActionPerformed

    /**
     * Realiza a ação quando o botão de minimizar a interface é acionado. Este
     * método minimiza a janela.
     *
     * @param evt O evento de ação que desencadeou este método.
     */
    private void MinimizarViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinimizarViewActionPerformed
        this.setState(Frame.ICONIFIED); // Minimize a janela
    }//GEN-LAST:event_MinimizarViewActionPerformed

    /**
     * Realiza a ação quando o botão de encerrar a interface é acionado. Este
     * método encerra a aplicação.
     *
     * @param evt O evento de ação que desencadeou este método.
     */
    private void EncerrarView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncerrarView1ActionPerformed
        System.exit(0); // Encerre o programa
    }//GEN-LAST:event_EncerrarView1ActionPerformed

    /**
     * Realiza a ação quando o botão de minimizar a interface é acionado.
     * Este método minimiza a janela.
     * 
     * @param evt O evento de ação que desencadeou este método.
     */
    private void MinimizarView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinimizarView1ActionPerformed
        this.setState(Frame.ICONIFIED); // Minimize a janela
    }//GEN-LAST:event_MinimizarView1ActionPerformed

    private void txtDescricaoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoEmailActionPerformed
    /**
     * Realiza a ação quando o botão de voltar à tela de login é acionado.
     * Este método chama o método do controlador responsável por retornar à tela de login.
     * 
     * @param evt O evento de ação que desencadeou este método.
     */
    private void BtnRetornaFrmLoginVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornaFrmLoginVIEWActionPerformed
        controller.retornarParaLogin();
    }//GEN-LAST:event_BtnRetornaFrmLoginVIEWActionPerformed

    /**
     * Realiza a ação quando o botão de cadastrar usuário é acionado.
     * Este método chama o método do controlador responsável por cadastrar um novo usuário.
     * 
     * @param evt O evento de ação que desencadeou este método.
     */
    private void CadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarUsuarioActionPerformed
        controller.cadastrarUsuario(this);
    }//GEN-LAST:event_CadastrarUsuarioActionPerformed

    /**
     * Realiza a ação quando o botão de limpar campos é acionado.
     * Este método chama o método do controlador responsável por limpar os campos de texto.
     * 
     * @param evt O evento de ação que desencadeou este método.
     */
    private void LimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparCamposActionPerformed
        // Limpar os campos de texto
        controller.limparCampos();
    }//GEN-LAST:event_LimparCamposActionPerformed

    /**
     * Realiza a ação quando o nome de acesso é inserido.
     * Este método é chamado quando o usuário pressiona Enter após inserir o nome de acesso.
     * 
     * @param evt O evento de ação que desencadeou este método.
     */
    private void txtNomeAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAcessoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAcessoActionPerformed

    /**
     * Realiza a ação quando o botão de mostrar/ocultar senha é acionado.
     * Este método chama o método do controlador responsável por mostrar ou ocultar a senha digitada.
     * 
     * @param evt O evento de ação que desencadeou este método.
     */
    private void btnMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarSenhaActionPerformed
        controller.mostrarSenha();
    }//GEN-LAST:event_btnMostrarSenhaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton BtnRetornaFrmLoginVIEW;
    public javax.swing.JToggleButton CadastrarUsuario;
    private javax.swing.JButton EncerrarView;
    private javax.swing.JButton EncerrarView1;
    public javax.swing.JToggleButton LimparCampos;
    private javax.swing.JButton MinimizarView;
    private javax.swing.JButton MinimizarView1;
    public javax.swing.JCheckBox btnMostrarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtDescricaoEmail;
    public javax.swing.JTextField txtNomeAcesso;
    public javax.swing.JTextField txtNomeUsuario;
    public javax.swing.JEditorPane txtObsUsuario;
    public javax.swing.JPasswordField txtSenhaUsuario;
    public javax.swing.JPasswordField txtValidaSenhaUsuario;
    // End of variables declaration//GEN-END:variables
}