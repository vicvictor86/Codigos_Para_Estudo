import java.util.Calendar;
import java.util.Date;

public class TestaLocadora {

    public static void main(String[] args) {

        Carro carro = new Carro("marca", "modelo", new Date(2021, Calendar.DECEMBER, 9), "123", 100, 400, 1);

        System.out.println(carro.seguroDiario());

        Moto moto = new Moto("marca1", "modelo1", new Date(2020, Calendar.DECEMBER, 9), "1234", 100, 400, 11);
        Moto moto1 = new Moto("marca1", "modelo1", new Date(2020, Calendar.DECEMBER, 9), "12345", 100, 400, 11);

        Cliente cliente = new Cliente("Carlos", "123");
        Cliente cliente1 = new Cliente("Diego", "456");

        System.out.println(moto.seguroDiario());

        Locadora locadora = new Locadora();
        locadora.inserir(moto);
        locadora.inserir(moto1);
        locadora.inserir(carro);

        locadora.inserir(cliente);
        locadora.inserir(cliente1);

        locadora.registrarAluguel("1234", 2, cliente);
        locadora.registrarDevolucao("1234", cliente);

        locadora.registrarAluguel("12345", 2, cliente1);
        locadora.registrarDevolucao("12345", cliente1);

        locadora.registrarAluguel("123", 2, cliente1);
        locadora.registrarDevolucao("123", cliente1);

        locadora.depreciarVeiculos(1, 0.12);

        System.out.println(locadora.faturamentoTotal(1));
        System.out.println(locadora.quantidadeTotalDeDiarias(0));
    }
}
