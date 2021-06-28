import java.io.IOException;
import java.util.*;

public class MapsTeste {

    public HashSet<String> leitura() throws IOException {
        Leitor leitor = new Leitor();

        HashSet<String> palavras = new HashSet<String>();
        palavras = leitor.reader(100000);

        return palavras; 
    }

    public HashMap<String, Integer> leituraHashMap(HashSet<String> palavras){
        HashMap<String, Integer> stHashMap = new HashMap<>();

        int i = 0;
        for (String palavraAtual : palavras) {
            stHashMap.put(palavraAtual, i);
            i++;
        }

        return stHashMap;
    }

    public LinkedHashMap<String, Integer> leituraLinkedHashSet(HashSet<String> palavras){
        LinkedHashMap<String, Integer> stHashMap = new LinkedHashMap<>();

        int i = 0;
        for (String palavraAtual : palavras) {
            stHashMap.put(palavraAtual, i);
            i++;
        }

        return stHashMap;
    }

    public TreeMap<String, Integer> leituraTreeMap(HashSet<String> palavras){
        TreeMap<String, Integer> stHashMap = new TreeMap<>();

        int i = 0;
        for (String palavraAtual : palavras) {
            stHashMap.put(palavraAtual, i);
            i++;
        }

        return stHashMap;
    }

    public void printarMap(Map<String, Integer> stHashMap){
        for (String keyAtual : stHashMap.keySet()) {
            System.out.println(keyAtual + ": " + stHashMap.get(keyAtual));
        }
    }

    public static void main(String[] args) throws IOException {

        MapsTeste mt = new MapsTeste();
        HashSet<String> palavras = mt.leitura();

        long startHM = System.currentTimeMillis();
        HashMap<String, Integer> stHashMap = mt.leituraHashMap(palavras);
        long finalHM = System.currentTimeMillis();

        long startLHM = System.currentTimeMillis();
        LinkedHashMap<String, Integer> stLinkedHashMap = mt.leituraLinkedHashSet(palavras);
        long finalLHM = System.currentTimeMillis();

        long startTM = System.currentTimeMillis();
        TreeMap<String, Integer> stTreeMap = mt.leituraTreeMap(palavras);
        long finalTM = System.currentTimeMillis();

        System.out.println("Tempo HashMap: " + (finalHM - startHM));
        System.out.println("Tempo LinkedHashMap: " + (finalLHM - startLHM));
        System.out.println("Tempo TreeMap: " + (finalTM - startTM));
    }

}
