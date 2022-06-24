public class ContaPoupanca extends Conta{

    static final double JUROS_MENSAL = 1.01;


    //------------------- INÍCIO MÉTODOS DA CLASSE-------------------

    //------------------- Método para aplicar a taxa no saldo
    public void creditarTaxa() {
        double saldoTotal = this.getSaldo() * JUROS_MENSAL;
        this.setSaldo(saldoTotal);
        System.out.println("O novo saldo da poupança é: " + saldoTotal);
        System.out.println("---------------------------------------");
    }

    //------------------- Método para imprimir os dados da conta
    public void imprimir() {
        if(this.getNumeroConta() != null) {
            System.out.println("CONTA POUPANÇA: " +
                    "\nCliente: " + this.getCliente().getNome() +
                    "\nNúmero da conta: " + this.getNumeroConta() +
                    "\nAgência: " + this.getAgencia() +
                    "\nSaldo: " + this.getSaldo());
        }
    }

}
