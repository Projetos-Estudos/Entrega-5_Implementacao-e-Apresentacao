/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Projeto;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Classe responsável por interagir com o banco de dados para operações
 * relacionadas a projetos. Encapsula a lógica de manipulação de dados na tabela
 * PROJETO e PROJETO_R_USUARIO. Implementa métodos para inserir, atualizar,
 * excluir e consultar informações sobre projetos e participantes. Utiliza a
 * classe ConexaoDAO para estabelecer conexão com o banco de dados.
 *
 * Observação: A implementação pode ser aprimorada considerando boas práticas de
 * segurança e tratamento de exceções mais detalhado.
 *
 * @author Erick Lopes
 */
public class ProjetoDAO {

    Connection conn;

    /**
     * Insere um novo projeto na tabela PROJETO e associa automaticamente o
     * usuário logado como administrador do projeto.
     *
     * @param projetoDTO Objeto Projeto contendo as informações do projeto a ser
     * inserido.
     * @return True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean inserirProjeto(Projeto projetoDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "INSERT INTO PROJETO (NOM_PROJETO, DAT_CTR_INICIO, DAT_CTR_PREVISAO_TERMINO, DSC_PROJETO) VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            configurarValoresPreparedStatement(pstm, projetoDTO);

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                int codProjeto = obterIdProjetoGerado(pstm);

                // Inserir um registro na tabela PROJETO_R_USUARIO
                int codUsuario = 1;
                boolean sucessoRegistroProjetoUsuario = inserirProjetoUsuario(codProjeto, codUsuario, true);

                // Retorna o sucesso da inserção na tabela intermediária
                return sucessoRegistroProjetoUsuario;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o projeto: " + erro);
        } finally {
            fecharConexao();
        }

        return false;
    }

    /**
     * Configura os valores no PreparedStatement para a inserção de um novo
     * projeto.
     *
     * @param pstm PreparedStatement a ser configurado.
     * @param projetoDTO Objeto Projeto contendo as informações do projeto.
     * @throws SQLException Se ocorrer um erro ao configurar os valores no
     * PreparedStatement.
     */
    private void configurarValoresPreparedStatement(java.sql.PreparedStatement pstm, Projeto projetoDTO) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pstm.setString(1, projetoDTO.getNomeProjeto());
        pstm.setString(2, sdf.format(projetoDTO.getDataCtrInicio()));

        if (projetoDTO.getDataCtrPrevisaoTermino() != null) {
            pstm.setString(3, sdf.format(projetoDTO.getDataCtrPrevisaoTermino()));
        } else {
            pstm.setNull(3, java.sql.Types.DATE);
        }

        if (projetoDTO.getDescricaoProjeto() != null && !projetoDTO.getDescricaoProjeto().isEmpty()) {
            pstm.setString(4, projetoDTO.getDescricaoProjeto());
        } else {
            pstm.setNull(4, java.sql.Types.VARCHAR);
        }
    }

    /**
     * Obtém o ID do projeto gerado após a inserção.
     *
     * @param pstm PreparedStatement após a execução da inserção.
     * @return O ID do projeto gerado.
     * @throws SQLException Se ocorrer um erro ao obter o ID gerado.
     */
    private int obterIdProjetoGerado(java.sql.PreparedStatement pstm) throws SQLException {
        ResultSet generatedKeys = pstm.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return -1; // Retorna -1 se não houver chaves geradas
    }

    /**
     * Fecha a conexão com o banco de dados.
     */
    private void fecharConexao() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Insere um registro na tabela intermediária PROJETO_R_USUARIO para
     * associar um usuário a um projeto.
     *
     * @param codProjeto Código do projeto a ser associado.
     * @param codUsuario Código do usuário a ser associado.
     * @param indicadorAdministrador Indica se o usuário será um administrador
     * do projeto.
     * @return True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean inserirProjetoUsuario(int codProjeto, int codUsuario, boolean indicadorAdministrador) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "INSERT INTO PROJETO_R_USUARIO (COD_PROJETO, COD_USUARIO, INDICADOR_ADMINISTRADOR) VALUES (?, ?, ?)";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, codProjeto);
            pstm.setInt(2, codUsuario);
            pstm.setBoolean(3, indicadorAdministrador);

            int rowsAffected = pstm.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o registro na tabela intermediária: " + erro);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false; // Retorna falso se houver algum erro
    }

    /**
     * Atualiza as informações de um projeto existente na base de dados.
     *
     * @param projetoDTO Objeto Projeto contendo as novas informações do
     * projeto.
     * @return True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean atualizarProjeto(Projeto projetoDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "UPDATE PROJETO SET NOM_PROJETO = ?, DAT_CTR_INICIO = ?, DAT_CTR_PREVISAO_TERMINO = ?, DAT_CTR_TERMINO = ?, DSC_PROJETO = ? WHERE COD_PROJETO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            configurarValoresPreparedStatement(pstm, projetoDTO, sdf);

            int rowsAffected = pstm.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o projeto: " + erro);
            return false;
        } finally {
            fecharConexao();
        }
    }

    /**
     * Configura os valores no PreparedStatement para a atualização de um
     * projeto.
     *
     * @param pstm PreparedStatement a ser configurado.
     * @param projetoDTO Objeto Projeto contendo as informações atualizadas do
     * projeto.
     * @param sdf SimpleDateFormat utilizado para formatar datas.
     * @throws SQLException Se ocorrer um erro ao configurar os valores no
     * PreparedStatement.
     */
    private void configurarValoresPreparedStatement(java.sql.PreparedStatement pstm, Projeto projetoDTO, SimpleDateFormat sdf) throws SQLException {
        pstm.setString(1, projetoDTO.getNomeProjeto());
        pstm.setString(2, sdf.format(projetoDTO.getDataCtrInicio()));

        configurarDataParaPreparedStatement(pstm, 3, projetoDTO.getDataCtrPrevisaoTermino(), sdf);
        configurarDataParaPreparedStatement(pstm, 4, projetoDTO.getDataCtrTermino(), sdf);

        configurarDescricaoParaPreparedStatement(pstm, 5, projetoDTO.getDescricaoProjeto());

        pstm.setInt(6, projetoDTO.getCodProjeto());
    }

    /**
     * Configura a data no PreparedStatement para inserção/atualização, tratando
     * casos de data nula.
     *
     * @param pstm PreparedStatement a ser configurado.
     * @param indice Índice do parâmetro no PreparedStatement.
     * @param data Data a ser configurada.
     * @param sdf SimpleDateFormat utilizado para formatar datas.
     * @throws SQLException Se ocorrer um erro ao configurar a data no
     * PreparedStatement.
     */
    private void configurarDataParaPreparedStatement(java.sql.PreparedStatement pstm, int indice, Date data, SimpleDateFormat sdf) throws SQLException {
        if (data != null) {
            pstm.setString(indice, sdf.format(data));
        } else {
            pstm.setNull(indice, java.sql.Types.DATE);
        }
    }

    /**
     * Configura a descrição no PreparedStatement para inserção/atualização,
     * tratando casos de descrição nula ou vazia.
     *
     * @param pstm PreparedStatement a ser configurado.
     * @param indice Índice do parâmetro no PreparedStatement.
     * @param descricao Descrição a ser configurada.
     * @throws SQLException Se ocorrer um erro ao configurar a descrição no
     * PreparedStatement.
     */
    private void configurarDescricaoParaPreparedStatement(java.sql.PreparedStatement pstm, int indice, String descricao) throws SQLException {
        if (descricao != null && !descricao.isEmpty()) {
            pstm.setString(indice, descricao);
        } else {
            pstm.setNull(indice, java.sql.Types.VARCHAR);
        }
    }

    /**
     * Exclui um projeto, removendo-o da tabela PROJETO e os registros
     * associados da tabela PROJETO_R_USUARIO.
     *
     * @param codigoProjeto Código do projeto a ser excluído.
     * @return True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean excluirProjeto(int codigoProjeto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            // Após remover os registros da tabela PROJETO_R_USUARIO, você pode excluir o projeto
            String sql = "DELETE FROM PROJETO WHERE COD_PROJETO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoProjeto);

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o projeto.");
                return false;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o projeto: " + erro);
            return false;
        } finally {
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
     * Verifica se há usuários associados ao projeto.
     *
     * @param codigoProjeto Código do projeto.
     * @return True se há usuários associados, false caso contrário.
     */
    public boolean usuariosAssociadosAoProjeto(int codigoProjeto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT COUNT(*) FROM PROJETO_R_USUARIO WHERE COD_PROJETO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoProjeto);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
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
        return false;
    }

    /**
     * Remove usuários associados ao projeto na tabela PROJETO_R_USUARIO.
     *
     * @param codigoProjeto Código do projeto.
     * @return True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean removerUsuariosAssociadosAoProjeto(int codigoProjeto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "DELETE FROM PROJETO_R_USUARIO WHERE COD_PROJETO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoProjeto);

            int rowsAffected = pstm.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException erro) {
            erro.printStackTrace();
            return false;
        } finally {
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
     * Verifica se um projeto possui apenas um participante associado.
     *
     * @param codigoProjeto Código do projeto.
     * @return True se há apenas um participante associado, false caso
     * contrário.
     */
    public boolean unicoParticipante(int codigoProjeto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT COUNT(*) FROM PROJETO_R_USUARIO WHERE COD_PROJETO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoProjeto);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count == 1;
                }
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

        return false;
    }

    /**
     * Verifica se o usuário é um administrador do projeto.
     *
     * @param codUsuario Código do usuário.
     * @param codProjeto Código do projeto.
     * @return True se o usuário é um administrador do projeto, false caso
     * contrário.
     */
    public boolean administradorDoProjeto(int codUsuario, int codProjeto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT INDICADOR_ADMINISTRADOR FROM PROJETO_R_USUARIO WHERE COD_USUARIO = ? AND COD_PROJETO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codUsuario);
            pstm.setInt(2, codProjeto);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                boolean indicadorAdministrador = rs.getBoolean("INDICADOR_ADMINISTRADOR");
                return indicadorAdministrador;
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
        return false;
    }

    /**
     * Insere um participante em um projeto.
     *
     * @param codigoProjeto Código do projeto.
     * @param codigoParticipante Código do participante a ser inserido.
     * @return True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean inserirParticipanteNoProjeto(int codigoProjeto, String codigoParticipante) {
        conn = new ConexaoDAO().conectaBD();
        boolean sucessoInsercao = false;

        try {
            String sql = "INSERT INTO PROJETO_R_USUARIO (COD_PROJETO, COD_USUARIO, INDICADOR_ADMINISTRADOR) VALUES (?, ?, ?)";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

            // Código do projeto é passado como argumento
            pstm.setInt(1, codigoProjeto);

            // O código do participante deve ser convertido para int, assumindo que seja um número inteiro
            try {
                int codUsuario = Integer.parseInt(codigoParticipante);
                pstm.setInt(2, codUsuario);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código de participante inválido.");
                return false;
            }

            pstm.setBoolean(3, false); // Defina o indicador como false (não administrador)

            int rowsAffected = pstm.executeUpdate();
            sucessoInsercao = rowsAffected > 0;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o participante ao projeto: " + erro);
        } finally {
            fecharConexao();
        }

        return sucessoInsercao;
    }

    /**
     * Remove um participante de um projeto.
     *
     * @param codigoProjeto Código do projeto.
     * @param codigoParticipante Código do participante a ser removido.
     * @return True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean removerParticipanteDoProjeto(int codigoProjeto, int codigoParticipante) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "DELETE FROM PROJETO_R_USUARIO WHERE COD_PROJETO = ? AND COD_USUARIO = ?";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoProjeto);
            pstm.setInt(2, codigoParticipante);

            int rowsAffected = pstm.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao remover o participante do projeto: " + erro);
            return false;
        } finally {
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
     * Consulta e retorna um ResultSet contendo os projetos associados a um
     * usuário.
     *
     * @param codUsuario Código do usuário.
     * @return ResultSet contendo os projetos associados ao usuário.
     */
    public ResultSet ConsultarProjetos(int codUsuario) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT P.* FROM PROJETO P "
                    + "INNER JOIN PROJETO_R_USUARIO PRU ON P.COD_PROJETO = PRU.COD_PROJETO "
                    + "WHERE PRU.COD_USUARIO = ?";

            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codUsuario); // Define o valor do parâmetro ? com o código do usuário

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProjetoDAO: " + erro);
            return null;
        }
    }

    /**
     * Consulta e retorna um ResultSet contendo os participantes associados a um
     * projeto.
     *
     * @param codProjeto Código do projeto.
     * @return ResultSet contendo os participantes associados ao projeto.
     */
    public ResultSet ConsultarParticipantes(int codProjeto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT U.COD_USUARIO, U.NOM_ACESSO, U.NOM_USUARIO, U.DSC_EMAIL FROM USUARIO U "
                    + "INNER JOIN PROJETO_R_USUARIO PRU ON U.COD_USUARIO = PRU.COD_USUARIO "
                    + "WHERE PRU.COD_PROJETO = ?";

            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codProjeto);

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProjetoDAO: " + erro);
            return null;
        }
    }
}
