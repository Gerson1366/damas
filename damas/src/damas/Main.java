package damas;

public class Main {

	public static void main(String[] args) {
		Pos b2;
		// TODO Auto-generated method stub
		String pos_sup[];
		String pos_inf[];
		Pos[][] posicoes = new Pos[8][8];
		for(int x=0;x<8;x++) {
			for(int i=0;i<8;i++) {
				String posx = Integer.toString(x+1);
				String posi = "a";
				if(i==0) {
					posi="a";
				}
				if(i==1) {
					posi="b";
				}
				if(i==2) {
					posi="c";
				}
				if(i==3) {
					posi="d";
				}
				if(i==4) {
					posi="e";
				}
				if(i==5) {
					posi="f";
				}
				if(i==6) {
					posi="g";
				}
				if(i==7) {
					posi="h";
				}
				//pos_sup[0] = "a3";
				//pos_sup[1] = "c3";
				//pos_inf[0] = "a1";
				//pos_inf[1] = "c1";
				Pos pos = new Pos();
				pos.pos = posi+posx;
				posicoes[i][x]=pos;
			}
		}
		System.out.println("Posição: "+posicoes[2][5].pos);
	}

}
