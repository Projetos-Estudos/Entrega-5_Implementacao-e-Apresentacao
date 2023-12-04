/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.usuario;

/**
 *
 * @author 0103250
 */


import Model.Usuario;

import io.cucumber.java.pt.*;

public class UsuarioSteps {
   Usuario usuario = new Usuario(); // Certifique-se de importar a classe Usuario corretamente

    @Dado("um objeto Usuario")
    public void criarObjetoUsuario() {
        usuario = new Usuario();
    }

    @Quando("eu defino o código do usuário como {int}")
    public void definirCodigoUsuario(int codigo) {
        usuario.setCodUsuario(codigo);
    }

    @Entao("o código do usuário deve ser {int}")
    public void verificarCodigoUsuario(int codigoEsperado) {
        assert usuario.getCodUsuario() == codigoEsperado;
    }

    @Quando("eu defino o nome de acesso do usuário como {string}")
    public void definirNomeAcessoUsuario(String nomeAcesso) {
        usuario.setNomeAcesso(nomeAcesso);
    }

    @Entao("o nome de acesso do usuário deve ser {string}")
    public void verificarNomeAcessoUsuario(String nomeAcessoEsperado) {
        assert usuario.getNomeAcesso().equals(nomeAcessoEsperado);
    }

    @Quando("eu defino a senha do usuário como {string}")
    public void definirSenhaUsuario(String senha) {
        usuario.setSenhaUsuario(senha);
    }

    @Entao("a senha do usuário deve ser {string}")
    public void verificarSenhaUsuario(String senhaEsperada) {
        assert usuario.getSenhaUsuario().equals(senhaEsperada);
    }
}