public class Cliente {

    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    //GETTERS DOS DADOS POIS SÃO PRIVATE
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    //SETTERS POIS SÃO PRIVADOS

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //popula o vetor de contatos lá na Main
    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }



    //CRIANDO O MÉTODO CONSTRUTOR PARA POPULAR OS ATRIBUTOS DA CLASSE CLIENTE

    public void imprimirCliente() {
        System.out.printf("Nome: %s \n" + "Cpf: %s \n", this.nome, this.cpf);
    }

    public void imprimirContatos() {

        for (int i = 0; i < contatos.length; i++) {
            if(contatos != null)
            contatos[i].imprimeContato();
        }
    }
        public void imprimirEnderecos() {

            for (int i = 0; i < enderecos.length; i++) {
                if(enderecos != null)
                enderecos[i].imprimirEndereco();
            }
        }
    }

