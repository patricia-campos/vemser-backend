public class Main {

    public static void main(String[] args) {

        //Cadastro do Cliente
        Cliente alice = new Cliente();
        alice.nome = "Alice Campos";
        alice.cpf = "11111111111";

        //Cadastro contato CLIENTE ALICE

        alice.contatos[0]=new Contato();
        alice.contatos[0].tipo=1;
        alice.contatos[0].telefone = "988888888";
        alice.contatos[0].descricao = "residencial";

        alice.contatos[1]=new Contato();
        alice.contatos[1].tipo=2;
        alice.contatos[1].telefone = "99999999";
        alice.contatos[1].descricao = "comercial";

        //Cadastro endereço CLIENTE ALICE
        alice.enderecos[0]=new Endereco();
        alice.enderecos[0].tipoEndereco = 1;
        alice.enderecos[0].logradouro = "Rua A";
        alice.enderecos[0].numero = 10;
        alice.enderecos[0].complemento = "Apartamento 110";
        alice.enderecos[0].cep = "12545632";
        alice.enderecos[0].cidade = "Cachoeirinha";
        alice.enderecos[0].estado = "RS";
        alice.enderecos[0].pais = "Brasil";

        alice.enderecos[1]=new Endereco();
        alice.enderecos[1].tipoEndereco = 2;
        alice.enderecos[1].logradouro = "Rua B";
        alice.enderecos[1].numero = 20;
        alice.enderecos[1].complemento = "Apartamento 130";
        alice.enderecos[1].cep = "15586669";
        alice.enderecos[1].cidade = "Cachoeirinha";
        alice.enderecos[1].estado = "RS";
        alice.enderecos[1].pais = "Brasil";

        //Conta dos clientes
        ContaCorrente contaAlice = new ContaCorrente();
        contaAlice.cliente = Alice;
        contaAlice.numeroConta = "55869";
        contaAlice.agencia = 162;
        contaAlice.saldo = 800.00;
        contaAlice.chequeEspecial = 2000.00;

        //--------------------------------------------

        //Cadastro do Cliente
        Cliente patricia = new Cliente();
        patricia.nome = "Patricia Campos";
        patricia.cpf = "2222222222222";

        //Cadastro contato do cliente - tipo 1 e 2
        patricia.contatos[0]=new Contato();
        patricia.contatos[0].tipo=1;
        patricia.contatos[0].telefone = "88775522";
        patricia.contatos[0].descricao = "residencial";

        patricia.contatos[1]=new Contato();
        patricia.contatos[1].tipo=2;
        patricia.contatos[1].telefone = "55996633";
        patricia.contatos[1].descricao = "comercial";

        //Cadastro endereço - tipo 1 e 2
        patricia.enderecos[0]=new Endereco();
        patricia.enderecos[0].tipoEndereco = 1;
        patricia.enderecos[0].logradouro = "Rua Z";
        patricia.enderecos[0].numero = 10;
        patricia.enderecos[0].complemento = "Apartamento 207";
        patricia.enderecos[0].cep = "188558663";
        patricia.enderecos[0].cidade = "Cachoeirinha";
        patricia.enderecos[0].estado = "RS";
        patricia.enderecos[0].pais = "Brasil";

        patricia.enderecos[1]=new Endereco();
        patricia.enderecos[1].tipoEndereco = 2;
        patricia.enderecos[1].logradouro = "Rua Y";
        patricia.enderecos[1].numero = 285;
        patricia.enderecos[1].complemento = "Apartamento 602";
        patricia.enderecos[1].cep = "558998663";
        patricia.enderecos[1].cidade = "Cachoeirinha";
        patricia.enderecos[1].estado = "RS";
        Patricia.enderecos[1].pais = "Brasil";

        //Conta dos clientes
        ContaCorrente contaPatricia = new ContaCorrente();
        contaPatricia.cliente = Patricia;
        contaPatricia.numeroConta = "225566";
        contaPatricia.agencia = 162;
        contaPatricia.saldo = 1800.00;
        contaPatricia.chequeEspecial = 500.00;

        //Chama o método sacar
        contaPatricia.sacar(500);

        //Chama o método depositar
        contaPatricia.depositar(100);

        //Chama método que retorna saldo total
        contaPatricia.retornarSaldoComChequeEspecial();

        //Chama método que transfere valor entre contas
        contaPatricia.transferir(ContaAlice, 500);

        //Chama método que impreime os dados da conta corrente
        contaPatricia.imprimirContaCorrente();
        contaAlice.imprimirContaCorrente();

    }
}
