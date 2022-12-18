package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dominio.ExtraCurricular;

public class ExtraCurricularDao{

    private Conexao minhaConexao;
    private final String LISTAR = "select * from extracurricular";
    private final String BUSCAR = "select * from extracurricular where codigo=?";
    private final String INCLUIR = "insert into extracurricular (codigo, nome, modalidade) values (?, ?, ?)";
    private final String EXCLUIR = "delete from extracurricular where codigo=?";
    private final String ALTERAR = "update extracurricular set codigo=?, nome=?, modalidade=? where codigo=?";


    public ExtraCurricularDao() {
        minhaConexao = new Conexao();
    }


    public List<ExtraCurricular> listar(){
        List<ExtraCurricular> lista = new ArrayList<>();
        try{
            minhaConexao.conectar();
            java.sql.Statement instrucao = (Statement) minhaConexao.getConexao().createStatement();
            ResultSet rs =((java.sql.Statement) instrucao).executeQuery(LISTAR);
            while(rs.next()){
                ExtraCurricular extraCurricular = new ExtraCurricular (rs.getInt("codigo"), rs.getString("nome"), rs.getString("modalidade"));
                lista.add(extraCurricular);
            }
            minhaConexao.desconectar();

        }catch(SQLException e){
            System.out.println("Erro no relatorio: "+e.getMessage());
        }
        return lista;
    }

    public void insert(ExtraCurricular extc){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setInt(1, extc.getCod());
            instrucao.setString(2, extc.getNome());
            instrucao.setString(3, extc.getModalidade());
            instrucao.execute();
            minhaConexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }

    public void alteracao(ExtraCurricular extc, int codigo){
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setInt(1, extc.getCod());
            instrucao.setString(2, extc.getNome());
            instrucao.setString(3, extc.getModalidade());
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

    public ExtraCurricular buscar(int codigo){
        ExtraCurricular extraCurricular = null;
        try{
            minhaConexao.conectar();
            PreparedStatement instrucao =
                    minhaConexao.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, codigo);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                extraCurricular = new ExtraCurricular (rs.getInt("codigo"), rs.getString("nome"), rs.getString("modalidade"));
            }
            minhaConexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return extraCurricular;
    }
}

