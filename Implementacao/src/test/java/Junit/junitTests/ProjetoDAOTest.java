package Junit.junitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import DAO.ProjetoDAO;
import Model.Projeto;
import java.time.LocalDateTime;
import java.util.Date;

@Tag("dev")
public class ProjetoDAOTest {

    @Test
    public void testInserirProjeto() {
        // Preparação do Teste
        ProjetoDAO projetoDAO = new ProjetoDAO();
        Projeto projeto = new Projeto();
        projeto.setNomeProjeto("Novo Projeto");
        projeto.setDataCtrInclusao(LocalDateTime.now()); // Assuming this is set automatically
        projeto.setDataCtrInicio(new Date());
        projeto.setDescricaoProjeto("teste");

        // Set other required fields for the project
        // Execução do Teste
        boolean resultado = projetoDAO.inserirProjeto(projeto);

        System.out.println(resultado);
        // Verificação
        assertTrue(resultado, "Falha ao inserir o novo projeto");
    }

    @Test
    public void testAtualizarProjeto() {
        // Preparação do Teste
        ProjetoDAO projetoDAO = new ProjetoDAO();
        Projeto projeto = new Projeto();
        projeto.setNomeProjeto("Edit Projeto");
        projeto.setDataCtrInclusao(LocalDateTime.now()); // Assuming this is set automatically
        projeto.setDataCtrInicio(new Date());
        projeto.setDescricaoProjeto("teste edit");
        projeto.setCodProjeto(24);
        // Set the project details including the project code to update

        // Execução do Teste
        boolean resultado = projetoDAO.atualizarProjeto(projeto);

        // Verificação
        assertTrue(resultado, "Falha ao atualizar o projeto");
    }

    @Test
    public void testExcluirProjeto() {
        // Preparação do Teste
        ProjetoDAO projetoDAO = new ProjetoDAO();
        int codigoProjeto = 5; // Replace with a valid project code

        // Execução do Teste
        boolean resultado = projetoDAO.excluirProjeto(codigoProjeto);

        // Verificação
        assertTrue(resultado, "Falha ao excluir o projeto");
    }

    @Test
    public void testUsuariosAssociadosAoProjeto() {
        // Preparação do Teste
        ProjetoDAO projetoDAO = new ProjetoDAO();
        int codigoProjeto = 15; // Replace with a valid project code

        // Execução do Teste
        boolean resultado = projetoDAO.usuariosAssociadosAoProjeto(codigoProjeto);

        // Verificação
        assertTrue(resultado, "Deveria haver usuários associados ao projeto");
    }

    @Test
    public void testRemoverUsuariosAssociadosAoProjeto() {
        // Preparação do Teste
        ProjetoDAO projetoDAO = new ProjetoDAO();
        int codigoProjeto = 15; // Replace with a valid project code

        // Execução do Teste
        boolean resultado = projetoDAO.removerUsuariosAssociadosAoProjeto(codigoProjeto);

        // Verificação
        assertTrue(resultado, "Falha ao remover usuários associados ao projeto");
    }

    @Test
    public void testUnicoParticipante() {
        // Preparação do Teste
        ProjetoDAO projetoDAO = new ProjetoDAO();
        int codigoProjeto = 36; // Replace with a valid project code

        // Execução do Teste
        boolean resultado = projetoDAO.unicoParticipante(codigoProjeto);

        // Verificação
        assertTrue(resultado, "Deveria haver apenas um participante associado ao projeto");
    }

    @Test
    public void testAdministradorDoProjeto() {
        // Preparação do Teste
        ProjetoDAO projetoDAO = new ProjetoDAO();
        int codUsuario = 1; // Replace with a valid user code
        int codProjeto = 35; // Replace with a valid project code

        // Execução do Teste
        boolean resultado = projetoDAO.administradorDoProjeto(codUsuario, codProjeto);

        // Verificação
        assertTrue(resultado, "O usuário deveria ser um administrador do projeto");
    }

    @Test
    public void testInserirParticipanteNoProjeto() {
        // Preparação do Teste
        ProjetoDAO projetoDAO = new ProjetoDAO();
        int codigoProjeto = 24; // Replace with a valid project code
        String codigoParticipante = "8"; // Replace with a valid user code

        // Execução do Teste
        boolean resultado = projetoDAO.inserirParticipanteNoProjeto(codigoProjeto, codigoParticipante);

        // Verificação
        assertTrue(resultado, "Falha ao inserir o participante no projeto");
    }
}
