/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.sessaoUsuario;

/**
 *
 * @author 0103250
 */

import Model.SessaoUsuario;

import io.cucumber.java.pt.*;

public class SessaoUsuarioSteps {
    SessaoUsuario sessaoUsuario = SessaoUsuario.getInstance(); // Certifique-se de importar a classe SessaoUsuario corretamente

    @Dado("que o usuário não tem uma sessão ativa")
    public void usuarioNaoTemSessaoAtiva() {
        sessaoUsuario.setCOD_USUARIO(0);
    }

    @Quando("o usuário inicia uma sessão com o código do usuário {int}")
    public void iniciarSessao(int codigoUsuario) {
        sessaoUsuario.setCOD_USUARIO(codigoUsuario);
    }

    @Entao("a sessão do usuário deve ser iniciada")
    public void sessaoUsuarioDeveSerIniciada() {
        assert sessaoUsuario.getCOD_USUARIO() != 0;
    }

    @E("o código do usuário na sessão deve ser {int}")
    public void verificarCodigoUsuarioNaSessao(int codigoEsperado) {
        assert sessaoUsuario.getCOD_USUARIO() == codigoEsperado;
    }

    @Dado("que o usuário tem uma sessão ativa")
    public void usuarioTemSessaoAtiva() {
        sessaoUsuario.setCOD_USUARIO(123); // Simulando uma sessão ativa para o cenário
    }

    @Quando("o usuário encerra a sessão")
    public void encerrarSessao() {
        sessaoUsuario.setCOD_USUARIO(0);
    }

    @Entao("a sessão do usuário deve ser encerrada")
    public void sessaoUsuarioDeveSerEncerrada() {
        assert sessaoUsuario.getCOD_USUARIO() == 0;
    }
}