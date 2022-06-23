public class Contato {

    private String descricao;
    private String telefone;
    private int tipo; // 1 - residencial / 2 - comercial

    //GETTERS
    public String getDescricao() {
        return descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getTipo() {
        return tipo;
    }

    //SETTERS
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimeContato() {
        System.out.println("Tipo de contato: " + this.descricao + " Contato: "+ this.telefone);
    }


}
