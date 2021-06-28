import java.util.ArrayList;
import java.util.Random;

public class TestaTS {
    public static void main(String[] args) {
        int N = 10;
        SequentialSearchST<Integer, Integer> st = new SequentialSearchST<Integer, Integer>();
        ArrayList<Integer> chavesExistentes = new ArrayList<>();

        Random rd = new Random();
        for (int i = 0; i < N; i++) {
            st.put(rd.nextInt(), i);
        }
        for (Integer keyAtual : st.keys()) {
            chavesExistentes.add(keyAtual);
        }

    }
}
