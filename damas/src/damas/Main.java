package damas;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int jogadores;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Declare o número de jogadores (1 ou 2): ");
			jogadores = scanner.nextInt();
		}while(jogadores!=1 && jogadores!=2);
		//Declara total de pontos
		Tabuleiro tab = new Tabuleiro();
		do {
			//Imprimi o tabuleiro
			tab.ImprimirTabuleiro();
			if(jogadores==1 && tab.getTurno()=="p") {
				tab.cpuMove();
			}else {
				tab.moverPeca();
			}
		}while(tab.getBrancas()>0 && tab.getPretas()>0 && !tab.isDesiste());
		tab.ImprimirTabuleiro();
		System.out.println("Fim");
	}
}
