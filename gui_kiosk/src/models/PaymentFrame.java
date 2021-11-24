package models;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import manager.MainFrame;
import manager.MenuImage;
import manager.Utill;

class PaymentPanel extends Utill{
	
	MenuImage[] mi = new MenuImage[4];
	
	JLabel mention = null;
	JLabel stayLabel = null;
	JLabel hereLabel = null;
	JLabel cashLabel = null;
	JLabel cardLabel = null;
	
	JButton stay = null;
	JButton here = null;
	JButton cash = null;
	JButton card = null;
	
	JButton cancel = null;
	JButton pay = null;
	
	public PaymentPanel() {
		setLayout(null);
		setBounds(0, 0, 600, 700);
		
		setLabel();
		setImage();
		setButton();
		
	}

	private void setLabel() {
		this.mention = new JLabel(MainFrame.cost+" : 드시고 가시겠습니까 ? ");
		this.mention.setBounds(50, 20, 500, 30);
		add(this.mention);
		this.stayLabel = new JLabel("먹고갈래요");
		this.stayLabel.setBounds(10, 60, 250, 50);
		add(this.stayLabel);
		this.hereLabel = new JLabel("포장할래요");
		this.hereLabel.setBounds(310, 60, 250, 50);
		add(this.hereLabel);
		this.cashLabel = new JLabel("현금결제");
		this.cashLabel.setBounds(10, 120, 250, 50);
		add(this.cashLabel);
		this.cardLabel = new JLabel("카드결제");
		this.cardLabel.setBounds(310, 120, 250, 50);
		add(this.cardLabel);
	}

	private void setImage() {
		int x = 260; int y = 60;
		String path = "images_kiosk/";
		String blank = "blank_mark.png";
		String mark = "ok_mark.png";
		
		this.mi[0] = new MenuImage(x, y, 40, 50, 0, path+blank);
		x = 560;
		this.mi[1] = new MenuImage(x, y, 40, 50, 0, path+blank);
		x = 260; y = 120;
		this.mi[2] = new MenuImage(x, y, 40, 50, 0, path+blank);
		x = 560;
		this.mi[3] = new MenuImage(x, y, 40, 50, 0, path+blank);
		
	}

	private void setButton() {
		
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
		
		if(e.getSource() == this.stay) {
			
		}else if(e.getSource() == this.here) {
			
		}
		
		if(e.getSource() == this.cash) {
			
		}else if(e.getSource() == this.card) {
			
		}
		
		if(e.getSource() == this.cancel) {
			if(MainFrame.pf != null) {
				MainFrame.pf.dispose();
			}			
		}else if(e.getSource() == this.pay) {
			JOptionPane.showMessageDialog(null, "결제완료");
			MainFrame.pf.dispose();
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
