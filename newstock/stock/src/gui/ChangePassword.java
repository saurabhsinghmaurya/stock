package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import beans.Operator;
import beans.User;

import dbdata.OperatorLogin;
import dbdata.UpdateOperator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangePassword extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the panel.
	 */
	public ChangePassword() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Password");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 60, 142, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 110, 142, 23);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Retype Password");
		lblNewLabel_2.setBounds(52, 160, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(256, 60, 246, 30);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(256, 110, 246, 30);
		add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getExtendedKeyCode()==KeyEvent.VK_ENTER)
				{
					doAction();
				}
			}
		});
		
		passwordField_2.setBounds(256, 160, 246, 30);
		add(passwordField_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doAction();
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(256, 210, 246, 30);
		add(btnNewButton);
	
		

	}
	public void doAction() {
		try{
		 @SuppressWarnings("deprecation")
		String old=passwordField.getText();
		 @SuppressWarnings("deprecation")
		String newPass=passwordField_1.getText();
		
		@SuppressWarnings("deprecation")
		String rePass=passwordField_2.getText();
		 if(newPass.equalsIgnoreCase(rePass)){
			 OperatorLogin login=new OperatorLogin();
			 Operator operator=new Operator(1, "", User.getEmail(), old	,User.getPost());
			 if(login.getLogin(operator)){
				UpdateOperator operator2=new UpdateOperator();
				operator2.updatePassword(User.getEmail(), old, newPass);
				 JOptionPane.showMessageDialog(null, " Password changed successfully.");
				 passwordField.setText("");
				 passwordField_1.setText("");
				 passwordField_2.setText("");
			 }else {
				 JOptionPane.showMessageDialog(null, "Old Password is wrong.");
			}
			 
		 }
		 else {
			JOptionPane.showMessageDialog(null, "New Password and Retype Password should be same");
		}
	}catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, e.getMessage()+"\n"+e.getClass());
	}
	}
}
