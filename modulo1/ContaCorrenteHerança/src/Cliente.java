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

    //Método para popular o vetor de contatos lá na Main
    public void setContatos(Contato[] contatos) {
            for (int i = 0; i < contatos.length; i++) {
                if (contatos[i] != null) {
                    contatos[i].setDescricao(contatos[i].getDescricao());
                    contatos[i].setTelefone(contatos[i].getTelefone());
                    contatos[i].setTipo(contatos[i].getTipo());
                }
            }
    }

    //Método para popular o vetor de endereços lá na Main
    public void setEnderecos(Endereco[] enderecos) {
        for (int i = 0; i < enderecos.length; i++) {
            if (enderecos[i] != null) {
                enderecos[i].setTipoEndereco(enderecos[i].getTipoEndereco());
                enderecos[i].setLogradouro(enderecos[i].getLogradouro());
                enderecos[i].setNumero(enderecos[i].getNumero());
                enderecos[i].setComplemento(enderecos[i].getComplemento());
                enderecos[i].setCep(enderecos[i].getCep());
                enderecos[i].setCidade(enderecos[i].getCidade());
                enderecos[i].setEstado(enderecos[i].getEstado());
                enderecos[i].setPais(enderecos[i].getPais());
            }
        }
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

