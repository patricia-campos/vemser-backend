public class ContaPoupanca extends Conta implements Impressao{

    static final double JUROS_MENSAL = 1.01;

    public void creditarTaxa() {
        double saldoTotalContaPoupanca = this.getSaldo() * JUROS_MENSAL;
        System.out.println("O novo saldo da poupança é: " + saldoTotalContaPoupanca);
        System.out.println("---------------------------------------");
    }

}
