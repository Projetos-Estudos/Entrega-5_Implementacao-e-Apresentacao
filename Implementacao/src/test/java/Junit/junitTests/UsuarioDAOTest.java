package Junit.junitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import Model.Usuario;
import DAO.UsuarioDAO;

@Tag("dev")
public class UsuarioDAOTest {

    @Test
    public void testAutenticacaoUsuario() {
        // Preparação do Teste
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNomeAcesso("Admin");
        usuario.setSenhaUsuario("123");

        // Execução do Teste
        java.sql.ResultSet rs = usuarioDAO.autenticacaoUsuario(usuario);

        // Verificação
        assertNotNull(rs, "O resultado da autenticação não deveria ser nulo");
    }
    @Test
    public void testInserirUsuario() {
        // Preparação do Teste
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNomeAcesso("novoUsuario");
        usuario.setNomeUsuario("Novo Usuário");
        usuario.setSenhaUsuario("novaSenha");
        usuario.setDescricaoEmail("novoUsuario@gmail.com");
        usuario.setObsUsuario("Observação do novo usuário");

        // Execução do Teste
        boolean resultado = usuarioDAO.inserirUsuario(usuario);

        // Verificação
        assertTrue(resultado, "Falha ao inserir o novo usuário");
    }
    @Test
    public void testNomeAcessoExistente() {
        // Preparação do Teste
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String nomeAcessoExistente = "Admin";

        // Execução do Teste
        boolean resultado = usuarioDAO.nomeAcessoExistente(nomeAcessoExistente);

        // Verificação
        assertTrue(resultado, "O nome de acesso deveria existir");
     
    }
    
    @Test
    public void testObterCodigoUsuarioPorNomeAcesso() {
        // Preparação do Teste
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String nomeAcesso = "Admin";
        int codigoEsperado = 1; // Substitua pelo código esperado correspondente ao nome de acesso

        // Execução do Teste
        int codigoUsuario = usuarioDAO.obterCodigoUsuarioPorNomeAcesso(nomeAcesso);

        // Verificação
        assertEquals(codigoEsperado, codigoUsuario, "O código do usuário não corresponde ao esperado");
    }
    
}