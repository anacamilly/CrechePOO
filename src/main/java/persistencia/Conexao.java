package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    private static final String user = "root";
    private static final String senha ="";
    private static final String caminho = "jdbc:mysql://localhost:3306/creche";
    static Connection connection ;

    public Connection conectar() {
        try {
            connection = DriverManager.getConnection(caminho, user, senha);
            System.out.print("|--------------------------------------------------------|\n");
            System.out.print("|       CONEXÃO COM O BANCO EFETUADA COM SUCESSO         |\n");
            System.out.print("|--------------------------------------------------------|\n");
        }
        catch(SQLException e)
        {
            System.out.println("Erro na conexão: "+ e.getMessage());
        }
        return connection;
    }

    public void desconectar() {
        try {
            connection.close();//fecha a conexao
        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }

    public Connection getConexao() {
        // TODO Auto-generated method stub
        return connection;
    }


}
