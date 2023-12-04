/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Representa a sessão do usuário no sistema. Responsável por armazenar e
 * fornecer o identificador do usuário associado à sessão. Utiliza o padrão
 * Singleton para garantir uma única instância global.
 *
 * @author Erick Lopes
 */
public class SessaoUsuario {

    // Atributos da classe
    private static SessaoUsuario instance;
    private int COD_USUARIO;

    // Construtor privado para aplicação do padrão Singleton
    private SessaoUsuario() {
    }
    
    // Método estático que retorna a instância única da classe
    public static SessaoUsuario getInstance() {
        if (instance == null) {
            instance = new SessaoUsuario();
        }
        return instance;
    }

    // Métodos de acesso aos atributos da classe
    
    /**
     * Obtém o identificador do usuário na sessão.
     *
     * @return O identificador do usuário associado à sessão.
     */
    public int getCOD_USUARIO() {
        return COD_USUARIO;
    }

    /**
     * Define o identificador do usuário na sessão.
     *
     * @param COD_USUARIO O identificador do usuário a ser associado à sessão.
     */
    public void setCOD_USUARIO(int COD_USUARIO) {
        this.COD_USUARIO = COD_USUARIO;
    }
}
