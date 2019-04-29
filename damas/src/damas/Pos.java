package damas;

public class Pos {
	public String pos;
	private Pos pos_sup[];
	private Pos pos_inf[];
	private boolean ocupado;
	private Peca peca;
	
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public Pos[] getPos_sup() {
		return pos_sup;
	}
	public void setPos_sup(Pos[] pos_sup) {
		this.pos_sup = pos_sup;
	}
	public Pos[] getPos_inf() {
		return pos_inf;
	}
	public void setPos_inf(Pos[] pos_inf) {
		this.pos_inf = pos_inf;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	
	
	//public Pos(String pos_sup[],String pos_inf[]){
	//	this.pos_sup[1] = post_sup[1];
	//}
}
