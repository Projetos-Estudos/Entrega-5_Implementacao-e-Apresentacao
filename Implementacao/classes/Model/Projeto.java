/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.time.LocalDateTime;

/**
 * Representa um projeto no sistema. Contém atributos que descrevem as
 * características do projeto. Permite acesso e modificação dessas informações.
 *
 * @author Erick Lopes
 */
public class Projeto {

    // Atributos da classe
    private int CodProjeto;
    private String NomeProjeto;
    private LocalDateTime DataCtrInclusao;
    private Date DataCtrInicio;
    private Date DataCtrPrevisaoTermino;
    private Date DataCtrTermino;
    private String DescricaoProjeto;

    // Métodos de acesso aos atributos da classe
    
    /**
     * Obtém o identificador único do projeto.
     *
     * @return O identificador único do projeto.
     */
    public int getCodProjeto() {
        return CodProjeto;
    }
    
    /**
     * Define o identificador único do projeto.
     *
     * @param CodProjeto O identificador único do projeto a ser definido.
     */
    public void setCodProjeto(int CodProjeto) {
        this.CodProjeto = CodProjeto;
    }
    
    /**
     * Obtém o nome do projeto.
     *
     * @return O nome do projeto.
     */
    public String getNomeProjeto() {
        return NomeProjeto;
    }
    
    /**
     * Define o nome do projeto.
     *
     * @param NomeProjeto O nome do projeto a ser definido.
     */
    public void setNomeProjeto(String NomeProjeto) {
        this.NomeProjeto = NomeProjeto;
    }
    
    /**
     * Obtém a data de inclusão do projeto no sistema.
     *
     * @return A data de inclusão do projeto.
     */
    public LocalDateTime getDataCtrInclusao() {
        return DataCtrInclusao;
    }
    
    /**
     * Define a data de inclusão do projeto no sistema.
     *
     * @param DataCtrInclusao A data de inclusão do projeto a ser definida.
     */
    public void setDataCtrInclusao(LocalDateTime DataCtrInclusao) {
        this.DataCtrInclusao = DataCtrInclusao;
    }

    /**
     * Obtém a data de início do projeto.
     *
     * @return A data de início do projeto.
     */
    public Date getDataCtrInicio() {
        return DataCtrInicio;
    }

    /**
     * Define a data de início do projeto.
     *
     * @param DataCtrInicio A data de início do projeto a ser definida.
     */
    public void setDataCtrInicio(Date DataCtrInicio) {
        this.DataCtrInicio = DataCtrInicio;
    }

    /**
     * Obtém a data prevista para o término do projeto.
     *
     * @return A data prevista para o término do projeto.
     */
    public Date getDataCtrPrevisaoTermino() {
        return DataCtrPrevisaoTermino;
    }

    /**
     * Define a data prevista para o término do projeto.
     *
     * @param DataCtrPrevisaoTermino A data prevista para o término do projeto a
     * ser definida.
     */
    public void setDataCtrPrevisaoTermino(Date DataCtrPrevisaoTermino) {
        this.DataCtrPrevisaoTermino = DataCtrPrevisaoTermino;
    }

    /**
     * Obtém a data de término efetiva do projeto.
     *
     * @return A data de término efetiva do projeto.
     */
    public Date getDataCtrTermino() {
        return DataCtrTermino;
    }

    /**
     * Define a data de término efetiva do projeto.
     *
     * @param DataCtrTermino A data de término efetiva do projeto a ser
     * definida.
     */
    public void setDataCtrTermino(Date DataCtrTermino) {
        this.DataCtrTermino = DataCtrTermino;
    }

    /**
     * Obtém a descrição do projeto.
     *
     * @return A descrição do projeto.
     */
    public String getDescricaoProjeto() {
        return DescricaoProjeto;
    }

    /**
     * Define a descrição do projeto.
     *
     * @param DescricaoProjeto A descrição do projeto a ser definida.
     */
    public void setDescricaoProjeto(String DescricaoProjeto) {
        this.DescricaoProjeto = DescricaoProjeto;
    }
}
