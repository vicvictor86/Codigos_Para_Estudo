import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoPreparedStatement {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {
			
			connection.setAutoCommit(false);

			try (PreparedStatement pst = connection.prepareStatement(
					"INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ( ? , ?)"
					, Statement.RETURN_GENERATED_KEYS) ) {

				adicionarVariavel("SmarTV", "45 polegadas", pst);
				adicionarVariavel("Radio", "Radio de bateria", pst);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement pst) throws SQLException {
		pst.setString(1, nome);
		pst.setString(2, descricao);
//		if(nome.equals("Radio")) {
//			throw new RuntimeException("Não foi possível adicionar o produto");
//		}
		//O execute precisa ser chamado para que o Statement(comando SQL) seja executado 
		pst.execute();
		
		try (ResultSet rst = pst.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}
	
}
