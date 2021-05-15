package atvPratica1;

import java.util.Scanner;

public class TestarFilaComPrioridade {
	public static void main(String[] args) {

		FilaCP<String> fila = new FilaCP<String>();
		Scanner s = new Scanner(System.in);
		String pessoa;
		double atendidosPrioridade = 0, atendidosNormal = 0, totalAtendidos = 0;
		int op = 1;
		String menu = "OPÇÕES DA FILA\n\n1-Adiconar na fila comum\n2-Adicionar na fila prioritária"
				+ "\n3-Realizar atendimento\n4-Listar todas as pessoas da fila\n5-Estatísticas de"
				+ " atendimento\n0-Sair\n\nEscolha uma opção: ";

		while (op != 0) {
			System.out.print(menu);
			op = Integer.parseInt(s.nextLine());
			switch (op) {
				case 1:
					System.out.print("\nDigite o nome da pessoa: ");
					pessoa = s.nextLine();
					System.out.println();
					fila.adicionar(pessoa, false);
					atendidosNormal++;
					totalAtendidos++;
					break;

				case 2:
					System.out.print("\nDigite o nome da pessoa: ");
					pessoa = s.nextLine();
					System.out.println("\n");
					fila.adicionar(pessoa, true);
					atendidosPrioridade++;
					totalAtendidos++;
					break;

				case 3:
					if (fila.estaVazia(true) == true && fila.estaVazia(false) == true) {
						System.out.println("\nAmbas as filas estão vazias.\n");
						break;
					}
					System.out.println("\nPessoa atendida: " + fila.atender() + "\n");
					break;

				case 4:
					if (fila.estaVazia(true) == true && fila.estaVazia(false) == true) {
						System.out.println("\nAmbas as filas estão vazias.\n");
						break;
					}
					fila.exibir();
					break;

				case 5:
					if (atendidosNormal == 0 || atendidosPrioridade == 0) {
						System.out.println("\nAinda não é possível exibir as estatísticas por falta de dados.\n");
						break;
					}
					System.out.println(String.format("\nAtendimento prioritário: %.2f%%", (atendidosPrioridade / totalAtendidos) * 100));
					System.out.println(String.format("Atendimento normal: %.2f%%\n", (atendidosNormal / totalAtendidos) * 100));
					break;

				case 0:
					if (fila.estaVazia(true) == false || fila.estaVazia(false) == false) {
						System.out.println("\nNão é possivel sair.\nAinda há pessoas aguardando atentimento.\n");
						op = -1;
						break;
					}
					System.out.println("\nTotal de pessoas atendidas: " + (int) totalAtendidos + "\n");
					break;
			}
		}
		s.close();
		System.out.println("______________\nEND OF PROGRAM");
	}
}