package victorEmmanuel.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class AssociadoBD {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/associacao?useSSL=false", "root", "lEonid@s10");
			System.out.println("Conexão ok");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from associado");
			while(rs.next()) {
				int num = rs.getInt("numero");
				String nomeString = rs.getString("nome");
				long nasc = rs.getLong("nascimento");
				System.out.println("numero: " + num + " Nome: " + nomeString + " nascimento: " + nasc);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
			
		
		
		
	}
}
