package dominio;

public class Turma {
    private int codigo;
    private String nome;
    private int quantidadeAlunos;

    public Turma() {
    }

    public Turma(int codigo, String nome, int quantidadeAlunos){
        this.codigo = codigo;
        this.nome = nome;
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public int getQuantidadeAlunos() {
        return this.quantidadeAlunos;
    }
}
