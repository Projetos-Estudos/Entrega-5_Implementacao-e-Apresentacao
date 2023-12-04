/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.frmAlterarProjetoController;
import java.util.Date;
import javax.swing.JDialog;

/**
 * A classe representa a interface gráfica para a alteração de dados de um
 * projeto. Utiliza o padrão MVC (Model-View-Controller), onde esta classe atua
 * como a View. Responsável por exibir e coletar informações relacionadas à
 * alteração de um projeto.
 *
 * A classe possui campos para preenchimento de dados como nome, datas de
 * início, previsão de término, data de término e descrição do projeto. Além
 * disso, fornece métodos para preencher esses campos com informações de um
 * projeto existente.
 *
 * Os eventos na interface, como o clique no botão "Gravar", são tratados pelo
 * controller (frmAlterarProjetoController) associado.
 *
 * @author Erick Lopes
 */
public class frmAlterarProjetoVIEW extends JDialog {

    // Controlador associado a esta interface
    private frmAlterarProjetoController controller;

    /**
     * Cria uma nova instância da classe `frmAlterarProjetoVIEW`. Inicializa os
     * componentes da interface e instancia o controlador.
     */
    public frmAlterarProjetoVIEW() {
        initComponents();
        controller = new frmAlterarProjetoController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNomeProjeto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DataCtrPrevisaoTermino = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeProjeto1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DataCtrPrevisaoTermino1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        DataCtrInicio = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricaoProjeto = new javax.swing.JEditorPane();
        jLabel7 = new javax.swing.JLabel();
        CodProjeto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DataCtrTermino = new com.toedter.calendar.JDateChooser();
        btnGravar = new javax.swing.JButton();

        jLabel2.setText("Nome do Projeto:");

        jLabel4.setText("Previsão Término:");

        DataCtrPrevisaoTermino.setDateFormatString("dd/MM/yyyy");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Preencha os dados do Projeto");

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Projeto");
        setResizable(false);

        jLabel1.setText("Código");

        jLabel3.setText("Nome do Projeto:");

        txtNomeProjeto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProjeto1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Previsão Término:");

        DataCtrPrevisaoTermino1.setDateFormatString("dd/MM/yyyy");

        jLabel6.setText("Data de Inicio:");

        DataCtrInicio.setDateFormatString("dd/MM/yyyy");

        jScrollPane1.setViewportView(txtDescricaoProjeto);

        jLabel7.setText("Descrição do Projeto: ");

        CodProjeto.setEditable(false);
        CodProjeto.setActionCommand("null");
        CodProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodProjetoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Altere os dados do Projeto");

        jLabel11.setText("Data de Término:");

        DataCtrTermino.setDateFormatString("dd/MM/yyyy");

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGravar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CodProjeto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomeProjeto1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(DataCtrPrevisaoTermino1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DataCtrInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DataCtrTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CodProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNomeProjeto1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DataCtrInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DataCtrPrevisaoTermino1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(DataCtrTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGravar)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(731, 323));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método chamado ao clicar no botão "Gravar". Aciona o controller para
     * realizar a atualização do projeto com base nos dados preenchidos na
     * interface.
     *
     * @param evt O evento de clique no botão "Gravar".
     */
    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        controller.AtualizarProjeto(this);
    }//GEN-LAST:event_btnGravarActionPerformed

    /**
     * Método chamado quando o campo de código do projeto é modificado.
     * Atualmente não possui implementação, mas pode ser expandido conforme
     * necessário.
     *
     * @param evt O evento de modificação no campo de código do projeto.
     */
    private void CodProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodProjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodProjetoActionPerformed

    /**
     * Método chamado quando o campo de nome do projeto é modificado. Atualmente
     * não possui implementação, mas pode ser expandido conforme necessário.
     *
     * @param evt O evento de modificação no campo de nome do projeto.
     */
    private void txtNomeProjeto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProjeto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProjeto1ActionPerformed

    /**
     * Preenche os campos da interface com as informações de um projeto
     * existente.
     *
     * @param codigo O código do projeto.
     * @param nome O nome do projeto.
     * @param previsaoTermino A data de previsão de término do projeto.
     * @param inicio A data de início do projeto.
     * @param termino A data de término do projeto.
     * @param descricao A descrição do projeto.
     */
    public void preencherCamposProjeto(Object codigo, Object nome, Object previsaoTermino, Object inicio, Object termino, Object descricao) {
        CodProjeto.setText(codigo.toString());
        txtNomeProjeto1.setText(nome.toString());
        DataCtrPrevisaoTermino1.setDate((Date) previsaoTermino);
        DataCtrInicio.setDate((Date) inicio);
        DataCtrTermino.setDate((Date) termino);
        txtDescricaoProjeto.setText(descricao.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField CodProjeto;
    public com.toedter.calendar.JDateChooser DataCtrInicio;
    public com.toedter.calendar.JDateChooser DataCtrPrevisaoTermino;
    public com.toedter.calendar.JDateChooser DataCtrPrevisaoTermino1;
    public com.toedter.calendar.JDateChooser DataCtrTermino;
    private javax.swing.JButton btnGravar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JEditorPane txtDescricaoProjeto;
    public javax.swing.JTextField txtNomeProjeto;
    public javax.swing.JTextField txtNomeProjeto1;
    // End of variables declaration//GEN-END:variables
}