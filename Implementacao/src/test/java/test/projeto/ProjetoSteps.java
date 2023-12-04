/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.projeto;

/**
 *
 * @author rafaelamoreira
 */
import Model.Projeto;
import io.cucumber.java.pt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class ProjetoSteps {
    private Projeto projeto;
    
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
    
    
  
   @Dado("um objeto Projeto")
    public void criarObjetoProjeto() {
        projeto = new Projeto();
    }

    @Quando("eu defino o código do projeto como {int}")
    public void definirCodigoProjeto(Integer codigo) {
        projeto.setCodProjeto(codigo);
    }

    @Então("o código do projeto deve ser {int}")
    public void verificarCodigoProjeto(int codigo) {
        assertEquals(codigo, projeto.getCodProjeto());
    }

    @Quando("eu defino o nome do projeto como {string}")
    public void definirNomeProjeto(String nome) {
        projeto.setNomeProjeto(nome);
    }

    @Então("o nome do projeto deve ser {string}")
    public void verificarNomeProjeto(String nome) {
        assertEquals(nome, projeto.getNomeProjeto());
    }

    @Quando("eu defino a data de inclusão do projeto como {string}")
    public void definirDataInclusaoProjeto(String data) {
        projeto.setDataCtrInclusao(LocalDateTime.parse(data));
    }

    @Então("a data de inclusão do projeto deve ser {string}")
    public void verificarDataInclusaoProjeto(String data) {
        assertEquals(LocalDateTime.parse(data), projeto.getDataCtrInclusao());
    }

    @Quando("eu defino a data de início do projeto como {string}")
    public void definirDataInicioProjeto(String data) {
        Date date = null;
        try {
            date = formato.parse(data);
            System.out.println("Data formatada: " + data);
        } catch (ParseException e) {
        }
        
        projeto.setDataCtrInicio(date);
    }

    @Então("a data de início do projeto deve ser {string}")
    public void verificarDataInicioProjeto(String data) {
             Date date = null;
        try {
            date = formato.parse(data);
            System.out.println("Data formatada: " + data);
        } catch (ParseException e) {
        }
        assertEquals(date, projeto.getDataCtrInicio());
    }

    @Quando("eu defino a data de previsão de término do projeto como {string}")
    public void definirDataPrevisaoTerminoProjeto(String data) {
          Date date = null;
        try {
            date = formato.parse(data);
            System.out.println("Data formatada: " + data);
        } catch (ParseException e) {
        }
        projeto.setDataCtrPrevisaoTermino(date);
    }

    @Então("a data de previsão de término do projeto deve ser {string}")
    public void verificarDataPrevisaoTerminoProjeto(String data) {
             Date date = null;
        try {
            date = formato.parse(data);
            System.out.println("Data formatada: " + data);
        } catch (ParseException e) {
        }
        assertEquals(date, projeto.getDataCtrPrevisaoTermino());
    }

    @Quando("eu defino a data de término do projeto como {string}")
    public void definirDataTerminoProjeto(String data) {
          Date date = null;
        try {
            date = formato.parse(data);
            System.out.println("Data formatada: " + data);
        } catch (ParseException e) {
        }
        projeto.setDataCtrTermino(date);
    }

    @Então("a data de término do projeto deve ser {string}")
    public void verificarDataTerminoProjeto(String data) {
                 Date date = null;
        try {
            date = formato.parse(data);
            System.out.println("Data formatada: " + data);
        } catch (ParseException e) {
        }
        assertEquals(date, projeto.getDataCtrTermino());
    }

    @Quando("eu defino a descrição do projeto como {string}")
    public void definirDescricaoProjeto(String descricao) {
        projeto.setDescricaoProjeto(descricao);
    }

    @Então("a descrição do projeto deve ser {string}")
    public void verificarDescricaoProjeto(String descricao) {
        assertEquals(descricao, projeto.getDescricaoProjeto());
    }

    // Implemente os demais passos de acordo com os atributos da classe Projeto
}