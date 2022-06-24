public class Endereco {

    private int tipoEndereco; //1- residencial , 2- comercial
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    //-------------------INÍCIO GETTERS E SETTERS-------------------
    public int getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(int tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    //------------------- INÍCIO MÉTODOS DA CLASSE-------------------

    //-------------------Método construtor da Classe Endereço-------------------
    public Endereco(int tipoEndereco, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    //-------------------Método de impressão do endereço-------------------
    public void imprimirEndereco() {
        System.out.printf("Tipo de endereço: %d \n" +
                          "Logradouro: %s \n" +
                          "Número: %d \n" +
                          "Complemento: %s \n" +
                          "Cep: %s \n" +
                          "Cidade: %s \n" +
                          "Estado: %s \n" +
                          "País: %s \n",
                          this.tipoEndereco, this.logradouro, this.numero, this.complemento,
                          this.cep, this.cidade, this.estado, this.pais);
    }
}
