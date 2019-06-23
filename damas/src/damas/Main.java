package damas;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;

public class Main {
	

	public static void main(String[] args) {
		int jogadores;
		int vitoriasBrancas = 0;
		int vitoriasPretas = 0;
		JFrame f = new JFrame("Tela Damas");
		TabuleiroGraphic tabGraphic = new TabuleiroGraphic();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(tabGraphic);
        f.pack();
        f.setVisible(true);
		//createWindow(tab);
		/*do {
			//Imprimi o tabuleiro
			//tab.ImprimirTabuleiro();
			//Caso seja um jogador, a CPU controla as pretas
			/*if(jogadores==1 && tab.getTurno()=="p") {
				tab.cpuMove();
				
			}else {
				tab.moverPeca();
			}
		}while(tab.getBrancas()>0 && tab.getPretas()>0 && !tab.isDesiste());
		
		
		if(tab.isDesiste()) {
			if(tab.getWinner()=="b") {
				System.out.println("Vitória Brancas restando "+tab.getBrancas()+" peças.");
				vitoriasBrancas++;
			}else {
				System.out.println("Vitória Pretas restando "+tab.getPretas()+" peças.");
				vitoriasPretas++;
			}
		}else{
			if(tab.getBrancas()<tab.getPretas()) {
				System.out.println("Vitória Pretas restando "+tab.getPretas()+" peças.");
				vitoriasPretas++;
			}else {
				System.out.println("Vitória Brancas restando "+tab.getBrancas()+" peças.");
				vitoriasBrancas++;
			}
			
		}
		
		
		//Imprime tabuleiro final
		//tab.ImprimirTabuleiro();
		System.out.println("Fim");
		
		System.out.println("Jogar Novamente? (s)sim ");
		System.out.println("Para sair precione uma tecla... ");
		String teste = scanner.next();
		opcao = teste.charAt(0);
		

		
	   }	
	   if(vitoriasBrancas>vitoriasPretas) {
		   System.out.println("Brancas venceram com "+vitoriasBrancas+" vitórias.");
	   }else {
		   System.out.println("Pretas venceram com "+vitoriasPretas+" vitórias.");
	   }*/
	}
	
	public static void createWindow(Tabuleiro tab)
    {
		
		JPanel newPanel = new JPanel();
       // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newPanel.add(tab);
         
    }
	
}
