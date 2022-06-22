public class ContaCorrente {

    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("Cliente: " + this.cliente.nome);
        System.out.println("Conta: " + this.numeroConta);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Cheque Especial: " + this.chequeEspecial);
        System.out.println("---------------------------------------");
    }

    public boolean sacar(double valor) {
        if (this.saldo + this.chequeEspecial >= valor && valor > 0) {
            this.saldo -= valor;
            System.out.println("Saque efetuado! \n Saldo atual: " + this.saldo);
            System.out.println("---------------------------------------");
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque.\n Saldo insuficiente.");
            System.out.println("---------------------------------------");
            return false;
        }
    }

    public boolean depositar(double valor) {
        if  (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito efetuado! \n Saldo atual: " + this.saldo);
            System.out.println("---------------------------------------");
            return true;
        } else {
            System.out.println("Não foi possível realizar a operação.\n");
            System.out.println("---------------------------------------");
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial() {
            double saldoTotal = this.saldo + this.chequeEspecial;
            return saldoTotal;
    }

    public boolean transferir(ContaCorrente conta, double valor) {
        if (this.saldo + this.chequeEspecial >= valor && valor > 0) {
            this.saldo -= valor;
            conta.saldo += valor;
            System.out.println("Transferência realizada.\n Saldo atual: " + this.saldo);
            System.out.println("---------------------------------------");
            return true;
        } else {
            System.out.println("Não é possível realizar a operação.\n Saldo insuficiente.");
            System.out.println("---------------------------------------");
            return false;
        }


    }
}
