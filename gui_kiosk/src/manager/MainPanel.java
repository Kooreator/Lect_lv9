package manager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import models.MenuImage;

public class MainPanel extends Utill{
	
	Vector<Vector<String>> order = new Vector<>();
	Vector<String> colName = new Vector<>();
	
	MenuImage[][] coffee = new MenuImage[4][4];
	JTable table = new JTable();
	
	JButton coffeeB =new JButton();
	JButton tea = new JButton();
	JButton payment = new JButton();
	JButton reset = new JButton();
	
	JLabel oTotal = new JLabel("주문 총 수량");
	JLabel pTotal = new JLabel("주문 총액");
	JLabel ot = new JLabel();
	JLabel pt = new JLabel();
	
	
	public MainPanel() {
		setLayout(null);
		setBounds(0, 0, 700, 800);
		
		setButton();
		setMenuImage();
		setTable();
		setLabel();
		
	}


	private void setTable() {
		this.colName.add("Name");
		this.colName.add("Price");
		this.colName.add("Quantity");
		this.colName.add("Total Price");
		
		table = new JTable(order, colName);
		table.setBounds(50, 570, 600,130);
		table.setBorder(new LineBorder(Color.red));
		table.setGridColor(Color.black);
		
		add(table);
		
		
	}

	private void setMenuImage() {
		int x = 100;
		int y = 50;
		int count = 0;
		String name = "images_kiosk/coffee_sub";
		String num = "01/02/03/04/05/06/07/08/09/10/11/12/13/14/15/16";
		String[] imageNum = num.split("/");
		
		for(int i=0; i<this.coffee.length; i++) {
			for(int j=0; j<this.coffee[i].length; j++) {
				MenuImage mi = new MenuImage(x,y,120,120,count+1,
						name+imageNum[count]+".png");
				this.coffee[i][j] = mi;
				count ++;
				x += 125;
			}
			x = 100;
			y += 125;//550
		}
		
	}
	private void setLabel() {
		
		this.oTotal.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		this.pTotal.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		this.ot.setText(getTotal());
		
		
	}

	private String getTotal() {
		int total = 0;
		for(int i=0; i<this.order.size(); i++) {
			for(int j=0; j<this.order.get(i).size(); j++) {
				
			}
		}
		return null;
	}


	private void setButton() {
		
		coffeeB.setText("커피");
		coffeeB.setBounds(270, 10, 50, 20);
		coffeeB.addActionListener(this);
		add(coffeeB);
		
		tea.setText("티&에이드");
		tea.setBounds(330, 10, 80, 20);
		tea.addActionListener(this);
		add(tea);
		
		payment.setText("결제하기");
		payment.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		payment.addActionListener(this);
		add(payment);
		
		reset.setText("초기화");
		reset.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		reset.addActionListener(this);
		add(reset);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if(e.getSource() == this.reset) {
			
		}else if(e.getSource() == this.payment) {
			
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < this.coffee.length; i++) {
			for (int j = 0; j < this.coffee[i].length; j++) {
				MenuImage mi = this.coffee[i][j];
				g.drawImage(mi.getIcon().getImage(),mi.getX(),mi.getY(),null);
			}
		}
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
	}

}
