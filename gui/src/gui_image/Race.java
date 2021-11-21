package gui_image;

import javax.swing.JFrame;

public class Race extends JFrame{
	private Content con =new Content();
	
	public Race() {
		super("raceing");
		setLayout(null);
		setBounds(100,100 ,1000 ,600 );
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(con);
		
		setVisible(true);
		revalidate();
		
		con.run();
	}
	public static void main(String[] args) {
		Race race =new Race();
	}

}
