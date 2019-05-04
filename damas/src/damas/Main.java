package damas;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Declara total de pontos
		Tabuleiro tab = new Tabuleiro();
		do {
			//Imprimi o tabuleiro
			tab.ImprimirTabuleiro();
			tab.moverPeca();
		}while(tab.brancas>0 && tab.pretas>0);
	}
}
