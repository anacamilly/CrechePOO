package dominio;

public class ExtraCurricular {
    private int cod;
    private String nome;
    private String modalidade;

    private  int codTurma;

    public ExtraCurricular(int codigo, String nome, String modalidade, int codTurma) {
        this.cod = codigo;
        this.nome = nome;
        this.modalidade = modalidade;
        this.codTurma = codTurma;
    }

    public ExtraCurricular() {

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodTurma() {
        return this.codTurma;
    }

    public void setCodTurma(int cod) {
        this.codTurma = cod;
    }

    public String getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
}
