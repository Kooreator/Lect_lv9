package gui_Login_Inrollment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Inrollment extends JFrame{
	
	JLabel idLabel = new JLabel();
	JLabel pwLabel = new JLabel();
	JLabel nameLabel = new JLabel();
	
	JTextField idField = new JTextField();
	JTextField pwField = new JTextField();
	JTextField nameField = new JTextField();
	
	public Inrollment() {
		setLayout(null);
		setBounds(150,150,300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLabel();
		setJTextField();
		
		setVisible(true);
		revalidate();
		
	}
	
	private void setLabel() {
		this.idLabel.setText("Id : ");
		this.idLabel.setBounds(30,50,60,50);
		this.idLabel.setVisible(true);
		add(this.idLabel);
		
		this.pwLabel.setText("Pw : ");
		this.pwLabel.setBounds(30,110,60,50);
		this.pwLabel.setVisible(true);
		add(this.pwLabel);
		
		this.nameLabel.setText("Name : ");
		this.nameLabel.setBounds(30,170,60,50);
		this.nameLabel.setVisible(true);
		add(this.nameLabel);
	}
	
	private void setJTextField() {
		this.idField.setBounds(90, 50, 150, 50);
		this.idField.setVisible(true);
		this.idField.setFocusable(true);
		
		add(this.idField);
		
		this.pwField.setBounds(90,110,150,50);
		this.pwField.setVisible(true);
		this.pwField.setFocusable(true);
		
		add(this.pwField);
		
		this.nameField.setBounds(90,170,150,50);
		this.nameField.setVisible(true);
		this.nameField.setFocusable(true);
		
		add(this.nameField);
	}

}
