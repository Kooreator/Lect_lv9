package manager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import models.MenuImage;

public class MainPanel extends Utill{
	
	Vector<Vector<String>> order = new Vector<>();
	Vector<String> colName = new Vector<>();
	
	MenuImage[][] coffee = new MenuImage[4][4];
	JTable table = new JTable();
	
	public MainPanel() {
		setLayout(null);
		setBounds(0, 0, 700, 800);
		
		setButton();
		setMenuImage();
		setTable();
		
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

	private void setButton() {
		
		JButton coffee =new JButton();
		JButton tea = new JButton();
		
		coffee.setText("커피");
		coffee.setBounds(270, 10, 50, 20);
		coffee.addActionListener(this);
		add(coffee);
		
		tea.setText("티&에이드");
		tea.setBounds(330, 10, 80, 20);
		tea.addActionListener(this);
		add(tea);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
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
