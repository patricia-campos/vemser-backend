public class Cliente {

    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirCliente() {
        System.out.printf("Nome: %s \n" + "Cpf: %s \n", this.nome, this.cpf);
    }

    public void imprimirContatos() {

        for (int i = 0; i < contatos.length; i++) {
            contatos[i].imprimeContato();
        }
    }

        public void imprimirEnderecos() {

            for (int i = 0; i < enderecos.length; i++) {
                enderecos[i].imprimirEndereco();
            }

        }
    }

