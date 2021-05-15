package vetor;

import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    //Garante que o vetor sempre tenha espaço necessário para ser adicionado mais um elemento
    public void garanteEspaco(){
        if(totalDeAlunos == alunos.length){
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for(int i = 0; i < alunos.length; i++){
                novoArray[i] = alunos[i];
            }
            //Referencia o novo endereço de memória para o novo array criado
            this.alunos = novoArray;
        }
    }

    public void adiciona(Aluno aluno){
        garanteEspaco();

        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;
    }

    private boolean validoParaAdicionar(int posicao){
        return posicao >= 0 && posicao <= totalDeAlunos;
    }
    public void adiciona(int posicao, Aluno aluno){
        garanteEspaco();

        if(!validoParaAdicionar(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }

        for(int i = totalDeAlunos - 1; i >= posicao; i -= 1){
            alunos[i+1] = alunos[i];
        }

        alunos[posicao] = aluno;
        totalDeAlunos++;
    }

    private boolean posicaoOcupada(int posicao){
        //Tratamento para que caso o usuário passe uma posição não ocupada ele saiba o que errou
        return posicao >=0 && posicao < totalDeAlunos;
    }

    public Aluno pega(int posicao){

        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return alunos[posicao];
    }

    public void remove(int posicao){
        for (int i = posicao; i < totalDeAlunos - 1; i++){
            alunos[i] = alunos[i+1];
        }

        alunos[totalDeAlunos - 1] = null;
        totalDeAlunos--;
    }

    public boolean contem(Aluno aluno){

        for (int i = 0; i < totalDeAlunos; i++){
            if(aluno.equals(alunos[i])){
                return true;
            }
        }

        return false;
    }

    public int tamanho(){
        return totalDeAlunos;
    }

    public String toString(){
        return Arrays.toString(alunos);
    }
}
