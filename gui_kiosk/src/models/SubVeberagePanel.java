package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import manager.MainFrame;
import manager.MenuImage;
import manager.Utill;

public class SubVeberagePanel extends Utill{
	
	
    Vector<Vector<String>> info = new Vector<>();
    
	JButton[][] menu = new JButton[4][4];
	MenuImage[][] coffee = new MenuImage[4][4];
	
	JTable table = new JTable();
	
	JButton coffeeB =new JButton();
	JButton tea = new JButton();
	JButton payment = new JButton();
	JButton reset = new JButton();
	
	JButton oTotal = new JButton();
	JButton pTotal = new JButton();
	JButton ot = new JButton();
	JButton pt = new JButton();
	
	
	public SubVeberagePanel() {
		
		setLayout(null);
		setBounds(0, 0, 700, 800);
		
		init();
		setMenuImage();
		setButton();
		setTable();
		
	}
	
	private void init() {
		Vector<String> menuInfo1 = new Vector<>();
 		menuInfo1.add("허니레몬티");
		menuInfo1.add("3500");
		this.info.add(menuInfo1);
		Vector<String> menuInfo2 = new Vector<>();
		menuInfo2.add("허니유자티");
		menuInfo2.add("3500");
		this.info.add(menuInfo2);
		Vector<String> menuInfo3 = new Vector<>();
		menuInfo3.add("허니자몽티");
		menuInfo3.add("3500");
		this.info.add(menuInfo3);
		Vector<String> menuInfo4 = new Vector<>();
		menuInfo4.add("얼그레이");
		menuInfo4.add("2500");
		this.info.add(menuInfo4);
		Vector<String> menuInfo5 = new Vector<>();
		menuInfo5.add("국화차");
		menuInfo5.add("3500");
		this.info.add(menuInfo5);
		Vector<String> menuInfo6 = new Vector<>();
		menuInfo6.add("민트초코티");
		menuInfo6.add("2500");
		this.info.add(menuInfo6);
		Vector<String> menuInfo7 = new Vector<>();
		menuInfo7.add("케모마일");
		menuInfo7.add("2500");
		this.info.add(menuInfo7);
		Vector<String> menuInfo8 = new Vector<>();
		menuInfo8.add("페퍼민트");
		menuInfo8.add("2500");
		this.info.add(menuInfo8);
		Vector<String> menuInfo9 = new Vector<>();
		menuInfo9.add("청포도에이드");
		menuInfo9.add("3500");
		this.info.add(menuInfo9);
		Vector<String> menuInfo10= new Vector<>();
		menuInfo10.add("보이차");
		menuInfo10.add("2500");
		this.info.add(menuInfo10);
		Vector<String> menuInfo11 = new Vector<>();
		menuInfo11.add("루이보스");
		menuInfo11.add("2500");
		this.info.add(menuInfo11);
		Vector<String> menuInfo12 = new Vector<>();
		menuInfo12.add("로즈힐");
		menuInfo12.add("2500");
		this.info.add(menuInfo12);
		Vector<String> menuInfo13 = new Vector<>();
		menuInfo13.add("히비스커스");
		menuInfo13.add("2500");
		this.info.add(menuInfo13);
		Vector<String> menuInfo14 = new Vector<>();
		menuInfo14.add("복숭아아이스티");
		menuInfo14.add("3000");
		this.info.add(menuInfo14);
		Vector<String> menuInfo15 = new Vector<>();
		menuInfo15.add("블루레몬에이드");
		menuInfo15.add("3500");
		this.info.add(menuInfo15);
		Vector<String> menuInfo16 = new Vector<>();
		menuInfo16.add("자몽에이드");
		menuInfo16.add("3500");
		this.info.add(menuInfo16);
	}

	private void setTable() {
		
		table = new JTable(MainFrame.order, MainFrame.header);
		table.setBounds(50, 480, 600,130);
		table.setBorder(new LineBorder(Color.red));
		table.setGridColor(Color.black);
		
		//add(table);
		
		JScrollPane js = new JScrollPane(table);
		js.setBounds(50, 480, 600, 130);
		js.setAutoscrolls(true);
		add(js);
		
	}
	
	private void setMenuImage() {
		
		int x = 100;
		int y = 50;
		int count = 0;
		String name = "images_kiosk/tea_sub";
		String num = "01/02/03/04/05/06/07/08/09/10/11/12/13/14/15/16";
		String[] imageNum = num.split("/");
		
		for(int i=0; i<this.coffee.length; i++) {
			for(int j=0; j<this.coffee[i].length; j++) {
				MenuImage mi = new MenuImage(x,y,120,100,count+1,name+imageNum[count]+".png");
				this.coffee[i][j] = mi;
				count ++;
				x += 125;
			}
			x = 100;
			y += 105;
		}
	}

	private void setButton() {
		int x = 100;
		int y = 30;
		for(int i=0; i<this.menu.length; i++) {
			for(int j=0; j<this.menu[i].length; j++) {
				JButton btn = new JButton("",this.coffee[i][j].getIcon());
				btn.setBounds( x, y, 120, 100);
				btn.setBackground(Color.black);
				btn.addActionListener(this);
				this.menu[i][j] = btn;
				add(this.menu[i][j]);
				x += 125;
				repaint();
			}
			x = 100;
			y += 105;
		}
		
		coffeeB.setText("커피");
		coffeeB.setBounds(270, 5, 50, 20);
		coffeeB.addActionListener(this);
		add(coffeeB);
		
		tea.setText("티&에이드");
		tea.setBounds(330, 5, 80, 20);
		tea.addActionListener(this);
		add(tea);
		
		this.oTotal.setText("주문 총 수량");
		this.oTotal.setBounds(50, 620, 190, 50);
		add(this.oTotal);
		
		this.pTotal.setText("총 액");
		this.pTotal.setBounds(50, 680, 190, 50);
		add(this.pTotal);
		
		this.ot.setText(String.valueOf(MainFrame.total));
		this.ot.setBounds(255, 620, 190, 50);
		add(this.ot);
		
		this.pt.setText(String.valueOf(MainFrame.cost));
		this.pt.setBounds(255, 680, 190, 50);
		add(this.pt);
		
		payment.setText("결제하기");
		payment.setBounds(460, 620, 190, 50);
		payment.addActionListener(this);
		add(payment);
		
		reset.setText("초기화");
		reset.setBounds(460, 680, 190, 50);
		reset.addActionListener(this);
		add(reset);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);


		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		int cnt = -1;
		for(int i=0; i<this.menu.length; i++) {
			for(int j=0; j<this.menu[i].length; j++) {
				cnt ++;
				if(e.getSource() == this.menu[i][j]) {
					
					Vector<String> order = new Vector<>();
					
					MainFrame.total++;
					MainFrame.cost += Integer.valueOf(this.info.get(cnt).get(1));
					
					int check = quantity(this.info.get(cnt).get(0));
					if(check == 0) {
						order.add(this.info.get(cnt).get(0));
						order.add(this.info.get(cnt).get(1));						
						order.add(String.valueOf(1));
						order.add(String.valueOf(this.info.get(cnt).get(1)));
						MainFrame.order.add(order);
					}else {
						int idx = getMenuIndex(this.info.get(cnt).get(0));
						MainFrame.order.get(idx).set(2,""+(Integer.valueOf(MainFrame.order.get(idx).get(2))+1));
						MainFrame.order.get(idx).set(3, ""+(Integer.valueOf(MainFrame.order.get(idx).get(2))*
								Integer.valueOf(this.info.get(cnt).get(1))));
					}
					
					
					this.ot.setText(String.valueOf(MainFrame.total));
					this.pt.setText(String.valueOf(MainFrame.cost));
					if(MainFrame.mf != null) {
						MainFrame.mf.dispose();
					}
					MainFrame.mf = new MainFrame();
				}
			}
		}
		
		
		
        if(e.getSource() == this.reset) {
			MainFrame.order = new Vector<>();
			MainFrame.total = 0;
			MainFrame.cost = 0;
			if(MainFrame.mf != null) {
				MainFrame.mf.dispose();
			}
			MainFrame.mf = new MainFrame();
		}else if(e.getSource() == this.payment) {
			if(MainFrame.cost > 0) {				
				MainFrame.pf = new PaymentFrame();
			}
		}else if(e.getSource() == this.coffeeB) {
			MainFrame.panel = 1;
			if(MainFrame.mf != null) {
				MainFrame.mf.dispose();
			}
			MainFrame.mf = new MainFrame();
		}else if(e.getSource() == this.tea) {
			MainFrame.panel = 2;
			if(MainFrame.mf != null) {
				MainFrame.mf.dispose();
			}
			MainFrame.mf = new MainFrame();
		}       
		
	}
	public int getMenuIndex(String name) {
		for(int i=0; i<MainFrame.order.size(); i++) {
			if(MainFrame.order.get(i).get(0).equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public int quantity(String name) {
		
		for(int i=0; i<MainFrame.order.size(); i++) {
			if(MainFrame.order.get(i).get(0).equals(name)) {
				return Integer.valueOf(MainFrame.order.get(i).get(2));
			}
		}
		return 0;
	}

}
