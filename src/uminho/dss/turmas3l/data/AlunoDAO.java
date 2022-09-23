package uminho.dss.turmas3l.data;

import uminho.dss.turmas3l.business.Aluno;
import uminho.dss.turmas3l.business.Sala;
import uminho.dss.turmas3l.business.Turma;

import java.sql.*;
import java.util.List;

/**
 * Versão para Alunos com DAO
 *
 */



public class AlunoDAO {

    private static AlunoDAO singleton = null;

    /**
     * Private porque é o padrao singleton (nao poder aceder de fora e nao poder criar dois objetos)
     *
     */
    private AlunoDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS alunos (" +
                    "Num varchar(10) NOT NULL PRIMARY KEY," +
                    "Nome varchar(45) DEFAULT NULL," +
                    "Email varchar(45) DEFAULT NULL)";
            stm.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    /**
     * Continuação do padrao Singleton
     *
     */

    public static AlunoDAO getInstance() {
        if( AlunoDAO.singleton == null) {
            AlunoDAO.singleton = new AlunoDAO();
        }

        return AlunoDAO.singleton;
    }

    /**
     * Confere se existe um respetivo aluno
     *
     * @param numero
     * @return se o aluno nao existir retorna -1
     */
    public int existealuno(String numero) {

        int control = -1;

        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery( " SELECT Num FROM alunos WHERE Num = '" + numero +"' " )) {
             control = rs.getInt(1);
             }

        catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }

        return control;

    }

    public void adicionaaluno(Aluno a){

        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {

            // Actualizar Alunos
            stm.executeUpdate(
                    "INSERT INTO alunos " +
                            "VALUES ('"+ a.getNumero()+ "', '"+
                            a.getNome()+"', "+
                            a.getEmail()+") ");

        }  catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());

        }

    }


}
