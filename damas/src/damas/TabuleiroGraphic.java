package damas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TabuleiroGraphic extends JPanel{
	
	Tabuleiro tab;
	int x_ini,y_ini,x_fim,y_fim;
	boolean cpu=false;
	String jogadores=null;
    
    public TabuleiroGraphic(){
    	tab = new Tabuleiro();
    	this.addMouseListener(new clicarTab());
    	//Pede n�mero de jogadores:
    	do {
    		jogadores = JOptionPane.showInputDialog("Numero de Jogadores?");
    	}while(!jogadores.equals("1") && !jogadores.equals("2"));
    	if(jogadores.equals("1")) {
    		this.cpu=true;
    	}
    	repaint();
    }
	
	public Dimension getPreferredSize() {
        return new Dimension(480,480);
    }

    public void paintComponent(Graphics g) {
	    super.paintComponent(g); 
	    int posx = 0;
	    int posy = 0;
	    for(int x=0;x<8;x++) {
			for(int i=0;i<8;i++) {
					if(i==0) {
						if(x % 2 == 0) {
							g.setColor(Color.BLUE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.BLUE);
						    g.fillRect(posx,posy,60,60);
						    if(tab.getPosicoes()[i][x].isOcupado()) {
						    	if(tab.getPosicoes()[i][x].getPeca().getCor()=="b") {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.YELLOW);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
									    	g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.WHITE);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}else {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
								    		g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.CYAN);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.BLACK);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}
							}
						}else {
							g.setColor(Color.WHITE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.WHITE);
						    g.fillRect(posx,posy,60,60);
						}
					}else if(i==1) {
						if(x % 2 != 0) {
							g.setColor(Color.BLUE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.BLUE);
						    g.fillRect(posx,posy,60,60);
						    if(tab.getPosicoes()[i][x].isOcupado()) {
						    	if(tab.getPosicoes()[i][x].getPeca().getCor()=="b") {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.YELLOW);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
									    	g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.WHITE);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}else {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
								    		g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.CYAN);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.BLACK);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}
							}
	  					}else {
	  						g.setColor(Color.WHITE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.WHITE);
						    g.fillRect(posx,posy,60,60);
	  					}
					}else if(i==2) {
	  					if(x % 2 == 0) {
	  						g.setColor(Color.BLUE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.BLUE);
						    g.fillRect(posx,posy,60,60);
						    if(tab.getPosicoes()[i][x].isOcupado()) {
						    	if(tab.getPosicoes()[i][x].getPeca().getCor()=="b") {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.YELLOW);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
									    	g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.WHITE);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}else {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
								    		g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.CYAN);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.BLACK);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}
							}
	  					}else {
	  						g.setColor(Color.WHITE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.WHITE);
						    g.fillRect(posx,posy,60,60);
	  					}
	  				}else if(i==3) {
	  					if(x % 2 != 0) {
	  						g.setColor(Color.BLUE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.BLUE);
						    g.fillRect(posx,posy,60,60);
						    if(tab.getPosicoes()[i][x].isOcupado()) {
						    	if(tab.getPosicoes()[i][x].getPeca().getCor()=="b") {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.YELLOW);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
									    	g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.WHITE);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}else {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
								    		g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.CYAN);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.BLACK);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}
							}
	  					}else {
	  						g.setColor(Color.WHITE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.WHITE);
						    g.fillRect(posx,posy,60,60);
	  					}
	  				}else if(i==4) {
	  					if(x % 2 == 0) {
	  						g.setColor(Color.BLUE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.BLUE);
						    g.fillRect(posx,posy,60,60);
						    if(tab.getPosicoes()[i][x].isOcupado()) {
						    	if(tab.getPosicoes()[i][x].getPeca().getCor()=="b") {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.YELLOW);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
									    	g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.WHITE);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}else {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
								    		g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.CYAN);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.BLACK);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}
							}
	  					}else {
	  						g.setColor(Color.WHITE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.WHITE);
						    g.fillRect(posx,posy,60,60);
	  					}
	  				}
	  				else if(i==5) {
	  					if(x % 2 != 0) {
	  						g.setColor(Color.BLUE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.BLUE);
						    g.fillRect(posx,posy,60,60);
						    if(tab.getPosicoes()[i][x].isOcupado()) {
						    	if(tab.getPosicoes()[i][x].getPeca().getCor()=="b") {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.YELLOW);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
									    	g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.WHITE);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}else {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
								    		g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.CYAN);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.BLACK);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}
							}
	  					}else {
	  						g.setColor(Color.WHITE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.WHITE);
						    g.fillRect(posx,posy,60,60);
	  					}
	  				}
	  				else if(i==6) {
	  					if(x % 2 == 0) {
	  						g.setColor(Color.BLUE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.BLUE);
						    g.fillRect(posx,posy,60,60);
						    if(tab.getPosicoes()[i][x].isOcupado()) {
						    	if(tab.getPosicoes()[i][x].getPeca().getCor()=="b") {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.YELLOW);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
									    	g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.WHITE);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}else {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
								    		g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.CYAN);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.BLACK);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}
							}
	  					}else {
	  						g.setColor(Color.WHITE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.WHITE);
						    g.fillRect(posx,posy,60,60);
	  					}
	  				}else if(i==7) {
	  					if(x % 2 != 0) {
	  						g.setColor(Color.BLUE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.BLUE);
						    g.fillRect(posx,posy,60,60);
						    if(tab.getPosicoes()[i][x].isOcupado()) {
						    	if(tab.getPosicoes()[i][x].getPeca().getCor()=="b") {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.YELLOW);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
									    	g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.WHITE);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}else {
						    		if(tab.getPosicoes()[i][x].getPeca().equals(tab.getPecaSelect())) {
						    			g.setColor(Color.DARK_GRAY);
										g.drawOval(posx+5, posy+5, 50,50);
										g.setColor(Color.GREEN);
										g.fillOval(posx+5, posy+5, 50,50);
						    		}else {
						    			if(tab.getPosicoes()[i][x].getPeca().isDama()) {
								    		g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.CYAN);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}else {
						    				g.setColor(Color.DARK_GRAY);
											g.drawOval(posx+5, posy+5, 50,50);
											g.setColor(Color.BLACK);
											g.fillOval(posx+5, posy+5, 50,50);
						    			}
						    		}
						    	}
							}
	  					}else {
	  						g.setColor(Color.WHITE);
							g.drawRect(posx,posy,60,60);
						    g.setColor(Color.WHITE);
						    g.fillRect(posx,posy,60,60);
	  					}
	  				}
					posy = posy + 60;
				}
			posx=posx+60;
			posy=0;
		}
	}
    
    class clicarTab implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(tab.getPecaSelect()==null) {
				int x = Math.round(arg0.getX()/60);
				int y = Math.round(arg0.getY()/60);
				if(tab.getPosicoes()[y][x].isOcupado()) {
					if(tab.getPosicoes()[y][x].getPeca().getCor()==tab.getTurno()) {
						tab.setPecaSelect(tab.getPosicoes()[y][x].getPeca());
						x_ini=x;
						y_ini=y;
					}
				}
			}else {
				int x = Math.round(arg0.getX()/60);
				int y = Math.round(arg0.getY()/60);
				x_fim=x;
				y_fim=y;
				if(tab.getTurno()=="b") {
					if(tab.getPecaSelect().isDama()) {
						if(tab.moverDama(y_ini,x_ini,y_fim,x_fim)) {
							tab.setPecaSelect(null);
							if(cpu==true) {
								tab.cpuMove();
							}else {
								tab.setTurno("p");
							}
						}else {
							tab.setPecaSelect(null);
						}
					}else {
						if(tab.moverBranca(y_ini, x_ini, y_fim, x_fim)){
							tab.setPecaSelect(null);
							if(cpu==true) {	
								tab.cpuMove();
							}else {
								tab.setTurno("p");
							}
						}else {
							tab.setPecaSelect(null);
						}
					}
				}else {
					if(tab.getPecaSelect().isDama()) {
						if(tab.moverDama(y_ini,x_ini,y_fim,x_fim)) {
							tab.setPecaSelect(null);
							tab.setTurno("b");
						}else {
							tab.setPecaSelect(null);
						}
					}else {
						if(tab.moverPreta(y_ini, x_ini, y_fim, x_fim)){
							tab.setPecaSelect(null);
							tab.setTurno("b");
						}else {
							tab.setPecaSelect(null);
						}
					}
				}
			}
			repaint();
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
