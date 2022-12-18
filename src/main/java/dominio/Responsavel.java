package dominio;

public class Responsavel {
    private int id;
    private String nome;
    private String cpf;
    private String sexo;
    private String dataNascimento;
    private String telefone;

    public Responsavel(int id, String nome, String cpf, String sexo, String nascimento, String telefone) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

}