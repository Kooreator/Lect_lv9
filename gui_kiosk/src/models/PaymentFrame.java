package models;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import manager.MainFrame;
import manager.MenuImage;
import manager.Utill;

class PaymentPanel extends Utill{
	
	MenuImage[] mi = new MenuImage[4];
	MenuImage[] cb = new MenuImage[4];
	
	boolean stayCheck;
	boolean hereCheck;
	boolean cashCheck;
	boolean cardCheck;
	
	JButton stay = null;
	JButton here = null;
	JButton cash = null;
	JButton card = null;
	
	JButton cancel = null;
	JButton pay = null;
	
	public PaymentPanel() {
		setLayout(null);
		setBounds(0, 0, 600, 700);
		
		setImage();
		setButton();
		
	}

	

	private void setImage() {
		int x = 100;
		int y = 100;
		String path = "images_kiosk/";
		String stay = "1stay.png";
		String here = "2here.png";
		String cash = "3cash.png";
		String card = "4card.png";
		String mark = "ok_mark.png";

		this.mi[0] = new MenuImage(x, y, 190, 75, 0, path + stay);
		x = 310;
		this.mi[1] = new MenuImage(x, y, 190, 75, 0, path + here);
		x = 100;
		y = 260;
		this.mi[2] = new MenuImage(x, y, 190, 75, 0, path + cash);
		x = 310;
		this.mi[3] = new MenuImage(x, y, 190, 75, 0, path + card);



	}

	private void setButton() {
		
		System.out.println(this.mi[0].getNum());
		this.stay = new JButton("",this.mi[0].getIcon());
		this.stay.setBounds(this.mi[0].getX(), this.mi[0].getY(), this.mi[0].getW(), this.mi[0].getH());
		this.stay.addActionListener(this);
		add(this.stay);
		
		this.here = new JButton("",this.mi[1].getIcon());
		this.here.setBounds(this.mi[1].getX(), this.mi[1].getY(), this.mi[1].getW(), this.mi[1].getH());
		this.here.addActionListener(this);
		add(this.here);
		
		this.cash = new JButton("",this.mi[2].getIcon());
		this.cash.setBounds(this.mi[2].getX(), this.mi[2].getY(), this.mi[2].getW(), this.mi[2].getH());
		this.cash.addActionListener(this);
		add(this.cash);
		
		this.card = new JButton("",this.mi[3].getIcon());
		this.card.setBounds(this.mi[3].getX(), this.mi[3].getY(), this.mi[3].getW(), this.mi[3].getH());
		this.card.addActionListener(this);
		add(this.card);
		
		this.cancel = new JButton("결제 취소");
		this.cancel.setBounds(140, 500, 150,100 );
		this.cancel.addActionListener(this);
		add(cancel);
		
		this.pay = new JButton("결제하기");
		this.pay.setBounds(310, 500, 150,100 );
		this.pay.addActionListener(this);
		add(pay);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		String path = "images_kiosk/";
		String stay = "1stay.png";
		String here = "2here.png";
		String cash = "3cash.png";
		String card = "4card.png";
		String mark = "ok_mark.png";
		if(e.getSource() == this.stay) {
			System.out.println(this.stayCheck);
			this.stayCheck = !this.stayCheck;
			ImageIcon img = new ImageIcon(path+mark);
			ImageIcon im = new ImageIcon(path+stay);
			if(this.stayCheck&&!this.hereCheck) {
				this.stay.setIcon(img);				
			}else {
				this.stay.setIcon(im);
			}
		}else if(e.getSource() == this.here) {
			this.hereCheck = !this.hereCheck;
			ImageIcon img = new ImageIcon(path+mark);
			ImageIcon im = new ImageIcon(path+here);
			if(this.hereCheck&&!this.stayCheck) {
				this.here.setIcon(img);				
			}else {
				this.here.setIcon(im);
			}
		}
		
		if(e.getSource() == this.cash) {
			this.cashCheck = !this.cashCheck;
			ImageIcon img = new ImageIcon(path+mark);
			ImageIcon im = new ImageIcon(path+cash);
			if(this.cashCheck&&!this.cardCheck) {
				this.cash.setIcon(img);				
			}else {
				this.cash.setIcon(im);
			}
		}else if(e.getSource() == this.card) {
			this.cardCheck = !this.cardCheck;
			ImageIcon img = new ImageIcon(path+mark);
			ImageIcon im = new ImageIcon(path+card);
			if(this.cardCheck&&!this.cashCheck) {
				this.card.setIcon(img);				
			}else {
				this.card.setIcon(im);
			}
		}
		
		if (e.getSource() == this.cancel) {
			if (MainFrame.pf != null) {
				MainFrame.pf.dispose();
			}
		} else if (e.getSource() == this.pay) {
			if((this.stayCheck || this.hereCheck) && (this.cardCheck || this.cashCheck)) {				
				JOptionPane.showMessageDialog(null, "결제완료");
				MainFrame.pf.dispose();
				MainFrame.mf.dispose();
			}
		}
	}
}

public class PaymentFrame extends JFrame{
	
	public PaymentFrame() {
		setLayout(null);
		setBounds(100, 100, 600, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new PaymentPanel());
		
		setVisible(true);
		revalidate();
		
	}
	
	
	public static void main(String[] args) {
		
	}
}
