import java.util.ArrayList;
import java.util.Arrays;

public class Cliente {

    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();


    //-------------------GETTERS SETTERS DOS ATRIBUTOS DA CLASSE-------------------
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    //------------------- INÍCIO MÉTODOS DA CLASSE-------------------

    //-------------------Métodos para imprimir os dados do cliente-------------------

    public void imprimirCliente() {
        System.out.printf("Nome: %s \n" + "Cpf: %s \n", this.nome, this.cpf);
    }

    public void imprimirContatos() {

            if(contatos != null) {
                for (int i = 0; i < contatos.size(); i++) {
                contatos.get(i).imprimeContato();
            }
        }
    }
        public void imprimirEnderecos() {


                if(enderecos != null) {
                    for (int i = 0; i < enderecos.size(); i++) {
                    enderecos.get(i).imprimirEndereco();
                }
            }
        }
    }

