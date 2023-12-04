package Junit.junitTests;

import Model.Projeto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Date;

public class ProjetoTest {

    @Test
    public void testSetGetNomeProjeto() {
        Projeto projeto = new Projeto();

        // Definir um nome de projeto
        String nomeProjeto = "Meu Projeto";
        projeto.setNomeProjeto(nomeProjeto);

        // Verificar se o nome de projeto obtido é o mesmo que foi definido
        assertEquals(nomeProjeto, projeto.getNomeProjeto());
    }

    @Test
    public void testSetGetDataCtrInicio() {
        Projeto projeto = new Projeto();

        // Definir uma data de início
        Date dataInicio = new Date();
        projeto.setDataCtrInicio(dataInicio);

        // Verificar se a data de início obtida é a mesma que foi definida
        assertEquals(dataInicio, projeto.getDataCtrInicio());
    }

    @Test
    public void testSetGetDataCtrInclusao() {
        Projeto projeto = new Projeto();

        // Definir uma data de inclusão
        LocalDateTime dataInclusao = LocalDateTime.now();
        projeto.setDataCtrInclusao(dataInclusao);

        // Verificar se a data de inclusão obtida é a mesma que foi definida
        assertEquals(dataInclusao, projeto.getDataCtrInclusao());
    }

    @Test
    public void testSetGetDescricaoProjeto() {
        Projeto projeto = new Projeto();

        // Definir uma descrição de projeto
        String descricaoProjeto = "Descrição do Projeto";
        projeto.setDescricaoProjeto(descricaoProjeto);

        // Verificar se a descrição de projeto obtida é a mesma que foi definida
        assertEquals(descricaoProjeto, projeto.getDescricaoProjeto());
    }

    // Adicione testes para outros métodos conforme necessário

}
