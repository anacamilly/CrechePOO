package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dominio.Responsavel;

public class ResponsavelDao {

    private Conexao minhaConexao;
    private final String LISTAR = "select * from responsavel";
    private final String BUSCAR = "select * from responsavel where id=?";
    private final String INCLUIR = "insert into responsavel (nome, cpf, sexo, nascimento, telefone) values (?, ?, ?, ?, ?)";
    private final String EXCLUIR = "delete from responsavel where id=?";
    private final String ALTERAR = "update responsavel set nome=?, cpf=?, sexo=?, "
            + "nascimento=?, telefone=? where id=?";


    public ResponsavelDao() {
        minhaConexao = new Conexao();
    }

    public List<Responsavel> listar(){
        List<Responsavel> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            java.sql.Statement instrucao = (Statement) minhaConexao.getConexao().createStatement();
            ResultSet rs =((java.sql.Statement) instrucao).executeQuery(LISTAR);
            while(rs.next()){
                Responsavel responsavel = new Responsavel (rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("sexo"), rs.getString("nascimento"), rs.getString("telefone"));
                lista.add(responsavel);
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro no relatorio: "+e.getMessage());
        }
        return lista;
    }

    public void insert(Responsavel responsavel){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setString(1, responsavel.getNome());
            instrucao.setString(2, responsavel.getCpf());
            instrucao.setString(3, responsavel.getSexo());
            instrucao.setString(4, responsavel.getDataNascimento());
            instrucao.setString(5, responsavel.getTelefone());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }

    public void alteracao(Responsavel t, int id){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setString(1, t.getNome());
            instrucao.setString(2, t.getCpf());
            instrucao.setString(3, t.getSexo());
            instrucao.setString(4, t.getDataNascimento());
            instrucao.setString(5, t.getTelefone());
            instrucao.setInt(6, id);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }

    public void exclusao(int id){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(EXCLUIR);
            instrucao.setInt(1, id);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }

    public Responsavel buscar(int id){
        Responsavel responsavel = null;
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                responsavel = new Responsavel (rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("sexo"), rs.getString("nascimento"), rs.getString("telefone"));
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return responsavel;
    }
}
