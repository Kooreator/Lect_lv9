package gui_소코반;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Play  extends SokobanUtill{
	
	private final int MAP = 1;
	private final int WALL = 2;
	private final int PLAYER = 3;
	private final int BOX = 4;
	private final int GOAL = 5;
	private final int GOALIN = 6; 
	
	private final int LEFT = 0;
	private final int DOWN = 10;
	private final int RIGHT = 20;
	private final int UP = 30;
	private int dir;
	
	private Point[][] gameBoard = new Point[9][8];
	private String[][] mark = new String [9][8];
	private String data = "1/1/2/2/2/2/2/1\n"
			+ "2/2/2/1/1/1/2/1\n"
			+ "2/5/3/4/1/1/2/1\n"
			+ "2/2/2/1/4/5/2/1\n"
			+ "2/5/2/2/4/1/2/1\n"
			+ "2/1/2/1/5/1/2/2\n"
			+ "2/4/1/6/4/4/5/2\n"
			+ "2/1/1/1/5/1/1/2\n"
			+ "2/2/2/2/2/2/2/2";
	
	public Play() {
		setLayout(null);
		setBounds(0, 0, 800, 900);
		
		setMap();
		setFocusable(true);
		addKeyListener(this);
	}
	private void setMap() {
		setMark();
		int x = 0; int y = 0;
		
		for(int i=0; i<this.gameBoard.length; i++) {
			for(int j=0; j<this.gameBoard[i].length; j++) {
				Point p = new Point(Integer.valueOf(this.mark[i][j]),x,y,99,99);
				this.gameBoard[i][j] = p;
				x += 100;
			}
			x = 0;
			y += 100;
		}
	}
	private void setMark() {
		
		String[] temp = this.data.split("\n");
		for(int i=0; i<temp.length; i++) {
			String[] temp2 = temp[i].split("/");
			for(int j=0; j<temp2.length; j++) {
				this.mark[i][j] = temp2[j];
			}
		}
	}
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		
		for(int i=0; i<this.gameBoard.length; i++) {
			for(int j=0; j<this.gameBoard[i].length; j++) {
				Point p = this.gameBoard[i][j];
				g.drawImage(p.getIcon().getImage(),p.getX(),p.getY(),null);
			}
		}
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_LEFT) {
			move(0,-1,0,-2);
		}else if(e.getKeyCode() == e.VK_DOWN) {
			move(1,0,2,0);
		}else if(e.getKeyCode() == e.VK_RIGHT) {
			move(0,1,0,2);
		}else if(e.getKeyCode() == e.VK_UP) {
			move(-1,0,-2,0);
		}
	}

	private void move(int x, int y, int xx, int yy) {
		System.out.println("move");
		int check = -1;
		for (int i = 2; i < this.gameBoard.length - 2; i++) {
			for (int j = 2; j < this.gameBoard[i].length - 2; j++) {

				if (this.gameBoard[i][j].getNum() == 3 && check == -1) {
					System.out.println("asdf");
					check = 1;

					if (this.gameBoard[i+x][j+y].getNum() != 2) {
						if (this.gameBoard[i + x][j + y].getNum() == 1 || this.gameBoard[i + x][j + y].getNum() == 5) {
							

							Point temp = this.gameBoard[i + x][j + y];
							System.out.println(this.gameBoard[i + y][i + y].getNum());
							System.out.println(this.gameBoard[i][j].getNum());
							this.gameBoard[i + x][j + y] = this.gameBoard[i][j];
							this.gameBoard[i][j] = temp;
							System.out.println(this.gameBoard[i + y][i + y].getNum());
							System.out.println(this.gameBoard[i][j].getNum());
						} else if (this.gameBoard[i + x][j + y].getNum() == 4
								|| this.gameBoard[i + x][j + y].getNum() == 6
										&& this.gameBoard[i + xx][j + yy].getNum() == 1
								|| this.gameBoard[i + xx][j + yy].getNum() == 5 
								&& this.gameBoard[i + xx][j + yy].getNum() != 2) {

							System.out.println(1234);
							int temp1 = this.gameBoard[i][j].getNum();
							int temp2 = this.gameBoard[i + x][j + y].getNum();
							int temp3 = this.gameBoard[i + xx][j + yy].getNum();
							this.gameBoard[i + x][j + y].setNum(temp1); 
							this.gameBoard[i + xx][j + yy].setNum(temp2);
							this.gameBoard[i][j].setNum(temp1);
						}
					}
				}
			}
		}
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
	}
	

}
