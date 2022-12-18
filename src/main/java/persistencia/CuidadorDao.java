package persistencia;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Cuidador;

public class CuidadorDao {

    private Conexao minhaConexao;
    private final String RELATORIO = "select * from \"cuidador\"";
    private final String BUSCAR = "select * from cuidador where id=?";
    private final String INCLUIR = "insert into cuidador (nome, cpf, sexo, nascimento, salario, telefone) values ( ?, ?, ?, ?, ?, ?)";
    private final String EXCLUIR = "delete from cuidador where id=?";
    private final String ALTERAR = "update cuidador set nome=?, cpf=?, sexo=?, nascimento=?, salario=?, telefone=?  where id=?";


    public CuidadorDao() {
        minhaConexao = new Conexao();
    }


    public ArrayList<Cuidador> relatorio(){
        ArrayList<Cuidador> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            Statement instrucao = (Statement) minhaConexao.getConexao().createStatement();
            ResultSet rs = ((java.sql.Statement) instrucao).executeQuery(RELATORIO);
            while(rs.next()){
                Cuidador cuidador = new Cuidador (rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("sexo"), rs.getString("nascimento"), rs.getFloat("salario"),
                        rs.getString("telefone"));
                lista.add(cuidador);
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro no relatorio: "+e.getMessage());
        }
        return lista;
    }

    public void insert(Cuidador cuidador){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setString(1, cuidador.getNome());
            instrucao.setString(2, cuidador.getCpf());
            instrucao.setString(3, cuidador.getSexo());
            instrucao.setString(4, cuidador.getDataNascimento());
            instrucao.setFloat(5, cuidador.getSalario());
            instrucao.setString(6, cuidador.getTelefone());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }

    public void alteracao(Cuidador c, int id){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setString(1, c.getNome());
            instrucao.setString(2, c.getCpf());
            instrucao.setString(3, c.getSexo());
            instrucao.setString(4, c.getDataNascimento());
            instrucao.setFloat(5, c.getSalario());
            instrucao.setString(6, c.getTelefone());
            instrucao.setInt(7, id);
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

    public Cuidador buscar(int id){
        Cuidador cuidador = null;
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                cuidador = new Cuidador (rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("sexo"), rs.getString("nascimento"), rs.getFloat("salario"),
                        rs.getString("telefone"));
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return cuidador;
    }
}
