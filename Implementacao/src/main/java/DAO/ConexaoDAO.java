/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela conexão com o banco de dados MySQL. Encapsula a
 * lógica de estabelecimento de conexão e provê uma instância da conexão ativa.
 * Utiliza o driver JDBC do MySQL para realizar a comunicação com o banco de
 * dados. Implementa o padrão Singleton para garantir uma única instância da
 * conexão.
 *
 * Observação: As credenciais de acesso (usuário e senha) e a URL do banco de
 * dados estão diretamente especificadas no código, o que pode representar uma
 * prática de segurança menos ideal. Para ambientes de produção, é recomendável
 * utilizar um mecanismo mais seguro para gerenciar essas informações.
 *
 * @author Erick Lopes
 */
public class ConexaoDAO {

    /**
     * Construtor padrão da classe ConexaoDAO. Este construtor não recebe
     * parâmetros e é responsável por criar uma instância da classe ConexaoDAO.
     * A lógica de inicialização e estabelecimento da conexão com o banco de
     * dados está implementada no método conectaBD().
     */
    public ConexaoDAO() {
        // Este construtor pode ser vazio, já que a lógica de inicialização está no método conectaBD()
    }

    /**
     * Estabelece uma conexão com o banco de dados MySQL e retorna a instância
     * de Connection.
     *
     * @return Uma instância de Connection representando a conexão com o banco
     * de dados.
     */
    public Connection conectaBD() {
        Connection conn = null;

        try {
            // URL de conexão com o banco de dados MySQL
            String url = "jdbc:mysql://localhost:3306/cbdata_gqs_a3?user=root&password=admin&useSSL=false";
            // Estabelecendo a conexão
            conn = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            // Exibindo mensagem de erro em caso de falha na conexão
            JOptionPane.showMessageDialog(null, erro);
        }
        return conn;
    }
}
