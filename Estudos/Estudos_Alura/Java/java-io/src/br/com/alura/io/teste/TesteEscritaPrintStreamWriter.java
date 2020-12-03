package br.com.alura.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TesteEscritaPrintStreamWriter{

	public static void main(String[] args) throws IOException {
		
		PrintWriter pw = new PrintWriter("lorem.txt");
		pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		pw.println();
		pw.println();
		pw.println("asdwqdqwqddqd");
		
		pw.close();
		
	}
}
