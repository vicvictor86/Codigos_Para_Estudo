import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		Integer id = 22;
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?")) {
				stm.setInt(1, id);
				stm.execute();

				Integer linhasModificadas = stm.getUpdateCount();
				System.out.println("Linhas modificadas: " + linhasModificadas);

			}
		}
	}
}
