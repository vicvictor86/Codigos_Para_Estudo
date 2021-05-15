package victorEmmanuelVieira.banco;

public class NoDaListaDeContas {
    private NoDaListaDeContas prox;
    private Conta conta;
    //Responsável em saber em quantas contas já percorreu na lista
    //As variáveis são static para que elas mantenham o mesmo valor nos outros objetos
    //Pois ao ser static a variável é da classe e não da instância
    private static int contador = 0;
    private static NoDaListaDeContas inicio;
    private static int totalDeElementos = 0;

    public NoDaListaDeContas procuraNaLista(int posicao){

        NoDaListaDeContas atual = inicio;
        for(int i = 0; i < posicao; i++){
            atual = atual.prox;
        }

        return atual;
    }

    public void incluir(Conta c){
        NoDaListaDeContas analisado = new NoDaListaDeContas();

        //Verifica se o programa precisa iniciar da referência inicio ou da conta
        if(contador == 0 && totalDeElementos > 0){
            analisado = inicio;
        }else{
            analisado = this;
        }
        //Insere quando não tem nenhum elemento
        if(analisado.conta == null){
            analisado.conta = c;
            prox = new NoDaListaDeContas();
            contador = 0;

            if(totalDeElementos == 0){
                inicio = this;
            }
            totalDeElementos++;

        } else if(analisado.conta != null){
            int menor = analisado.conta.getNum();
            int atual = c.getNum();

            if(atual < menor){

                //Insere no início
                if(contador == 0){
                    NoDaListaDeContas novoNo = new NoDaListaDeContas();
                    novoNo.conta = c;
                    novoNo.prox = inicio;
                    inicio = novoNo;
                    totalDeElementos++;
                }else {
                    //Insere no meio
                    NoDaListaDeContas aux = new NoDaListaDeContas();
                    NoDaListaDeContas anterior = procuraNaLista((contador - 1));

                    aux.conta = c;
                    aux.prox = anterior.prox;

                    anterior.prox = aux;
                    contador = 0;
                    totalDeElementos++;
                }
            }else{
                contador++;
                analisado.prox.incluir(c);
            }
        }
    }

    public Conta pesquisar(int num){
    	NoDaListaDeContas atual = inicio;
        while(atual.conta != null){
        	if(atual.conta.getNum() == num) {
        		return atual.conta;
        	}
            atual = atual.prox;
        }

        return null;
    }

    public Conta getConta() {
        return conta;
    }

    public NoDaListaDeContas getProx() {
        return prox;
    }

    public void mostraContas(){
        NoDaListaDeContas atual = inicio;
        for(int i = 0; i < totalDeElementos; i++){
            System.out.println(atual.getConta().getNum());
            atual = atual.prox;
		}
	}
}
