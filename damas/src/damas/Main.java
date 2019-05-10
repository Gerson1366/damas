package damas;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int jogadores;
		Scanner scanner = new Scanner(System.in);
		
		
	
		char opcao = 's';
		while(opcao == 's') {
		do {
			System.out.println("Declare o número de jogadores (1 ou 2): ");
			jogadores = scanner.nextInt();
		}while(jogadores!=1 && jogadores!=2);
		Tabuleiro tab = new Tabuleiro();
		do {
			//Imprimi o tabuleiro
			tab.ImprimirTabuleiro();
			//Caso seja um jogador, a CPU controla as pretas
			if(jogadores==1 && tab.getTurno()=="p") {
				tab.cpuMove();
				
			}else {
				tab.moverPeca();
			}
		}while(tab.getBrancas()>0 && tab.getPretas()>0 && !tab.isDesiste());
		
		
		if(tab.getBrancas()== 0 || !tab.isDesiste()) {
			System.out.println("CPU GANHOU! TOTAL DE: " +tab.count_winnerb +1 );
		}else if(tab.getPretas()== 0 && tab.isDesiste()){
			System.out.println("PLAYER GANHOU, TOTAL DE:  "+tab.count_winnerb +1);
		}
		
		
		//Imprime tabuleiro final
		tab.ImprimirTabuleiro();
		System.out.println("Fim");
		
		System.out.println("Jogar Novamente? (s)sim ");
		System.out.println("Para sair precione uma tecla... ");
		String teste = scanner.next();
		opcao = teste.charAt(0);
		

		
	   }	
	}
}
