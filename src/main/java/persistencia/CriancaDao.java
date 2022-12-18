package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.Crianca;

public class CriancaDao {

    private Conexao minhaConexao;
    private final String LISTAR = "select * from crianca";
    private final String BUSCAR = "select * from crianca where id=?";
    private final String INCLUIR = "insert into crianca (nome, cpf, sexo, nascimento, matricula) values (?, ?, ?, ?, ?)";
    private final String EXCLUIR = "delete from crianca where id=?";
    private final String ALTERAR = "update crianca set nome=?, cpf=?, sexo=?, "
            + "nascimento=?, matricula=? where id=?";


    public CriancaDao() {
        minhaConexao = new Conexao();
    }


    public List<Crianca> listar() {
        List<Crianca> criancas = new ArrayList<>();

        try {
            minhaConexao.conectar();
            Statement instrucao = (Statement) minhaConexao.getConexao().createStatement();
            ResultSet resultSet =((java.sql.Statement) instrucao).executeQuery(LISTAR);
            while (resultSet.next()) {
                Crianca crianc = new Crianca(resultSet.getInt("id"), resultSet.getString("nome"),
                resultSet.getString("cpf"),
                resultSet.getString("sexo"),
                resultSet.getString("nascimento"),
                resultSet.getInt("matricula"));
                criancas.add(crianc);
            }

        } catch (SQLException e) {
            System.out.println("Erro na lista: "+e.getMessage());
        }

        return criancas;

    }

    public void insert(Crianca crianca){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setString(1, crianca.getNome());
            instrucao.setString(2, crianca.getCpf());
            instrucao.setString(3, crianca.getSexo());
            instrucao.setString(4, crianca.getDataNascimento());
            instrucao.setInt(5, crianca.getMatricula());
            instrucao.execute();
            minhaConexao.desconectar();

        }catch(Exception e){
            System.out.println("Erro no cadastro: "+e.getMessage());
        }
    }

    public void alteracao(Crianca c, int id){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setString(1, c.getNome());
            instrucao.setString(2, c.getCpf());
            instrucao.setString(3, c.getSexo());
            instrucao.setString(4, c.getDataNascimento());
            instrucao.setInt(5, c.getMatricula());
            instrucao.setInt(6, id);
            instrucao.execute();
            minhaConexao.desconectar();


        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }

    public void remove(Crianca crianca){
        try {
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(EXCLUIR);
            instrucao.setInt(1,crianca.getId());

            instrucao.execute();
            instrucao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Crianca buscar(int id){
        Crianca crianca = null;
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                crianca = new Crianca (rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("sexo"), rs.getString("nascimento"), rs.getInt("matricula"));
            }

            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return crianca;
    }
}