import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			// irá pré compilar um comando e deixar as
			try (PreparedStatement stm = connection.prepareStatement("SELECT * FROM PRODUTO")) {

				// irá executar no query esse código
				stm.execute();

				// irá pegar o resultado da lista
				try (ResultSet rst = stm.getResultSet()) {

					while (rst.next()) {

						Integer id = rst.getInt("id");
						String nome = rst.getString("NOME");
						String descricao = rst.getString("DESCRICAO");

						System.out.println(id);
						System.out.println(nome);
						System.out.println(descricao);

					}

				}
			}
		}
	}
}
