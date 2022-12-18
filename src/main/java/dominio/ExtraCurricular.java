package dominio;

public class ExtraCurricular {
    private int cod;
    private String nome;
    private String modalidade;

    public ExtraCurricular(int codigo, String nome, String modalidade) {
        this.cod = codigo;
        this.nome = nome;
        this.modalidade = modalidade;
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
    public String getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
}
