package FilaDavi;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		GerenciadorDeFila gdf = new GerenciadorDeFila();
		Scanner s = new Scanner(System.in);
		String pessoa;
		int idade;
		int op = 1;
		String menu = "GERENCIADOR DE FILAS\n\n1 - Adicionar pessoas\n2 - Realizar atendimento"
				+ "\n3 - Listar todas as pessoas das filas\n4 - Estatísticas de atendimento"
				+ "\n0 - Sair\n\nEscolha uma opção: ";
		System.out.println("ATENÇÃO! Pessoas com 60 anos ou mais receberam atendimento prioritário."
				+ "\nE em cada fila(normal ou prioritária) todos serão atendidos por ordem alfabetica.\n");
		while (op != 0) {
			System.out.print(menu);
			op = Integer.parseInt(s.nextLine());
			switch (op) {
			case 1:
				System.out.print("\nDigitar nome: ");
				pessoa = s.nextLine();
				System.out.print("Digitar Idade: ");
				idade = Integer.parseInt(s.nextLine());
				gdf.add(pessoa, idade);
				break;
			case 2: gdf.attendance(); 
				break;
			case 3: gdf.toList(); 
				break;
			case 4: gdf.showStatistics(); 
				break;
			case 0:
				if ( !(gdf.queueP.isEmpty()) || !(gdf.queueN.isEmpty()) ) {
					System.out.println("\nNão é possivel sair.\nAinda há pessoas aguardando atentimento.\n");
					op = -1;
					break;
				}
				System.out.println("\nTotal de pessoas atendidas: " + (int) gdf.total + "\n");
				break;
			}
		}
		s.close(); 
		System.out.println("______________\nEND OF PROGRAM");
		
	}

}