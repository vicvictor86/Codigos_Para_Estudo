import java.util.Calendar;
import java.util.Date;

public class TestaLocadora {

    public static void main(String[] args) {

        Veiculos veiculo = new Veiculos("marca", "modelo", new Date(2021, Calendar.DECEMBER, 9), "123", 200, 500, 0.05);

        System.out.println(veiculo.seguroDiario());

        Moto moto = new Moto("marca1", "modelo1", new Date(2020, Calendar.DECEMBER, 9), "1234", 100, 400, 11);

        System.out.println(moto.seguroDiario());
    }
}
