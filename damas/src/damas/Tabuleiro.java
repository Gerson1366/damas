package damas;

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
						pos.setOcupado(true);
						pos.setPeca(peca);
					}else {
						pos.setOcupado(false);
					}
				}else if(i==1) {
					if(x % 2 != 0) {
						Peca peca = new Peca();
						peca.setCor("p");
						pos.setOcupado(true);
						pos.setPeca(peca);
					}else {
						pos.setOcupado(false);
					}
				}else if(i==2) {
					if(x % 2 == 0) {
						Peca peca = new Peca();
						peca.setCor("p");
						pos.setOcupado(true);
						pos.setPeca(peca);
					}else {
						pos.setOcupado(false);
					}
				}
				else if(i==5) {
					if(x % 2 != 0) {
						Peca peca = new Peca();
						peca.setCor("b");
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
						pos.setOcupado(true);
						pos.setPeca(peca);
					}else {
						pos.setOcupado(false);
					}
				}else if(i==7) {
					if(x % 2 != 0) {
						Peca peca = new Peca();
						peca.setCor("b");
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
					System.out.print(posicoes[i][j].getPeca().getCor() + " ");
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
	
	public void moverPeca() {
		Scanner scanner = new Scanner(System.in);
		if(this.turno=="b") {
			System.out.println("Qual pe�a branca deseja mover?(yx)");
		}else if(this.turno=="p") {
			System.out.println("Qual pe�a preta deseja mover?(yx)");
		}
		posicaoPeca = scanner.nextLine();
		//Pega valor da String e separa primeiro valor do segundo, convertendo cada valor para int
		int i = this.recuperaValor(posicaoPeca.charAt(0));
		int j = Integer.parseInt(String.valueOf(posicaoPeca.charAt(1)))-1;
		//Testa se valor est� dentro do tabuleiro
		if(i>=0 && i<=7) {
			if(j>=0 && j<=7) {
				//Testa se existe pe�a na posi��o de pe�a que vai mover
				if(this.posicoes[i][j].isOcupado()==true) {
					//Testa se a pe�a ocupadando o espa�o � a pe�a do jogador
					if(this.posicoes[i][j].getPeca().getCor()==this.turno) {
						System.out.println("Deseja mover a pe�a para qual posi��o?(yx)");
						//Pega o valor do tabuleiro para onde vai mover a pe�a
						posicaoMovimento = scanner.nextLine();
						//Converte valores para int
						int y = this.recuperaValor(posicaoMovimento.charAt(0));
						int x = Integer.parseInt(String.valueOf(posicaoMovimento.charAt(1)))-1;
						//Testa se posi��o para mover a pe�a est� dentro do tabuleiro
						if(x>=0 && x<=7) {
							if(y>=0 && y<=7) {
								//Testa se posi��o para mover a pe�a � uma linha acima da pe�a atual
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
	
	public void moverPreta(int i,int j,int y,int x) {
		if(y==(i+1)) {
			//Testa se posi��o para mover a pe�a � uma linha � esquerda ou direita da posi��o atual
			if((x==(j-1)) || (x==(j+1))) {
				//Testa se n�o h� outra pe�a no lugar
				if(this.posicoes[y][x].isOcupado()==true) {
					//Testa se a pe�a ocupando o espa�o � oponente
					if(this.posicoes[y][x].getPeca().getCor()=="b") {
						//Testa se posi��o acima da pe�a � dentro do tabuleiro
						if(y+1<=7) {
							//Testa se movimento foi � esquerda
							if(x==(j-1)) {
								//Testa se movimento est� dentro do tabuleiro
								if(j-2>=0) {
									//Testa se posi��o acima da pe�a � ocupada
									if(this.posicoes[i+2][j-2].isOcupado()==false) {
										this.posicoes[i+2][j-2].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i+2][j-2].setOcupado(true);
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
							//Testa se movimento foi � direita
								if(j+2<=7) {
									//Testa se posi��o acima da pe�a � ocupada
									if(this.posicoes[i+2][j+2].isOcupado()==false) {
										this.posicoes[i+2][j+2].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i+2][j+2].setOcupado(true);
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
					//Move a pe�a para a posi��o
					System.out.println("Movimento "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos());
					this.posicoes[y][x].setPeca(this.posicoes[i][j].getPeca());
					this.posicoes[y][x].setOcupado(true);
					this.posicoes[i][j].setPeca(null);
					this.posicoes[i][j].setOcupado(false);
					this.turno="b";
					this.oponente="p";
				}
			}
		}
	}
	
	public void moverBranca(int i,int j,int y,int x) {
		if(y==(i-1)) {
			//Testa se posi��o para mover a pe�a � uma linha � esquerda ou direita da posi��o atual
			if((x==(j-1)) || (x==(j+1))) {
				//Testa se n�o h� outra pe�a no lugar
				if(this.posicoes[y][x].isOcupado()==true) {
					//Testa se a pe�a ocupando o espa�o � oponente
					if(this.posicoes[y][x].getPeca().getCor()=="p") {
						//Testa se posi��o acima da pe�a � dentro do tabuleiro
						if(y-1>=0) {
							//Testa se movimento foi � esquerda
							if(x==(j-1)) {
								//Testa se movimento est� dentro do tabuleiro
								if(j-2>=0) {
									//Testa se posi��o acima da pe�a � ocupada
									if(this.posicoes[i-1][j-1].isOcupado()==false) {
										this.posicoes[i][j].setOcupado(false);
										this.posicoes[i][j].setPeca(null);
										this.posicoes[i-1][j-1].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i-1][j-1].setOcupado(true);
										this.pretas--;
										this.turno="p";
										this.oponente="b";
									}
								}
							}else if(x==(j+1)) {
							//Testa se movimento foi � direita
								if(j+2<=7) {
									//Testa se posi��o acima da pe�a � ocupada
									if(this.posicoes[i-1][j+1].isOcupado()==false) {
										this.posicoes[i][j].setOcupado(false);
										this.posicoes[i][j].setPeca(null);
										this.posicoes[i-1][j+1].setPeca(this.posicoes[i][j].getPeca());
										this.posicoes[i-1][j+1].setOcupado(true);
										this.pretas--;
										this.turno="p";
										this.oponente="b";
									}
								}
							}
						}
					}
				}else {
					//Move a pe�a para a posi��o
					System.out.println("Movimento "+this.posicoes[i][j].getPos()+" para "+this.posicoes[y][x].getPos());
					this.posicoes[y][x].setPeca(this.posicoes[i][j].getPeca());
					this.posicoes[y][x].setOcupado(true);
					this.posicoes[i][j].setPeca(null);
					this.posicoes[i][j].setOcupado(false);
					this.turno="p";
					this.oponente="b";
				}
			}
		}
	}
}