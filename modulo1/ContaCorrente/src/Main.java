public class Main {

    public static void main(String[] args) {

        //Cadastro do Cliente
        Cliente Alice = new Cliente();
        Alice.nome = "Alice Campos";
        Alice.cpf = "11111111111";

        //Cadastro contato CLIENTE ALICE

        Alice.contatos[0]=new Contato();
        Alice.contatos[0].tipo=1;
        Alice.contatos[0].telefone = "988888888";
        Alice.contatos[0].descricao = "residencial";

        Alice.contatos[1]=new Contato();
        Alice.contatos[1].tipo=2;
        Alice.contatos[1].telefone = "99999999";
        Alice.contatos[1].descricao = "comercial";

        //Cadastro endereço CLIENTE ALICE
        Alice.enderecos[0]=new Endereco();
        Alice.enderecos[0].tipoEndereco = 1;
        Alice.enderecos[0].logradouro = "Rua A";
        Alice.enderecos[0].numero = 10;
        Alice.enderecos[0].complemento = "Apartamento 110";
        Alice.enderecos[0].cep = "12545632";
        Alice.enderecos[0].cidade = "Cachoeirinha";
        Alice.enderecos[0].estado = "RS";
        Alice.enderecos[0].pais = "Brasil";

        Alice.enderecos[1]=new Endereco();
        Alice.enderecos[1].tipoEndereco = 2;
        Alice.enderecos[1].logradouro = "Rua B";
        Alice.enderecos[1].numero = 20;
        Alice.enderecos[1].complemento = "Apartamento 130";
        Alice.enderecos[1].cep = "15586669";
        Alice.enderecos[1].cidade = "Cachoeirinha";
        Alice.enderecos[1].estado = "RS";
        Alice.enderecos[1].pais = "Brasil";

        //Conta dos clientes
        ContaCorrente ContaAlice = new ContaCorrente();
        ContaAlice.cliente = Alice;
        ContaAlice.numeroConta = "55869";
        ContaAlice.agencia = 162;
        ContaAlice.saldo = 800.00;
        ContaAlice.chequeEspecial = 2000.00;

        //--------------------------------------------

        //Cadastro do Cliente
        Cliente Patricia = new Cliente();
        Patricia.nome = "Patricia Campos";
        Patricia.cpf = "2222222222222";

        //Cadastro contato do cliente - tipo 1 e 2
        Patricia.contatos[0]=new Contato();
        Patricia.contatos[0].tipo=1;
        Patricia.contatos[0].telefone = "88775522";
        Patricia.contatos[0].descricao = "residencial";

        Patricia.contatos[1]=new Contato();
        Patricia.contatos[1].tipo=2;
        Patricia.contatos[1].telefone = "55996633";
        Patricia.contatos[1].descricao = "comercial";

        //Cadastro endereço - tipo 1 e 2
        Patricia.enderecos[0]=new Endereco();
        Patricia.enderecos[0].tipoEndereco = 1;
        Patricia.enderecos[0].logradouro = "Rua Z";
        Patricia.enderecos[0].numero = 10;
        Patricia.enderecos[0].complemento = "Apartamento 207";
        Patricia.enderecos[0].cep = "188558663";
        Patricia.enderecos[0].cidade = "Cachoeirinha";
        Patricia.enderecos[0].estado = "RS";
        Patricia.enderecos[0].pais = "Brasil";

        Patricia.enderecos[1]=new Endereco();
        Patricia.enderecos[1].tipoEndereco = 2;
        Patricia.enderecos[1].logradouro = "Rua Y";
        Patricia.enderecos[1].numero = 285;
        Patricia.enderecos[1].complemento = "Apartamento 602";
        Patricia.enderecos[1].cep = "558998663";
        Patricia.enderecos[1].cidade = "Cachoeirinha";
        Patricia.enderecos[1].estado = "RS";
        Patricia.enderecos[1].pais = "Brasil";

        //Conta dos clientes
        ContaCorrente ContaPatricia = new ContaCorrente();
        ContaPatricia.cliente = Patricia;
        ContaPatricia.numeroConta = "225566";
        ContaPatricia.agencia = 162;
        ContaPatricia.saldo = 1800.00;
        ContaPatricia.chequeEspecial = 500.00;

        //Chama o método sacar
        ContaPatricia.sacar(500);

        //Chama o método depositar
        ContaPatricia.depositar(100);

        //Chama método que retorna saldo total
        ContaPatricia.retornarSaldoComChequeEspecial();

        //Chama método que transfere valor entre contas
        ContaPatricia.transferir(ContaAlice, 500);

        //Chama método que impreime os dados da conta corrente
        ContaPatricia.imprimirContaCorrente();
        ContaAlice.imprimirContaCorrente();

    }
}
