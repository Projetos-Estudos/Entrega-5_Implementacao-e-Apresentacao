/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProjetoDAO;
import Model.Projeto;
import View.frmCriarProjetoVIEW;
import java.awt.HeadlessException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Classe frmCriarProjetoController: Controla a lógica de interação entre a
 * interface gráfica e a camada de acesso a dados para a criação de projetos.
 *
 * Autor: Erick Lopes
 */
public class frmCriarProjetoController {

    private frmCriarProjetoVIEW view;

    /**
     * Construtor da classe.
     *
     * @param view Instância da interface gráfica associada a este controlador.
     */
    public frmCriarProjetoController(frmCriarProjetoVIEW view) {
        this.view = view;
    }

    /**
     * Limpa os campos da interface gráfica relacionados à criação de projetos.
     */
    public void limparCampos() {
        view.txtNomeProjeto.setText("");
        view.DataCtrInicio.setDate(null);
        view.DataCtrPrevisaoTermino.setDate(null);
        view.txtDescricaoProjeto.setText("");
    }

    /**
     * Cadastra um novo projeto com base nos dados fornecidos pela interface
     * gráfica.
     *
     * @param view Instância da interface gráfica com os dados do projeto.
     */
    public void cadastrarProjeto(frmCriarProjetoVIEW view) {
        String NomeProjeto = view.txtNomeProjeto.getText();
        Date DataCtrInicio = view.DataCtrInicio.getDate();
        Date DataCtrPrevisaoTermino = view.DataCtrPrevisaoTermino.getDate();
        String DescricaoProjeto = view.txtDescricaoProjeto.getText();

        if (NomeProjeto.isEmpty() || DataCtrInicio == null) {
            JOptionPane.showMessageDialog(null, "Os campos Nome do Projeto e Data de Início são obrigatórios.");
        } else {
            try {
                Projeto projetoDTO = new Projeto();
                projetoDTO.setNomeProjeto(NomeProjeto);
                projetoDTO.setDataCtrInicio(DataCtrInicio);

                if (DataCtrPrevisaoTermino != null) {
                    projetoDTO.setDataCtrPrevisaoTermino(DataCtrPrevisaoTermino);
                }

                if (DescricaoProjeto != null && !DescricaoProjeto.isEmpty()) {
                    projetoDTO.setDescricaoProjeto(DescricaoProjeto);
                }

                ProjetoDAO projetoDAO = new ProjetoDAO();
                boolean inseridoComSucesso = projetoDAO.inserirProjeto(projetoDTO);

                if (inseridoComSucesso) {
                    JOptionPane.showMessageDialog(null, "Projeto cadastrado com sucesso!");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao cadastrar projeto.");
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
            }
        }
    }
}
