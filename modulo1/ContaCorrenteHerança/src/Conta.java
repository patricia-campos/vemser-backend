public abstract class Conta { //Classe pai/mãe das classes Conta Poupança e Conta Corrente

    Cliente cliente;
    String numeroConta;
    String agencia;
    double saldo;

    //INÍCIO GETTERS E SETTERS
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //INÍCIO CONSTRUTORES

    public void imprimir() {
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Conta: " + this.getNumeroConta());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("---------------------------------------");
    }

    public boolean sacar(double valor) {

        if (this.saldo>= valor && valor > 0) {
            this.saldo -= valor;
            System.out.println("Saque efetuado! \nSaldo atual: " + this.saldo);
            System.out.println("---------------------------------------");
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque.\nSaldo insuficiente.");
            System.out.println("---------------------------------------");
            return false;
        }
    }

    public boolean depositar(double valor) {
        
        if  (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito efetuado! \nSaldo atual: " + this.saldo);
            System.out.println("---------------------------------------");
            return true;
        } else {
            System.out.println("Não foi possível realizar a operação.\n");
            System.out.println("---------------------------------------");
            return false;
        }
    }

    public boolean transferir(Conta conta, double valor) {
        
        if (this.saldo >= valor && valor > 0) {
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

