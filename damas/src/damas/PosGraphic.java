package damas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class PosGraphic extends JComponent{
	
	String color="White";
	private Pos pos=null;

	public final String getColor() {
		return color;
	}

	public final void setColor(String color) {
		this.color = color;
	}

	public final Pos getPos() {
		return pos;
	}

	public final void setPos(Pos pos) {
		this.pos = pos;
	}

	public PosGraphic() {
		setPreferredSize(new Dimension(60, 60));
		this.addMouseListener(new clicarPos());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(color=="White") {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
		    g.fillRect(0,0,60,60);
		    g.setColor(Color.BLACK);
		    g.drawRect(0,0,60,60);
		    repaint();
		}else {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
		    g.fillRect(0,0,60,60);
		    g.setColor(Color.BLACK);
		    g.drawRect(0,0,60,60);
		    repaint();
		}
    }  
	
	class clicarPos implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(pos.getPos());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
}
