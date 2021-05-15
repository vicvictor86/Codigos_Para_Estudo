package trabalhoEstruturaDeDados;

import java.util.Scanner;

public class TestarLista {

	public static void main(String[] args) {
		ListaDuplamenteEncadeada lista  = new ListaDuplamenteEncadeada();
		String nome;
		Scanner s = new Scanner(System.in);
		int op=-1;
		String menu = "\nMENU:\n\n1 - Inserir um nome no inicio da lista\n2 - Inserir um nome no final da lista\n"
				+ "3 - Buscar nome\n4 - Excluir nome\n5 - Listar todos os nomes\n6 - Sair";
		while(op != 0) {
			System.out.println(menu);
			op = Integer.parseInt(s.nextLine());
			switch (op) {
				case 1:
					System.out.print("Digite o nome: ");
					nome = s.nextLine();
					lista.inserirInicio(nome);
					break;
				case 2:
					System.out.print("Digite o nome: ");
					nome = s.nextLine();
					lista.inserirFinal(nome);
					break;
				case 3:
					System.out.print("Digite o nome que voce deseja buscar: ");
					nome = s.nextLine();
					boolean  retorno = lista.buscar(nome);
					if(retorno) 
					System.out.println("O nome "+ nome + " foi encontrado na Lista!");
					else
					System.out.println("O nome "+ nome + " n�o foi encontrado na Lista!");
					break;
				case 4:
					System.out.print("Digite o nome que voce deseja excluir: ");
					nome = s.nextLine();
					lista.excluir(nome);
					break;
				case 5:
					System.out.println("Listagem dos nomes:\n");
					lista.listarNomes();
					break;
				case 6:
					System.out.println("\n\n---------------\nEND OF PROGRAM");
					op = 0;
				default:
					break;
			}
		}
		s.close();
	}

}
