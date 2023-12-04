/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Representa um usuário no sistema. Contém atributos que descrevem as
 * características do usuário. Permite acesso e modificação dessas informações.
 *
 * @author Erick Lopes
 */
public class Usuario {

    // Atributos da classe
    private int CodUsuario;
    private String NomeAcesso, NomeUsuario, SenhaUsuario, ValidaSenhaUsuario, DescricaoEmail, ObsUsuario;

    // Métodos de acesso aos atributos da classe
    
    /**
     * Obtém o identificador único do usuário.
     *
     * @return O identificador único do usuário.
     */
    public int getCodUsuario() {
        return CodUsuario;
    }

    /**
     * Define o identificador único do usuário.
     *
     * @param CodUsuario O identificador único do usuário.
     */
    public void setCodUsuario(int CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    /**
     * Obtém o nome de acesso do usuário.
     *
     * @return O nome de acesso do usuário.
     */
    public String getNomeAcesso() {
        return NomeAcesso;
    }

    /**
     * Define o nome de acesso do usuário.
     *
     * @param NomeAcesso O nome de acesso do usuário.
     */
    public void setNomeAcesso(String NomeAcesso) {
        this.NomeAcesso = NomeAcesso;
    }

    /**
     * Obtém o nome completo do usuário.
     *
     * @return O nome completo do usuário.
     */
    public String getNomeUsuario() {
        return NomeUsuario;
    }

    /**
     * Define o nome completo do usuário.
     *
     * @param NomeUsuario O nome completo do usuário.
     */
    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getSenhaUsuario() {
        return SenhaUsuario;
    }

    /**
     * Define a senha do usuário.
     *
     * @param SenhaUsuario A senha do usuário.
     */
    public void setSenhaUsuario(String SenhaUsuario) {
        this.SenhaUsuario = SenhaUsuario;
    }

    /**
     * Obtém a senha validada do usuário.
     *
     * @return A senha validada do usuário.
     */
    public String getValidaSenhaUsuario() {
        return ValidaSenhaUsuario;
    }

    /**
     * Define a senha validada do usuário.
     *
     * @param ValidaSenhaUsuario A senha validada do usuário.
     */
    public void setValidaSenhaUsuario(String ValidaSenhaUsuario) {
        this.ValidaSenhaUsuario = ValidaSenhaUsuario;
    }

    /**
     * Obtém a descrição do e-mail do usuário.
     *
     * @return A descrição do e-mail do usuário.
     */
    public String getDescricaoEmail() {
        return DescricaoEmail;
    }

    /**
     * Define a descrição do e-mail do usuário.
     *
     * @param DescricaoEmail A descrição do e-mail do usuário.
     */
    public void setDescricaoEmail(String DescricaoEmail) {
        this.DescricaoEmail = DescricaoEmail;
    }

    /**
     * Obtém as observações sobre o usuário.
     *
     * @return As observações sobre o usuário.
     */
    public String getObsUsuario() {
        return ObsUsuario;
    }

    /**
     * Define as observações sobre o usuário.
     *
     * @param ObsUsuario As observações sobre o usuário.
     */
    public void setObsUsuario(String ObsUsuario) {
        this.ObsUsuario = ObsUsuario;
    }
}
