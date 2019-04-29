package damas;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int brancas = 12;
		int pretas = 12;
		String posicaoPeca;
		String posicaoMovimento;
		Scanner scanner = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		do {
			tab.ImprimirTabuleiro();
			System.out.println("Qual peça branca deseja mover?(yx)");
			posicaoPeca = scanner.nextLine();
			int i = tab.recuperaValor(posicaoPeca.charAt(0));
			int j = Integer.parseInt(String.valueOf(posicaoPeca.charAt(1)))-1;
			if(i>=0 && i<=7) {
				if(j>=0 && j<=7) {
					if(tab.posicoes[i][j].isOcupado()==true) {
						if(tab.posicoes[i][j].getPeca().getCor()=="b") {
							System.out.println("Deseja mover a peça para qual posição?(yx)");
							posicaoMovimento = scanner.nextLine();
							int y = tab.recuperaValor(posicaoMovimento.charAt(0));
							int x = Integer.parseInt(String.valueOf(posicaoMovimento.charAt(1)))-1;
							if(x>=0 && x<=7) {
								if(y>=0 && y<=7) {
									System.out.println("Movimento "+tab.posicoes[i][j].getPos()+" para "+tab.posicoes[y][x].getPos());
									tab.posicoes[y][x].setPeca(tab.posicoes[i][j].getPeca());
									tab.posicoes[y][x].setOcupado(true);
									tab.posicoes[i][j].setPeca(null);
									tab.posicoes[i][j].setOcupado(false);
								}
							}
						}
					}
				}
			}
		}while(brancas>0 && pretas>0);
	}
}
