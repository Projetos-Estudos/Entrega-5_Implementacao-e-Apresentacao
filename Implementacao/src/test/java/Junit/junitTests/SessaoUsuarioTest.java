package Junit.junitTests;

import Model.SessaoUsuario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("dev")
public class SessaoUsuarioTest {

    private SessaoUsuario sessaoUsuario;

    @BeforeEach
    public void setUp() {
        sessaoUsuario = SessaoUsuario.getInstance();
    }

    @Test
    public void testGetInstance() {
        // Verificar se a instância não é nula
        assertNotNull(sessaoUsuario);

        // Verificar se a instância é a mesma em chamadas subsequentes
        assertSame(sessaoUsuario, SessaoUsuario.getInstance());
    }

    @Test
    public void testGetSetCOD_USUARIO() {
        // Definir um código de usuário
        int codigoUsuario = 123;
        sessaoUsuario.setCOD_USUARIO(codigoUsuario);

        // Verificar se o código de usuário obtido é o mesmo que foi definido
        assertEquals(codigoUsuario, sessaoUsuario.getCOD_USUARIO());
    }
}
