package atividade;

public class Mainzinha {

	public static void main(String[] args) {
		
		BST<String, Integer> oiBst = new BST<String, Integer>();
		
		oiBst.put("H",2);
		oiBst.put("C",3);
		oiBst.put("A",1);
		oiBst.put("E",6);
		oiBst.put("S",4);
		oiBst.put("R",7);
		oiBst.put("X",10);
		//oiBst.put(14,14);
		//oiBst.put(13,13);
		//oiBst.put(9,9);

		System.out.println(oiBst.postOrder());
		System.out.println(oiBst.preOrder());
		System.out.println(oiBst.inOrder());

		System.out.println(oiBst.height());
		System.out.println(oiBst.internalPathLength());
		System.out.println(oiBst.size());

	}
	
}
