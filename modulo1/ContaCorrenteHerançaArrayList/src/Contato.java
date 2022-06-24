import java.sql.SQLOutput;

public class Contato {

    private String descricao;
    private String telefone;
    private int tipo; // 1 - residencial / 2 - comercial

    //-------------------GETTERS DOS ATRIBUTOS DA CLASSE-------------------
    public String getDescricao() {
        return descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getTipo() {
        return tipo;
    }

    //-------------------SETTERS DOS ATRIBUTOS DA CLASSE-------------------
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    //-------------------Método construtor do contato-------------------
    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    //-------------------Método para imprimir os dados do contato-------------------
    public void imprimeContato() {
        System.out.println("Tipo de contato: " + this.descricao + " Contato: "+ this.telefone);
        System.out.println("----------------------------------------------------------------");
    }


}
