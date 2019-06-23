package damas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Peca extends JPanel {
	private String pos_atual;
	private String cor;
	private boolean viva = true;
	private boolean dama = false;
	private int pos_x;
	private int pos_y;
	
	
	
	public int getPos_x() {
		return pos_x;
	}
	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}
	public int getPos_y() {
		return pos_y;
	}
	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}
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
