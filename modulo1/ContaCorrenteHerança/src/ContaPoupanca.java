public class ContaPoupanca extends Conta{

    static final double JUROS_MENSAL = 1.01;

    public void creditarTaxa() {
        this.saldo = this.saldo * JUROS_MENSAL;
        System.out.println("O novo saldo da poupança é: " + this.saldo);
        System.out.println("---------------------------------------");
    }

}
