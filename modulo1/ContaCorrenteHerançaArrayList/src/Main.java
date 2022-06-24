import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        //----------------------------------INÍCIO DO CADASTRO CLIENTE ALICE-------------------------------------

        //-------------------Populei os dados da cliente Alice através de Get e Set, cosntrutor padrão
        Cliente alice = new Cliente();
        alice.setNome("Alice");
        alice.setCpf("11122233355");

        //-------------------Populei contato através do construtor que está na Classe contato
        //-------------------Populei uma linha do array list para cada tipo de contato

        //Acessei o construtor da classe Contato e criei dos objetos contatos, c1 e c2
        Contato c1 = new Contato("Residencial", "78787878", 1 );
        Contato c2 = new Contato("Comercial", "7878787", 2 );

        //Criei uma lista do tipo objeto contato e adicionei duas linhas, c1 e c2
        ArrayList<Contato> c = new ArrayList<Contato>();
        c.add(c1);
        c.add(c2);

        //Aqui eu joguei o valor da lista feita acima para o atributo contato da classe cliente
        alice.setContatos(c);


        //-------------------Populei endereço através do construtor que está na Classe Endereço
        //-------------------Populei uma linha do array list para cada tipo de contato

        //Acessei o construtor na classe Endereço e criei os objetos e1 e e2
        Endereco e1 = new Endereco(1, "Rua dos Cataventos", 512, "Apartamento 10", "99446655", "Porto Alegre", "RS", "Brasil");
        Endereco e2 = new Endereco(2, "Rua Cel Aureliano", 110, "Apartamento 602", "99446655", "Macondo", "RS", "Colômbia");

        //Criei uma lista do tipo endereço e adicionei os endereços cadastrados, e1 e e2
        ArrayList<Endereco> e = new ArrayList<Endereco>();
        e.add(e1);
        e.add(e2);

        //Aqui enviei os dados para gravar no atributo endereço do cadastro da cliente
        alice.setEnderecos(e);

        //----------------------------------FIM DO CADASTRO CLIENTE ALICE-------------------------------------

        //----------------------------------INÍCIO DO CADASTRO CLIENTE ELISA-------------------------------------

        //-------------------Populei os dados da cliente Elisa através de Get e Set, cosntrutor padrão
        Cliente elisa = new Cliente();
        elisa.setNome("Elisa");
        elisa.setCpf("88844466699");

        //-------------------Populei contato através do construtor que está na Classe contato
        //-------------------Populei uma linha do array list para cada tipo de contato

        //Acessei o construtor da classe Contato e criei dos objetos contatos, c1 e c2
        Contato c3 = new Contato("Residencial", "25252525", 1 );
        Contato c4 = new Contato("Comercial", "33665544", 2 );

        //Criei uma lista do tipo objeto contato e adicionei duas linhas, c1 e c2
        ArrayList<Contato> contato2 = new ArrayList<Contato>();
        contato2.add(c3);
        contato2.add(c4);

        //Aqui eu joguei o valor da lista feita acima para o atributo contato da classe cliente
        elisa.setContatos(contato2);

        //-------------------Populei endereço através do construtor que está na Classe Endereço
        //-------------------Populei uma linha do array list para cada tipo de contato

        //Acessei o construtor na classe Endereço e criei os objetos e1 e e2
        Endereco e3 = new Endereco(1, "Rua dos Andradas", 512, "Apartamento 101", "99446655", "Porto Alegre", "RS", "Brasil");
        Endereco e4 = new Endereco(2, "Rua José do Patrocínio", 202, "Apartamento 502", "99446655", "Alegrete", "RS", "Brasil");

        //Criei uma lista do tipo endereço e adicionei os endereços cadastrados, e1 e e2
        ArrayList<Endereco> endereco2 = new ArrayList<Endereco>();
        endereco2.add(e3);
        endereco2.add(e4);

        //Aqui enviei os dados para gravar no atributo endereço do cadastro da cliente
        elisa.setEnderecos(endereco2);

        //----------------------------------FIM DO CADASTRO CLIENTE ELISA-------------------------------------


        //-------------------Fabricando o objeto de conta corrente
        ContaCorrente contaAlice = new ContaCorrente();
        contaAlice.setCliente(alice);
        contaAlice.setNumeroConta("2231256");
        contaAlice.setAgencia("0450");
        contaAlice.setSaldo(2000.00);
        contaAlice.setChequeEspecial(2000.00);

        ContaPagamento contaAlicePagamento = new ContaPagamento();
        contaAlicePagamento.setCliente(alice);
        contaAlicePagamento.setNumeroConta("22558877");
        contaAlicePagamento.setAgencia("25698");
        contaAlicePagamento.setSaldo(2000.00);


        //-------------------Fabricando o objeto de conta poupanca
        ContaPoupanca contaElisa = new ContaPoupanca();
        contaElisa.setCliente(elisa);
        contaElisa.setNumeroConta("225566");
        contaElisa.setAgencia("02566");
        contaElisa.setSaldo(2000.00);

        //-----------------------------------------------------------------------------------------------------

        //Chama o método que imprime os dados + realiza o saque + imprime o novo saldo
        System.out.println("======CLIENTES REALIZAM SAQUE COM SUCESSO======\n");
        contaAlice.imprimir();
        contaAlice.sacar(1000);
        System.out.println("---------------------------------------");
        contaElisa.imprimir();
        contaElisa.sacar(1000);
        System.out.println("---------------------------------------");
        contaAlicePagamento.imprimir();
        contaAlicePagamento.sacar(1000);

        //Chama o método que imprime os dados + realiza o saque + imprime o novo saldo ou imprime mensagem de recusa
        System.out.println("\n======CLIENTES REALIZAM SAQUE SEM SUCESSO OU ENTRA NO CHEQUE ESPECIAL======\n");
        contaAlice.imprimir();
        contaAlice.sacar(3000);
        System.out.println("---------------------------------------");
        contaElisa.imprimir();
        contaElisa.sacar(3000);
        System.out.println("---------------------------------------");
        contaAlicePagamento.imprimir();
        contaAlicePagamento.sacar(3000);

        //Chama o método que imprime os dados + realiza o depósito + imprime o novo saldo
        System.out.println("\n======CLIENTES RECEBEM DEPÓSITO======\n");
        contaAlice.imprimir();
        contaAlice.depositar(1000);
        System.out.println("---------------------------------------");
        contaElisa.imprimir();
        contaElisa.depositar(1000);
        System.out.println("---------------------------------------");
        contaAlicePagamento.imprimir();
        contaAlicePagamento.depositar(1000);

        //Chama o método que imprime os dados + realiza a transferência + imprime novo saldo
        System.out.println("\n======CLIENTE REALIZA TRANSFERÊNCIA COM SUCESSO======\n");
        contaAlicePagamento.imprimir();
        contaAlicePagamento.transferir(contaElisa,500);

        //Chama o método que imprime os dados + realiza a transferência + imprime mensagem de recusa
        System.out.println("\n======CLIENTE REALIZA TRANSFERÊNCIA SEM SUCESSO======\n");
        contaElisa.imprimir();
        contaElisa.transferir(contaAlice,8000);
    }
}