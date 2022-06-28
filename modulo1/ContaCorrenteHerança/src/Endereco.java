public class Endereco {

    private int tipoEndereco; //1- residencial , 2- comercial
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    //Get e Set Tipo de endereço
    public int getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(int tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    //Get e Set Logradouro
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    //Get e Set Número
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Get e Set Complemento
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    //Get e Set CEP
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    //Get e Set Cidade
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    //Get e Set Estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Get e Set País
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

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

    //Método de impressão do endereço
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
