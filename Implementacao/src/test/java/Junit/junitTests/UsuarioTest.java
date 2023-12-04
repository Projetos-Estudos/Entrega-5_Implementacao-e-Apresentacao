package Junit.junitTests;

import Model.Usuario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("dev")
public class UsuarioTest {

    @Test
    public void testGetSetCodUsuario() {
        // Criar uma instância de Usuario
        Usuario usuario = new Usuario();

        // Definir um código de usuário
        int codigoUsuario = 1;
        usuario.setCodUsuario(codigoUsuario);

        // Verificar se o código de usuário obtido é o mesmo que foi definido
        assertEquals(codigoUsuario, usuario.getCodUsuario());
    }

    @Test
    public void testGetSetNomeAcesso() {
        Usuario usuario = new Usuario();

        // Definir um nome de acesso
        String nomeAcesso = "usuario123";
        usuario.setNomeAcesso(nomeAcesso);

        // Verificar se o nome de acesso obtido é o mesmo que foi definido
        assertEquals(nomeAcesso, usuario.getNomeAcesso());
    }

    // Testes semelhantes para os outros campos (NomeUsuario, SenhaUsuario, etc.)

    @Test
    public void testGetSetObsUsuario() {
        Usuario usuario = new Usuario();

        // Definir uma observação de usuário
        String obsUsuario = "Observação do usuário";
        usuario.setObsUsuario(obsUsuario);

        // Verificar se a observação de usuário obtida é a mesma que foi definida
        assertEquals(obsUsuario, usuario.getObsUsuario());
    }
}
