package manager;

import java.util.Vector;

import javax.swing.JFrame;

import models.CoffeePanel;
import models.MainPanel;
import models.PaymentFrame;
import models.SubVeberagePanel;

public class MainFrame extends JFrame{
	
	public static MainFrame mf = null;
	public static PaymentFrame pf = null;
	
	
	public static Vector<Vector<String>> order = new Vector<>();
	public static Vector<String> header = new Vector<>();
	public static Vector<String> colName = new Vector<>();
	
	public static int panel = 1;
	public static int total = 0;
	public static int cost = 0;
	
	public MainFrame() {
		setLayout(null);
		setBounds(100, 100, 700, 820);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setPanel();
		
		setVisible(true);
		revalidate();
	}
	
	public void setPanel() {
		
		if(this.panel == 1) {
			this.getContentPane().add(new MainPanel());
		}else if(this.panel == 2){
			this.getContentPane().add(new SubVeberagePanel());			
		}
		
	}

	public static void main(String[] args) {
		MainFrame.mf = new MainFrame();
	}
}
