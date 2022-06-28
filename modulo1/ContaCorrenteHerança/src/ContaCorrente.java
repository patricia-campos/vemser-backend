public class ContaCorrente extends Conta implements Movimentacao, Impressao{

    private double chequeEspecial;

    //Setter do cheque especial
    //Não tem getter pois não precisarei acessar para modificá-lo, será apenas para referência.
    public void setChequeEspecial(double chequeEspecial) {this.chequeEspecial = chequeEspecial;}


    //------------------- INÍCIO MÉTODOS DA CLASSE-------------------

    //-------------------Método que retorna o saldo com cheque especial
    public double retornarSaldoComChequeEspecial() {
        double saldoTotal = this.getSaldo() + this.chequeEspecial;
        return saldoTotal;
    }
    //-------------------Método para imprimir
    public void imprimir() {
        if(this.getNumeroConta() != null) {
            System.out.println("CONTA CORRENTE: " +
                    "\nCliente: " + this.getCliente().getNome() +
                    "\nNúmero da conta: " + this.getNumeroConta() +
                    "\nAgência: " + this.getAgencia() +
                    "\nSaldo: " + this.getSaldo() +
                    "\nCheque especial com saldo: " + this.retornarSaldoComChequeEspecial());
        }
    }

    //-------------------Método para sacar
    //Sobrescreve o método sacar do molde sacar na classe abstrata (mãe) Conta pois tem a particularidade cheque especial
    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() + this.chequeEspecial >= valor && valor > 0) {

            double saldoTotal = this.getSaldo() - valor;
            this.setSaldo(saldoTotal);

            System.out.println("Saque efetuado! \nSaldo atual: " + saldoTotal);
            System.out.println("---------------------------------------");

            return true;

        } else {
            System.out.println("Não foi possível realizar o saque.\nSaldo insuficiente.");
            System.out.println("---------------------------------------");

            return false;
        }
    }

}