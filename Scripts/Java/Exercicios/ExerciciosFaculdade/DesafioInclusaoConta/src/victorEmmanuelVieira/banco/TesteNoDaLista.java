package victorEmmanuelVieira.banco;

public class TesteNoDaLista {

    public static void main(String[] args) {
        NoDaListaDeContas no = new NoDaListaDeContas();
        Conta conta1 = new Conta();
        conta1.setNum(5);
        conta1.credito(200);
        Conta conta2 = new Conta();
        conta2.setNum(7);
        Conta conta3 = new Conta();
        conta3.setNum(2);
        Conta conta4 = new Conta();
        conta4.setNum(4);
        Conta conta5 = new Conta();
        conta5.setNum(12);
        Conta conta6 = new Conta();
        conta6.setNum(1);
        Conta conta7 = new Conta();
        conta7.setNum(8);
        Conta conta8 = new Conta();
        conta8.setNum(11);

        no.incluir(conta1);
        no.incluir(conta2);
        no.incluir(conta3);
        no.incluir(conta4);
        no.incluir(conta5);
        no.incluir(conta6);
        no.incluir(conta7);
        no.incluir(conta8);

        no.mostraContas();
        System.out.println("Primeiro elemento: " + no.pesquisar(5).getSaldo());
    }

}
