public class ContaPagamento extends Conta implements Impressao{

    static final double TAXA_SAQUE = 4.25;

    @Override
    public boolean sacar(double valor) {

        if (this.getSaldo()>= valor && valor > 0) {
            double saldoSaqueComTaxa = this.getSaldo() - (valor + TAXA_SAQUE) ;
            this.setSaldo(saldoSaqueComTaxa); //setando o novo saldo com o desconto do saque + taxa
            System.out.println("Saque efetuado! \nSaldo atual: " + saldoSaqueComTaxa);
            System.out.println("---------------------------------------");
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque.\nSaldo insuficiente.");
            System.out.println("---------------------------------------");
            return false;
        }
    }

    public boolean depositar(double valor) {
        return super.depositar(valor);
    }

    @Override
    public boolean transferir(Conta conta, double valor) {

        if (this.getSaldo() >= valor && valor > 0) {
            this.sacar(valor); //acessa o método saque da conta que chamou
            conta.depositar(valor); //acessa o método depósito da conta destino
            System.out.println("Transferência realizada.\nSaldo atual: " + this.getSaldo());
            System.out.println("---------------------------------------");
            return true;
        } else {
            System.out.println("Não é possível realizar a operação.\nSaldo insuficiente.");
            System.out.println("---------------------------------------");
            return false;
        }
    }

    public void imprimir() {
        if(this.getNumeroConta() != null) {
            System.out.println("CONTA PAGAMENTO: " +
                    "\nCliente: " + this.getCliente().getNome() +
                    "\nNúmero da conta: " + this.getNumeroConta() +
                    "\nAgência: " + this.getAgencia() +
                    "\nSaldo: " + this.getSaldo());
        }
    }

}
