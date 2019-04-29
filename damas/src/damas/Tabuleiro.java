package damas;

public class Tabuleiro {
	
	Pos b2;
	String pos_sup[];
	String pos_inf[];
	Pos[][] posicoes = new Pos[8][8];
	
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
}