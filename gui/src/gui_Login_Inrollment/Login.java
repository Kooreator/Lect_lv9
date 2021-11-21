package gui_Login_Inrollment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	JLabel idLabel = new JLabel("id : ");
	JLabel pwLabel = new JLabel("pw : ");
	
	JTextField idField = new JTextField();
	JTextField pwField = new JTextField();
	
	public Login() {
		setLayout(null);
		setBounds(100, 100, 300, 300);
		
		setLabel();
		setField();
		
		
		setVisible(true);
		revalidate();
		
	}

	private void setField() {
		
		this.idField.setBounds(90, 50, 150, 50);
		this.idField.setVisible(true);
		add(this.idField);
		
		this.pwField.setBounds(90, 110, 150, 50);
		this.pwField.setVisible(true);
		add(this.pwField);
	}
	
	private void setLabel() {
		
		this.idLabel.setBounds(30, 50, 60, 50);
		this.idLabel.setVisible(true);
		add(this.idLabel);
		
		this.pwLabel.setBounds(30, 110, 60, 50);
		this.pwLabel.setVisible(true);
		add(this.pwLabel);
		
	}
}
