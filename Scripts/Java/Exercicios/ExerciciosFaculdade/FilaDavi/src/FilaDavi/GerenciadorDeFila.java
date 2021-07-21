package FilaDavi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GerenciadorDeFila {
	
	//Comparator<String> cds =  new ComparadorDeStrings();
	PriorityQueue<String> queueP = new PriorityQueue<String>();
	PriorityQueue<String> queueN = new PriorityQueue<String>();
	double priorityService = 0, normalService = 0, total = 0;
	
	public void add(String people, int age) {
		
		if(age>=60) {
			queueP.add(people); 
			priorityService++;
			total++;
			System.out.println("\nPessoa Idosa!\nAdicionado na fila prioritária.\n");
			return;
		}else{
			queueN.add(people);
			normalService++;
			total++;
			System.out.println("Adicionado na fila normal.\n");
			return;
		}
	}

	public void attendance() {
		
		if (queueP.isEmpty() && queueN.isEmpty()) {
			System.out.println("\nAmbas as filas estão vazias.\n");
			return;
		}
		if(queueP.isEmpty()) {
			System.out.println("\nPessoa atendida: " + queueN.poll()+ "\n");
		}
		else {
			System.out.println("\nPessoa atendida: " + queueP.poll() + "\n");
		}
	}
	
	public void toList() {
		
		if (queueN.isEmpty() && queueP.isEmpty()) {
			System.out.println("\nAmbas as filas estão vazias.\n");
			return;
		}
			if(queueP.isEmpty()) {
				System.out.print("FILA PRIORITARIA VAZIA!\n");
			}else {
				System.out.print("FILA PRIORITARIA: ");
				System.out.print(queueP);
				
			}
			if(queueN.isEmpty()) {
				System.out.println("\nFILA NORMAL VAZIA!\n");
			}else {
				System.out.print("\nFILA NORMAL: ");
				System.out.println(queueN);
				System.out.println();
			}
	}
	
	public void showStatistics() {
		
		if (normalService == 0 || priorityService == 0) {
			System.out.println("\nAinda não é possível exibir as estatísticas por falta de dados.\n");
		}
		System.out.println(String.format("\nAtendimento prioritário: %.2f%%", (priorityService / total) * 100));
		System.out.println(String.format("Atendimento normal: %.2f%%\n", (normalService / total) * 100));
	}
	
}