package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe que fornece métodos para interação com a tabela USUARIO no banco de dados,
 * incluindo autenticação, inserção, verificação de existência de nome de acesso e obtenção do código de usuário.
 
 * @author Erick Lopes
 */
public class UsuarioDAO {

    Connection conn;
    
    /**
     * Autentica um usuário com base nas informações fornecidas.
     *
     * @param objusuariodto Objeto contendo as informações do usuário para autenticação.
     * @return Um ResultSet contendo os dados do usuário autenticado ou null se a autenticação falhar.
     */
    public java.sql.ResultSet autenticacaoUsuario(Usuario objusuariodto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT * FROM USUARIO WHERE (NOM_ACESSO = ? OR NOM_USUARIO = ?) AND SENHA_USUARIO = ?";

            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNomeAcesso());
            pstm.setString(2, objusuariodto.getNomeAcesso());
            pstm.setString(3, objusuariodto.getSenhaUsuario());

            java.sql.ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
    
    /**
     * Insere um novo usuário no banco de dados com base nas informações fornecidas no objeto usuarioDTO.
     *
     * @param usuarioDTO Objeto contendo as informações do usuário a ser inserido.
     * @return True se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean inserirUsuario(Usuario usuarioDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "INSERT INTO USUARIO (NOM_ACESSO, NOM_USUARIO, SENHA_USUARIO, DSC_EMAIL, DSC_OBSERVACAO) VALUES (?, ?, ?, ?, ?)";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

            // Configurar os parâmetros com os valores do objeto usuarioDTO
            pstm.setString(1, usuarioDTO.getNomeAcesso());
            pstm.setString(2, usuarioDTO.getNomeUsuario());
            pstm.setString(3, usuarioDTO.getSenhaUsuario());
            pstm.setString(4, usuarioDTO.getDescricaoEmail());
            pstm.setString(5, usuarioDTO.getObsUsuario());

            int rowsAffected = pstm.executeUpdate();

            // Verificar se a inserção foi bem-sucedida
            if (rowsAffected > 0) {
                return true; // Usuário inserido com sucesso
            } else {
                return false; // Falha ao inserir usuário
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário: " + erro);
            return false;
        } finally {
            // Fechar a conexão com o banco de dados
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Verifica se um nome de acesso específico já existe no banco de dados.
     *
     * @param nomeAcesso Nome de acesso a ser verificado.
     * @return True se o nome de acesso já existir, false caso contrário.
     */
    public boolean nomeAcessoExistente(String nomeAcesso) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT COUNT(*) FROM USUARIO WHERE NOM_ACESSO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nomeAcesso);
            java.sql.ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Se o count for maior que 0, o nome de acesso já existe
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar a existência do nome de acesso: " + erro);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false; // Em caso de erro, retorne falso por padrão
    }
    
    /**
     * Obtém o código de um usuário com base no nome de acesso.
     *
     * @param nomeAcesso Nome de acesso do usuário.
     * @return O código do usuário ou -1 se o usuário não for encontrado.
     */
    public int obterCodigoUsuarioPorNomeAcesso(String nomeAcesso) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT COD_USUARIO FROM USUARIO WHERE NOM_ACESSO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nomeAcesso);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return rs.getInt("COD_USUARIO");
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1; // Retorna -1 se o usuário não for encontrado
    }
}
