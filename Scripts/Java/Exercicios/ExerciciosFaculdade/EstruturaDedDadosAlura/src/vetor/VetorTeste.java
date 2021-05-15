package vetor;

public class VetorTeste {

    public static void main(String[] args) {
        Aluno a1 = new Aluno("José");
        Aluno a2 = new Aluno("Carlos");

        Vetor lista = new Vetor();

        System.out.println(lista.tamanho());
        lista.adiciona(a1);
        System.out.println(lista.tamanho());
        lista.adiciona(a2);
        System.out.println(lista.tamanho());

        System.out.println(lista);
        System.out.println(lista.contem(a1));

        Aluno a3 = new Aluno("Diego");
        lista.adiciona(1, a3);

        System.out.println(lista.pega(1).getNome());

        System.out.println(lista);
        lista.remove(2);
        System.out.println(lista);

        for (int i = 0; i <300; i++){
            Aluno aluno = new Aluno("João" + i);
            lista.adiciona(aluno);
        }

        System.out.println(lista);
    }

}
