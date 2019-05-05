package damas;

public class Peca {
	private String pos_atual;
	private String cor;
	private boolean viva = true;
	private boolean dama = false;
	
	
	public boolean isViva() {
		return viva;
	}
	public void setViva(boolean viva) {
		this.viva = viva;
	}
	public boolean isDama() {
		return dama;
	}
	public void setDama(boolean dama) {
		this.dama = dama;
	}
	public String getPos_atual() {
		return pos_atual;
	}
	public void setPos_atual(String pos_atual) {
		this.pos_atual = pos_atual;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
}
