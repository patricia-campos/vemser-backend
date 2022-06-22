public class Contato {

    String descricao;
    String telefone;
    int tipo; // 1 - residencial / 2 - comercial

    public void imprimeContato() {
        System.out.println("Tipo de contato: " + this.descricao + " Contato: "+ this.telefone);
    }


}
