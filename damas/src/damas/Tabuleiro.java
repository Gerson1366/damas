package damas;

import java.util.ArrayList;
import java.util.Scanner;
public class Tabuleiro {
	
	Pos b2;
	String pos_sup[];
	String pos_inf[];
	Pos[][] posicoes = new Pos[8][8];
	int brancas = 12;
	int pretas = 12;
	String posicaoPeca;
	String posicaoMovimento;
	String turno="b";
	String oponente="p";
	private Pos pecaMatar=null;
	ArrayList<Peca> pecasPretas = new ArrayList<Peca>();
	
	public Tabuleiro() {
		for(int x=0;x<8;x++) {
			for(int i=0;i<8;i++) {
				String posx = Integer.toString(x+1);
				Pos pos = new Pos();
				//pos_sup[0] = "a3";
				//pos_sup[1] = "c3";
				//pos_inf[0] = "a1";
				//pos_inf[1] = "c1";
				if(i==0) {
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
		System.out.println("  1 2 3 4 5 6 7 8 x");
		for (i=0; i < 8; i++) {
			System.out.print(converteValor(i) + " ");
			for (j=0; j < 8; j++) {
				if(posicoes[i][j].isOcupado()==false) {
					System.out.print("  ");
				}else{
					if(posicoes[i][j].getPeca().isDama()) {
						System.out.print(posicoes[i][j].getPeca().getCor().toUpperCase() + " ");
					}else {
						System.out.print(posicoes[i][j].getPeca().getCor() + " ");
					}
				}
			}
			System.out.println("y");
		}
	}
	
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
	
	public static boolean isInteger(String str) { 
	  try {  
	    Integer.parseInt(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
	
	public void moverPeca() {
		Scanner scanner = new Scanner(System.in);
		if(this.turno=="b") {
			System.out.println("Qual peça branca deseja mover?(yx)");
		}else if(this.turno=="p") {
			System.out.println("Qual peça preta deseja mover?(yx)");
		}
		posicaoPeca = scanner.nextLine();
		if(posicaoPeca.length()>1) {
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
	
	public void moverDama(int i,int j,int y,int x) {
		String oponente;
		if(this.buscarCaminho(i,j,y,x)) {
			if(this.pecaMatar!=null) {
				this.pecaMatar.getPeca().setViva(false);
				this.pecaMatar.setPeca(null);
				this.pecaMatar.setOcupado(false);
				this.pecaMatar = null;
				if(this.oponente=="p") {
					pretas--;
				}else {
					brancas--;
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
	
	public void moverPreta(int i,int j,int y,int x) {
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
									}
								}
							}else if(x==(j+1)) {
							//Testa se movimento foi à direita
								if(j+2<=7) {
									//Testa se posição acima da peça é ocupada
									if(this.posicoes[i+2][j+2].isOcupado()==false) {
										this.posicoes[i+2][j+2].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i+2][j+2].setOcupado(true);
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
									}
								}
							}
						}
					}
				}else {
					//Move a peça para a posição
					System.out.println("Movimento "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos());
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
				}
			}
		}
	}
	
	public void moverBranca(int i,int j,int y,int x) {
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
									}
								}
							}else if(x==(j+1)) {
							//Testa se movimento foi à direita
								if(j+2<=7) {
									//Testa se posição acima da peça é ocupada
									if(this.posicoes[i-2][j+2].isOcupado()==false) {
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
									}
								}
							}
						}
					}
				}else {
					//Move a peça para a posição
					System.out.println("Movimento "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos());
					this.posicoes[y][x].setPeca(this.posicoes[i][j].getPeca());
					this.posicoes[y][x].setOcupado(true);
					if(y==0) {
						this.posicoes[y][x].getPeca().setDama(true);
					}
					this.posicoes[i][j].setPeca(null);
					this.posicoes[i][j].setOcupado(false);
					this.turno="p";
					this.oponente="b";
				}
			}
		}
	}
}