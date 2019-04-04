import java.io.*;
import java.util.*;


public class Jogodamas {


		int pecabranca ;
		int pecapreta ;
		public char tabela[][];
		private final static int tamTabela = 8;	
		char pecaJogando; //saber quem esta jogando na tabela .. preto ou branco;

		
		public Jogodamas() {
			tabela = new char[tamTabela][tamTabela];
			pecabranca = 12;
			pecapreta = 12;
			pecaJogando = 'b';
			
			
		int i, j;
		
		for (i=0; i < tamTabela;i++)
			for(j=0; j< tamTabela; j++)
				tabela[i][j] = '_';
		
		for (i=1; i < tamTabela; i+=2) {
			tabela[i][1] = 'b';
			tabela[i][5] = 'p';
			tabela[i][7] = 'p';
		}
		
		for(i=0; i < tamTabela;i+=2) {
			tabela[i][0] = 'b';
			tabela[i][2] = 'b';
			tabela[i][6] = 'p';
			}
			
		}
		

		public void imprimiTabela() {
			int i, j;
			System.out.println("  1 2 3 4 5 6 7 8 x");
			for (i=0; i < tamTabela; i++) {
				System.out.print((i+1) + " ");
				for (j=0; j < tamTabela; j++) {
					System.out.print(tabela[j][i] + " ");
				}
				System.out.println("y");
			}
		}
		
}

