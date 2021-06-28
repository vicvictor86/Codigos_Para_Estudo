import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class Leitor {


	public HashSet<String> reader(int n) throws IOException {

		HashSet<String> palavras = new HashSet<String>();
		InputStream is = getClass().getClassLoader().getResourceAsStream("leipzig100k.txt");
		try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			 BufferedReader in = new BufferedReader(streamReader)) {

			String linha;
			while ((linha = in.readLine()) != null && palavras.size() < n) {


				linha = linha.trim().replaceAll("[^\\p{L} ]", "");


				String[] aux = linha.split("\s");
				for(int j = 0; j<aux.length;j++) {

					palavras.add(aux[j]);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return palavras;
	}

}