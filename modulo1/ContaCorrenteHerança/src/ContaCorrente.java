public class ContaCorrente extends Conta implements Movimentacao{

    private double chequeEspecial;

    //Getter e Setter Cheque especial
    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial() {
        double saldoTotal = this.saldo + this.chequeEspecial;
        return saldoTotal;
    }

    @Override //Sobrescreve o método sacar do molde sacar na classe abstrata conta pois tem a particularidade cheque especial
    public boolean sacar(double valor) {
        if (this.saldo + this.chequeEspecial >= valor && valor > 0) {
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
    @Override
    public boolean transferir(Conta conta, double valor) {
        if (this.saldo + this.chequeEspecial >= valor && valor > 0) {
            this.saldo -= valor;
            conta.saldo += valor;
            System.out.println("Transferência realizada.\nSaldo atual: " + this.saldo);
            System.out.println("---------------------------------------");
            return true;
        } else {
            System.out.println("Não é possível realizar a operação.\nSaldo insuficiente.");
            System.out.println("---------------------------------------");
            return false;
        }
    }
    @Override
    public void imprimir() {
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Conta: " + this.getNumeroConta());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Cheque Especial: " + this.getChequeEspecial());
        System.out.println("---------------------------------------");
    }
}
