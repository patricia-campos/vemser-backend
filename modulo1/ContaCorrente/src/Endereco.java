public class Endereco {

    int tipoEndereco; //1- residencial , 2- comercial
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

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
