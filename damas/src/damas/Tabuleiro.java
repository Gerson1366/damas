package damas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tabuleiro extends JPanel{
	
	private Pos b2;
	private String pos_sup[];
	private String pos_inf[];
	private Pos[][] posicoes = new Pos[8][8];
	private int brancas = 12;
	private int pretas = 12;
	private String posicaoPeca;
	private String posicaoMovimento;
	private String turno="b";
	private String oponente="p";
	private Pos pecaMatar=null;
	private ArrayList<Peca> pecasPretas = new ArrayList<Peca>();
	private boolean desiste = false;
	private String winner;
	private String loser;
	private Peca pecaSelect;

    

	public final Peca getPecaSelect() {
		return pecaSelect;
	}



	public final void setPecaSelect(Peca pecaSelect) {
		this.pecaSelect = pecaSelect;
	}



	public Tabuleiro() {
  		for(int x=0;x<8;x++) {
  			for(int i=0;i<8;i++) {
  				String posx = Integer.toString(x+1);
  				//Cria uma nova posição para cada espaço do tabuleiro
  				Pos pos = new Pos();
  				//Qual a linha da matrix
  				if(i==0) {
  					//Se a coluna é par ou impar (determina onde vai as peças em cada linha)
  					if(x % 2 == 0) {
  						//Espaço que vai peça
  						Peca peca = new Peca();
  						//Determina a cor da peça
  						peca.setCor("p");
  						//Determina posição da peça
  						peca.setPos_x(x);
  						peca.setPos_y(i);
  						//Posição é ocupada pela peça
  						pos.setOcupado(true);
  						//Coloca peça dentro da posição
  						pos.setPeca(peca);
  						//Adiciona peça na lista para a CPU
  						pecasPretas.add(peca);
  					}else {
  						//Se a posição não recebe peça, marca como não ocupada
  						pos.setOcupado(false);
  					}
  				}else if(i==1) {
  					if(x % 2 != 0) {
  						Peca peca = new Peca();
  						peca.setCor("p");
  						peca.setPos_x(x);
  						peca.setPos_y(i);
  						pos.setOcupado(true);
  						pos.setPeca(peca);
  						pecasPretas.add(peca);
  					}else {
  						pos.setOcupado(false);
  					}
  				}else if(i==2) {
  					if(x % 2 == 0) {
  						Peca peca = new Peca();
  						peca.setCor("p");
  						peca.setPos_x(x);
  						peca.setPos_y(i);
  						pos.setOcupado(true);
  						pos.setPeca(peca);
  						pecasPretas.add(peca);
  					}else {
  						pos.setOcupado(false);
  					}
  				}
  				else if(i==5) {
  					if(x % 2 != 0) {
  						Peca peca = new Peca();
  						peca.setCor("b");
  						peca.setPos_x(x);
  						peca.setPos_y(i);
  						pos.setOcupado(true);
  						pos.setPeca(peca);
  					}else {
  						pos.setOcupado(false);
  					}
  				}
  				else if(i==6) {
  					if(x % 2 == 0) {
  						Peca peca = new Peca();
  						peca.setCor("b");
  						peca.setPos_x(x);
  						peca.setPos_y(i);
  						pos.setOcupado(true);
  						pos.setPeca(peca);
  					}else {
  						pos.setOcupado(false);
  					}
  				}else if(i==7) {
  					if(x % 2 != 0) {
  						Peca peca = new Peca();
  						peca.setCor("b");
  						peca.setPos_x(x);
  						peca.setPos_y(i);
  						pos.setOcupado(true);
  						pos.setPeca(peca);
  					}else {
  						pos.setOcupado(false);
  					}
  				}else {
  					pos.setOcupado(false);
  				}
  				pos.setPos(converteValor(i)+posx);
  				posicoes[i][x]=pos;
  			}
  		}
	}
	
	
	
	public void ImprimirTabuleiro() {
		int i, j;
		//Imprime legenda do tabuleiro (coluna)
		System.out.println("  1 2 3 4 5 6 7 8 x");
		//Monta matriz
		for (i=0; i < 8; i++) {
			//Imprime legenda do tabuleiro (linha)
			System.out.print(converteValor(i) + " ");
			for (j=0; j < 8; j++) {
				//Se está desocupado, não imprime nada
				if(posicoes[i][j].isOcupado()==false) {
					System.out.print("  ");
				}else{
					if(posicoes[i][j].getPeca().isDama()) {
						//Se a peça é dama, fica caixa alta
						System.out.print(posicoes[i][j].getPeca().getCor().toUpperCase() + " ");
					}else {
						System.out.print(posicoes[i][j].getPeca().getCor() + " ");
					}
				}
			}
			System.out.println("y");
		}
	}
	
	//Converte o valor alfabético para posição da matriz
	public String converteValor(int valor) {
		if(valor==0) {
			return "a";
		}else if(valor==1) {
			return "b";
		}else if(valor==2) {
			return "c";
		}else if(valor==3) {
			return "d";
		}else if(valor==4) {
			return "e";
		}else if(valor==5) {
			return "f";
		}else if(valor==6) {
			return "g";
		}else if(valor==7) {
			return "h";
		}else {
			return "x";
		}
	}
	
	//Retorna o alfabeto da posição da matriz
	public int recuperaValor(char valor) {
		if(valor=='a') {
			return 0;
		}else if(valor=='b') {
			return 1;
		}else if(valor=='c') {
			return 2;
		}else if(valor=='d') {
			return 3;
		}else if(valor=='e') {
			return 4;
		}else if(valor=='f') {
			return 5;
		}else if(valor=='g') {
			return 6;
		}else if(valor=='h') {
			return 7;
		}else {
			return 8;
		}
	}
	
	//Testa se valor é int
	public static boolean isInteger(String str) { 
	  try {  
	    Integer.parseInt(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
	
	//Calcula movimento da dama cima/esquerda
	public boolean moveDamaUpEsq(int y1, int x1,int y2,int x2) {
		//Acha o último ponto possível do tabuleiro
		while(x2>0 && y2>0) {
			y2 = y2-1;
			x2 = x2-1;
		}
		//Testa até chega de volta ao ponto de origem
		while(x2<x1 && y2<y1) {
			//Testa se pode movimentar
			if(this.moverDama(y1,x1,y2,x2)) {
				return true;
			}else {
				//Caso não movimente, volta uma casa
				y2++;
				x2++;
			}
		}
		return false;
	}
	
	//Calcula movimento da dama cima/direita
	public boolean moveDamaUpDir(int y1, int x1,int y2,int x2) {
		while(x2<7 && y2>0) {
			y2 = y2-1;
			x2 = x2+1;
		}
		while(x2>x1 && y2<y1) {
			if(this.moverDama(y1,x1,y2,x2)) {
				return true;
			}else {
				y2++;
				x2--;
			}
		}
		return false;
	}
	
	//Calcula movimento da dama baixo/direita
	public boolean moveDamaDownDir(int y1, int x1,int y2,int x2) {
		while(x2<7 && y2<7) {
			y2 = y2+1;
			x2 = x2+1;
		}
		while(x2>x1 && y2>y1) {
			if(this.moverDama(y1,x1,y2,x2)) {
				return true;
			}else {
				y2--;
				x2--;
			}
		}
		return false;
	}
	
	//Calcula movimento da dama baixo/esquerda
	public boolean moveDamaDownEsq(int y1, int x1,int y2,int x2) {
		while(x2>0 && y2<7) {
			y2 = y2+1;
			x2 = x2-1;
		}
		while(x2<x1 && y2>y1) {
			if(this.moverDama(y1,x1,y2,x2)) {
				return true;
			}else {
				y2--;
				x2++;
			}
		}
		return false;
	}
	
	public void cpuMove() {
		ArrayList<Peca> listaPecas = new ArrayList<Peca>();
		//Cria uma cópia da lista de peças para a CPU testar
		listaPecas = (ArrayList<Peca>) pecasPretas.clone();
		Random rand = new Random(); 
		int randInt;
		int sideInt;
		boolean move = false;
		//System.out.println("Oponente está pensando...");
		//Executa até que a lista acabe ou consiga mover
		while(listaPecas.size()>0 && move==false) {
			//Pega um valor aleatório dentro do tamanho da lista para pegar uma peça
			randInt = rand.nextInt(listaPecas.size());
			Peca pecaCPU = listaPecas.get(randInt);
			//Se a peça está viva, tenta a jogada
			if(pecaCPU.isViva()) {
				//Se a peça é dama
				if(pecaCPU.isDama()) {
					//Se a peça for dama, tem 4 opções de testagens para ela poder andar, evocando as funções definidas acima.
					sideInt = rand.nextInt(4);
					int x1 = pecaCPU.getPos_x();
					int y1 = pecaCPU.getPos_y();
					int x2 = x1;
					int y2 = y1;
					if(sideInt==0) {
						if(this.moveDamaDownDir(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaDownEsq(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaUpDir(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaUpEsq(y1, x1, y2, x2)) {
							move = true;
						}else {
							//Cada vez que qualquer movimento for impossível com aquela peça, remove da lista
							listaPecas.remove(randInt);
						}
					}else if(sideInt==1) {
						if(this.moveDamaDownEsq(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaDownDir(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaUpEsq(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaUpDir(y1, x1, y2, x2)) {
							move = true;
						}else {
							listaPecas.remove(randInt);
						}
					}else if(sideInt==2) {
						if(this.moveDamaUpDir(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaUpEsq(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaDownDir(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaDownEsq(y1, x1, y2, x2)) {
							move = true;
						}else {
							listaPecas.remove(randInt);
						}
					}else {
						if(this.moveDamaUpEsq(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaUpDir(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaDownEsq(y1, x1, y2, x2)) {
							move=true;
						}else if(this.moveDamaDownDir(y1, x1, y2, x2)) {
							move = true;
						}else {
							listaPecas.remove(randInt);
						}
					}
				}else {
					//Não sendo dama, sorteia se vai tentar andar primeiro para a esquerda ou direita
					//Se tanto esquerda quanto direita falharem, tira a peça da lista
					
					sideInt = rand.nextInt(2);
					if(sideInt==0) {
						int x1 = pecaCPU.getPos_x();
						int x2 = x1-1;
						int y1 = pecaCPU.getPos_y();
						int y2 = y1+1;
						if((x2>=0 && x2<=7)&& (y2>=0 && y2<=7)) {
							if(this.moverPreta(y1,x1,y2,x2)) {
								move=true;
							}else {
								x1 = pecaCPU.getPos_x();
								x2 = x1+1;
								y1 = pecaCPU.getPos_y();
								y2 = y1+1;
								if((x2>=0 && x2<=7)&& (y2>=0 && y2<=7)) {
									if(this.moverPreta(y1, x1, y2, x2)) {
										move=true;
									}else {
										listaPecas.remove(randInt);
									}
								}
							}
						}
					}else {
						int x1 = pecaCPU.getPos_x();
						int x2 = x1+1;
						int y1 = pecaCPU.getPos_y();
						int y2 = y1+1;
						if((x2>=0 && x2<=7)&& (y2>=0 && y2<=7)) {
							if(this.moverPreta(y1, x1, y2, x2)) {
								move=true;
							}else {
								x1 = pecaCPU.getPos_x();
								x2 = x1-1;
								y1 = pecaCPU.getPos_y();
								y2 = y1+1;
								//Testa se valor está dentro do tabuleiro
								if((x2>=0 && x2<=7)&& (y2>=0 && y2<=7)) {
									if(this.moverPreta(y1, x1, y2, x2)) {
										move=true;
									}else {
										listaPecas.remove(randInt);
									}
								}
							}
						}
					}
				}
			}else {
				listaPecas.remove(randInt);
			}
		}
		//Caso a CPU não consiga mover nenhuma peça após testar todas, ela perde
		if(move==false) {
			this.desiste=true;
			this.winner="b";
			this.loser="p";
		}
	}
	
	public void moverPeca() {
		Scanner scanner = new Scanner(System.in);
		if(this.turno=="b") {
			System.out.println("Qual peça branca deseja mover?(yx)( 00 para desistir!):");
		}else if(this.turno=="p") {
			System.out.println("Qual peça preta deseja mover?(yx)( 00 para desistir!):");
		}
		posicaoPeca = scanner.nextLine();
		if(posicaoPeca.equals("00")){
			this.desiste=true;
			this.winner=this.oponente;
			this.loser=this.turno;
			
			}else{
			//Pega valor da String e separa primeiro valor do segundo, convertendo cada valor para int
			int i = this.recuperaValor(posicaoPeca.charAt(0));
			if(this.isInteger(String.valueOf(posicaoPeca.charAt(1)))){
				int j = Integer.parseInt(String.valueOf(posicaoPeca.charAt(1)))-1;
				//Testa se valor está dentro do tabuleiro
				if(i>=0 && i<=7) {
					if(j>=0 && j<=7) {
						//Testa se existe peça na posição de peça que vai mover
						if(this.posicoes[i][j].isOcupado()==true) {
							//Testa se a peça ocupadando o espaço é a peça do jogador
							if(this.posicoes[i][j].getPeca().getCor()==this.turno) {
								System.out.println("Deseja mover a peça para qual posição?(yx)");
								//Pega o valor do tabuleiro para onde vai mover a peça
								posicaoMovimento = scanner.nextLine();
								//Converte valores para int
								if(posicaoMovimento.length()>1) {
									int y = this.recuperaValor(posicaoMovimento.charAt(0));
									if(this.isInteger(String.valueOf(posicaoMovimento.charAt(1)))){
										int x = Integer.parseInt(String.valueOf(posicaoMovimento.charAt(1)))-1;
										//Testa se posição para mover a peça está dentro do tabuleiro
										if(x>=0 && x<=7) {
											if(y>=0 && y<=7) {
												//Testa se posição para mover a peça é uma linha acima da peça atual
												if(this.posicoes[i][j].getPeca().isDama()) {
													this.moverDama(i,j,y,x);
												}else {
													if(turno=="b") {
														this.moverBranca(i,j,y,x);
													}else if(turno=="p") {
														this.moverPreta(i,j,y,x);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public boolean moverDama(int i,int j,int y,int x) {
		String oponente;
		if(this.buscarCaminho(i,j,y,x)) {
			if(this.pecaMatar!=null) {
				this.pecaMatar.getPeca().setViva(false);
				this.pecaMatar.setPeca(null);
				this.pecaMatar.setOcupado(false);
				if(this.turno=="b") {
					//System.out.println("Branca: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos()+" Destruiu: "+this.pecaMatar.getPos());
				}else {
					//System.out.println("Preta: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos()+" Destruiu: "+this.pecaMatar.getPos());
				}
				this.pecaMatar = null;
				if(this.oponente=="p") {
					pretas--;
				}else {
					brancas--;
				}
			}else {
				if(this.turno=="b") {
					//System.out.println("Branca: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos());
				}else {
					//System.out.println("Preta: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos());
				}
			}
			this.posicoes[y][x].setPeca(this.posicoes[i][j].getPeca());
			this.posicoes[y][x].setOcupado(true);
			this.posicoes[i][j].setPeca(null);
			this.posicoes[i][j].setOcupado(false);
			this.posicoes[y][x].getPeca().setPos_x(x);
			this.posicoes[y][x].getPeca().setPos_y(y);
			oponente = this.oponente;
			this.oponente = this.turno;
			this.turno=oponente;
			return true;
		}else {
			this.pecaMatar = null;
			return false;
		}
	}
	
	public boolean buscarCaminho(int i,int j,int y,int x) {
		int pecas=0;
		boolean caminho = false;
		//i e j valor inicial. y e x valor para mover
		//Testa se movimento foi para a esquerda
		if(y<i) {
			//Testa se movimento foi para cima
			if(x<j) {
				do {
					j--;
					i--;
					if(this.posicoes[i][j].isOcupado()) {
						if(this.posicoes[i][j].getPeca().getCor()==this.turno) {
							pecas=2;
						}else {
							this.pecaMatar = this.posicoes[i][j];
							pecas++;
						}
					}
					if(j==x && i==y) {
						if(!this.posicoes[i][j].isOcupado()) {
							caminho=true;
						}
					}
				}while(x<j && y<i && pecas<2);
				if(pecas<2 && caminho==true) {
					return true;
				}else {
					return false;
				}
			//Testa se movimento foi para baixo
			}else if(x>j) {
				do {
					j++;
					i--;
					if(this.posicoes[i][j].isOcupado()) {
						if(this.posicoes[i][j].getPeca().getCor()==this.turno) {
							pecas=2;
						}else {
							this.pecaMatar = this.posicoes[i][j];
							pecas++;
						}
					}
					if(j==x && i==y) {
						if(!this.posicoes[i][j].isOcupado()) {
							caminho=true;
						}
					}
				}while(x>j && y<i && pecas<2);
				if(pecas<2 && caminho==true) {
					return true;
				}else {
					return false;
				}
			}else {
				//Caso movimento seja na mesma coluna da origem
				return false;
			}
		//Testa se movimento foi para a direita
		}else if(y>i) {
			//Testa se movimento foi para cima
			if(x<j) {
				do {
					j--;
					i++;
					if(this.posicoes[i][j].isOcupado()) {
						if(this.posicoes[i][j].getPeca().getCor()==this.turno) {
							pecas=2;
						}else {
							this.pecaMatar = this.posicoes[i][j];
							pecas++;
						}
					}
					if(j==x && i==y) {
						if(!this.posicoes[i][j].isOcupado()) {
							caminho=true;
						}
					}
				}while(x<j && y>i && pecas<2);
				if(pecas<2 && caminho==true) {
					return true;
				}else {
					return false;
				}
			//Testa se movimento foi para baixo
			}else if(x>j) {
				do {
					j++;
					i++;
					if(this.posicoes[i][j].isOcupado()) {
						if(this.posicoes[i][j].getPeca().getCor()==this.turno) {
							pecas=2;
						}else {
							this.pecaMatar = this.posicoes[i][j];
							pecas++;
						}
					}
					if(j==x && i==y) {
						if(!this.posicoes[i][j].isOcupado()) {
							caminho=true;
						}
					}
				}while(x>j && y>i && pecas<2);
				if(pecas<2 && caminho==true) {
					return true;
				}else {
					return false;
				}
			}else {
				//Se movimento for na mesma coluna da origem
				return true;
			}
		}else {
			//Se valor para mover é na mesma linha que posicão original
			return false;
		}
	}
	
	public boolean moverPreta(int i,int j,int y,int x) {
		//Para arrumar caso jogue após a peça que vai pegar
		if(x<j) {
			if(y-i==2 && j-x==2) {
				y--;
				x++;
			}
		}else {
			if(y-i==2 && x-j==2) {
				y--;
				x--;
			}
		}
		if(y==(i+1)) {
			//Testa se posição para mover a peça é uma linha à esquerda ou direita da posição atual
			if((x==(j-1)) || (x==(j+1))) {
				//Testa se não há outra peça no lugar
				if(this.posicoes[y][x].isOcupado()==true) {
					//Testa se a peça ocupando o espaço é oponente
					if(this.posicoes[y][x].getPeca().getCor()=="b") {
						//Testa se posição acima da peça é dentro do tabuleiro
						if(y+1<=7) {
							//Testa se movimento foi à esquerda
							if(x==(j-1)) {
								//Testa se movimento está dentro do tabuleiro
								if(j-2>=0) {
									//Testa se posição acima da peça é ocupada
									if(this.posicoes[i+2][j-2].isOcupado()==false) {
										this.posicoes[i+2][j-2].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i+2][j-2].setOcupado(true);
										//System.out.println("Preta: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[i+2][j-2].getPos()+" Destruiu: "+this.posicoes[i+1][j-1].getPos());
										this.posicoes[i+2][j-2].getPeca().setPos_x(j-2);
										this.posicoes[i+2][j-2].getPeca().setPos_y(i+2);
										if((i+2)==7) {
											this.posicoes[i+2][j-2].getPeca().setDama(true);
										}
										this.posicoes[i+1][j-1].getPeca().setViva(false);
										this.posicoes[i+1][j-1].setOcupado(false);
										this.posicoes[i+1][j-1].setPeca(null);
										this.posicoes[i][j].setPeca(null);
										this.posicoes[i][j].setOcupado(false);
										this.brancas--;
										this.turno="b";
										this.oponente="p";
										return true;
									}else {
										return false;
									}
								}else {
									return false;
								}
							}else if(x==(j+1)) {
							//Testa se movimento foi à direita
								if(j+2<=7) {
									//Testa se posição acima da peça é ocupada
									if(this.posicoes[i+2][j+2].isOcupado()==false) {
										this.posicoes[i+2][j+2].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i+2][j+2].setOcupado(true);
										//System.out.println("Preta: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[i+2][j+2].getPos()+" Destruiu: "+this.posicoes[i+1][j+1].getPos());
										this.posicoes[i+2][j+2].getPeca().setPos_x(j+2);
										this.posicoes[i+2][j+2].getPeca().setPos_y(i+2);
										if((i+2)==7) {
											this.posicoes[i+2][j+2].getPeca().setDama(true);
										}
										this.posicoes[i+1][j+1].getPeca().setViva(false);
										this.posicoes[i+1][j+1].setOcupado(false);
										this.posicoes[i+1][j+1].setPeca(null);
										this.posicoes[i][j].setPeca(null);
										this.posicoes[i][j].setOcupado(false);
										this.brancas--;
										this.turno="b";
										this.oponente="p";
										return true;
									}else {
										return false;
									}
								}else {
									return false;
								}
							}else {
								return false;
							}
						}else {
							return false;
						}
					}else {
						return false;
					}
				}else {
					//Move a peça para a posição
					//System.out.println("Preta: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos());
					this.posicoes[y][x].setPeca(this.posicoes[i][j].getPeca());
					this.posicoes[y][x].setOcupado(true);
					this.posicoes[y][x].getPeca().setPos_x(x);
					this.posicoes[y][x].getPeca().setPos_y(y);
					if(y==7) {
						this.posicoes[y][x].getPeca().setDama(true);
					}
					this.posicoes[i][j].setPeca(null);
					this.posicoes[i][j].setOcupado(false);
					this.turno="b";
					this.oponente="p";
					return true;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean moverBranca(int i,int j,int y,int x) {
		//Para arrumar caso jogue após a peça que vai pegar
		if(x<j) {
			if(i-y==2 && j-x==2) {
				y++;
				x++;
			}
		}else {
			if(i-y==2 && x-j==2) {
				y++;
				x--;
			}
		}
		if(y==(i-1)) {
			//Testa se posição para mover a peça é uma linha à esquerda ou direita da posição atual
			if((x==(j-1)) || (x==(j+1))) {
				//Testa se não há outra peça no lugar
				if(this.posicoes[y][x].isOcupado()==true) {
					//Testa se a peça ocupando o espaço é oponente
					if(this.posicoes[y][x].getPeca().getCor()=="p") {
						//Testa se posição acima da peça é dentro do tabuleiro
						if(y-1>=0) {
							//Testa se movimento foi à esquerda
							if(x==(j-1)) {
								//Testa se movimento está dentro do tabuleiro
								if(j-2>=0) {
									//Testa se posição acima da peça é ocupada
									if(this.posicoes[i-2][j-2].isOcupado()==false) {
										this.posicoes[i-2][j-2].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i-2][j-2].setOcupado(true);
										//System.out.println("Branca: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[i-2][j-2].getPos()+" Destruiu: "+this.posicoes[i-1][j-1].getPos());
										if((i-2)==0) {
											this.posicoes[i-2][j-2].getPeca().setDama(true);
										}
										this.posicoes[i-1][j-1].getPeca().setViva(false);
										this.posicoes[i-1][j-1].setPeca(null);
										this.posicoes[i-1][j-1].setOcupado(false);
										this.posicoes[i][j].setOcupado(false);
										this.posicoes[i][j].setPeca(null);
										this.pretas--;
										this.turno="p";
										this.oponente="b";
										return true;
									}else {
										return false;
									}
								}else {
									return false;
								}
							}else if(x==(j+1)) {
							//Testa se movimento foi à direita
								if(j+2<=7) {
									//Testa se posição acima da peça é ocupada
									if(this.posicoes[i-2][j+2].isOcupado()==false) {
										//System.out.println("Branca: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[i-2][j+2].getPos()+" Destruiu: "+this.posicoes[i-1][j+1].getPos());
										this.posicoes[i-2][j+2].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i-2][j+2].setOcupado(true);
										if((i-2)==0) {
											this.posicoes[i-2][j+2].getPeca().setDama(true);
										}
										this.posicoes[i-1][j+1].getPeca().setViva(false);
										this.posicoes[i-1][j+1].setPeca(null);
										this.posicoes[i-1][j+1].setOcupado(false);
										this.posicoes[i][j].setOcupado(false);
										this.posicoes[i][j].setPeca(null);
										this.pretas--;
										this.turno="p";
										this.oponente="b";
										return true;
									}else {
										return false;
									}
								}else {
									return false;
								}
							}else {
								return false;
							}
						}else {
							return false;
						}
					}else {
						return false;
					}
				}else {
					//Move a peça para a posição
					//System.out.println("Branca: "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos());
					this.posicoes[y][x].setPeca(this.posicoes[i][j].getPeca());
					this.posicoes[y][x].setOcupado(true);
					if(y==0) {
						this.posicoes[y][x].getPeca().setDama(true);
					}
					this.posicoes[i][j].setPeca(null);
					this.posicoes[i][j].setOcupado(false);
					this.turno="p";
					this.oponente="b";
					return true;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public final Pos getB2() {
		return b2;
	}

	public final void setB2(Pos b2) {
		this.b2 = b2;
	}

	public final String[] getPos_sup() {
		return pos_sup;
	}

	public final void setPos_sup(String[] pos_sup) {
		this.pos_sup = pos_sup;
	}

	public final String[] getPos_inf() {
		return pos_inf;
	}

	public final void setPos_inf(String[] pos_inf) {
		this.pos_inf = pos_inf;
	}

	public final Pos[][] getPosicoes() {
		return posicoes;
	}

	public final void setPosicoes(Pos[][] posicoes) {
		this.posicoes = posicoes;
	}

	public final int getBrancas() {
		return brancas;
	}

	public final void setBrancas(int brancas) {
		this.brancas = brancas;
	}

	public final int getPretas() {
		return pretas;
	}

	public final void setPretas(int pretas) {
		this.pretas = pretas;
	}

	public final String getPosicaoPeca() {
		return posicaoPeca;
	}

	public final void setPosicaoPeca(String posicaoPeca) {
		this.posicaoPeca = posicaoPeca;
	}

	public final String getPosicaoMovimento() {
		return posicaoMovimento;
	}

	public final void setPosicaoMovimento(String posicaoMovimento) {
		this.posicaoMovimento = posicaoMovimento;
	}

	public final String getTurno() {
		return turno;
	}

	public final void setTurno(String turno) {
		this.turno = turno;
	}

	public final String getOponente() {
		return oponente;
	}

	public final void setOponente(String oponente) {
		this.oponente = oponente;
	}

	public final Pos getPecaMatar() {
		return pecaMatar;
	}

	public final void setPecaMatar(Pos pecaMatar) {
		this.pecaMatar = pecaMatar;
	}

	public final ArrayList<Peca> getPecasPretas() {
		return pecasPretas;
	}

	public final void setPecasPretas(ArrayList<Peca> pecasPretas) {
		this.pecasPretas = pecasPretas;
	}

	public final boolean isDesiste() {
		return desiste;
	}

	public final void setDesiste(boolean desiste) {
		this.desiste = desiste;
	}

	public final String getWinner() {
		return winner;
	}

	public final void setWinner(String winner) {
		this.winner = winner;
	}

	public final String getLoser() {
		return loser;
	}

	public final void setLoser(String loser) {
		this.loser = loser;
	}
	
	class mouseTab implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Pos x: "+arg0.getX());
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		

		
		
	}
}