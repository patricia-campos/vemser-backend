public class Main {

    public static void main(String[] args) {

        //----------------------------------INÍCIO DO CADASTRO CLIENTE ALICE-------------------------------------


        //Populei os dados através de Get e Set, cosntrutor padrão
        Cliente alice = new Cliente();
        alice.setNome("Alice");
        alice.setCpf("11122233355");

        //Populei contato através do construtor que está na Classe contato
        //Populei um vetor para cada tipo de contato

        Contato c1 = new Contato("Residencial", "78787878", 1 );
        Contato c2 = new Contato("Comercial", "7878787", 2 );

        //Preenchi o vetor Contato com os dados populados acima e chamei o set
        Contato[] Contato = new Contato[] {c1, c2};
        alice.setContatos(Contato);

        //Populei endereço através do construtor que está na Classe Endereço
        //Populei um vetor para cada tipo de endereço

        Endereco e1 = new Endereco(1, "Rua dos Cataventos", 512, "Apartamento 10", "99446655", "Porto Alegre", "RS", "Brasil");
        Endereco e2 = new Endereco(2, "Rua Cel Aureliano", 110, "Apartamento 602", "99446655", "Macondo", "RS", "Colômbia");

        //Preenchi o vetor Endereço com os dados populados acima e chamei o set
        Endereco[] Endereco = new Endereco[] {e1, e2};
        alice.setEnderecos(Endereco);

        //----------------------------------FIM DO CADASTRO CLIENTE ALICE-------------------------------------

        //----------------------------------INÍCIO DO CADASTRO CLIENTE ELISA-------------------------------------

        //Populei os dados através de Get e Set, cosntrutor padrão
        Cliente elisa = new Cliente();
        elisa.setNome("Elisa");
        elisa.setCpf("88844466699");

        //Populei contato através do construtor que está na Classe contato
        //Populei um vetor para cada tipo de contato

        Contato c3 = new Contato("Residencial", "12121212", 1 );
        Contato c4 = new Contato("Comercial", "12121212", 2 );

        //Preenchi o vetor Contato com os dados populados acima e chamei o set
        Contato[] Contato2 = new Contato[] {c3, c4};
        elisa.setContatos(Contato2);

        //Populei endereço através do construtor que está na Classe Endereço
        //Populei um vetor para cada tipo de endereço

        Endereco e3 = new Endereco(1, "Rua Senhor dos Passos", 800, "Apartamento 502", "889636563", "Porto Alegre", "RS", "Brasil");
        Endereco e4 = new Endereco(2, "Rua Andradas", 290, "Apartamento 701", "99446655", "Porto Alegre", "RS", "Brasil");

        //Preenchi o vetor Endereço com os dados populados acima e chamei o set
        Endereco[] Endereco2 = new Endereco[] {e3, e4};
        elisa.setEnderecos(Endereco2);

        //----------------------------------FIM DO CADASTRO CLIENTE ELISA-------------------------------------

        //Fabricando o objeto de conta corrente
        ContaCorrente contaAlice = new ContaCorrente();
        contaAlice.setCliente(alice);
        contaAlice.setNumeroConta("2231256");
        contaAlice.setAgencia("0450");
        contaAlice.setSaldo(6000.00);
        contaAlice.setChequeEspecial(2000.00);

        //Fabricando o objeto de conta poupanca
        ContaPoupanca contaElisa = new ContaPoupanca();
        contaElisa.setCliente(elisa);
        contaElisa.setNumeroConta("225566");
        contaElisa.setAgencia("02566");
        contaElisa.setSaldo(2500.00);

        //--------------------------------------------

        //Chama o método que realiza o saque e imprime o novo saldo
        contaAlice.sacar(2000);
        contaElisa.sacar(3000);

        //Chama o método depositar
        contaAlice.depositar(100);

        //Chama método que retorna saldo total
        System.out.println("O saldo com cheque especial é: " + contaAlice.retornarSaldoComChequeEspecial());

        //Chama método que transfere valor entre contas
        contaAlice.transferir(contaElisa, 500);

        //Creditar taxa
        contaElisa.creditarTaxa();

        //Chama método que imprime os dados da conta corrente
        contaAlice.imprimir();
        contaElisa.imprimir();

    }
}