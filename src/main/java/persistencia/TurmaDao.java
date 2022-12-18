package persistencia;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Turma;

public class TurmaDao{

    private Conexao minhaConexao;
    private final String RELATORIO = "select * from \"turma\"";
    private final String BUSCAR = "select * from \"turma\" where \"codigo\"=?";
    private final String INCLUIR = "insert into turma (codigo, nome, quantidadeAlunos) values (?, ?, ?)";
    private final String EXCLUIR = "delete from \"turma\" where \"codigo\"=?";
    private final String ALTERAR = "update \"turma set \"codigo\"=?, \"\"nome\"=?, \"quantidadeAlunos\"=?";


    public TurmaDao() {
        minhaConexao = new Conexao();
    }


    public ArrayList<Turma> relatorio(){
        ArrayList<Turma> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            Statement instrucao = (Statement) minhaConexao.getConexao().createStatement();
            ResultSet rs = ((java.sql.Statement) instrucao).executeQuery(RELATORIO);
            while(rs.next()){
                Turma turma = new Turma (rs.getInt("codigo"), rs.getString("nome"), rs.getInt("quantidadeAlunos"));
                lista.add(turma);
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro no relatorio: "+e.getMessage());
        }
        return lista;
    }

    public void insert(Turma turma){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setInt(1, turma.getCodigo());
            instrucao.setString(2, turma.getNome());
            instrucao.setInt(3, turma.getQuantidadeAlunos());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }

    public void alteracao(Turma t, int codigo){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setInt(1, t.getCodigo());
            instrucao.setString(2, t.getNome());
            instrucao.setInt(3, t.getQuantidadeAlunos());
            instrucao.setInt(4, codigo);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }

    public void exclusao(int codigo){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(EXCLUIR);
            instrucao.setInt(1, codigo);
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }

    public Turma buscar(int codigo){
        Turma turma = null;
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, codigo);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                turma = new Turma (rs.getInt("codigo"), rs.getString("nome"), rs.getInt("quantidadeAlunos"));
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return turma;
    }
}

