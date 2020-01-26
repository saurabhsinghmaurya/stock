package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import beans.Operator;
import beans.User;

import javax.swing.JPasswordField;

import dbdata.OperatorLogin;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */


	private JComboBox<String> comboBox;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JButton button;

	/**
	 * Create the dialog.
	 */
	public Login() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/fs.jpg")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(300, 50, 700, 300);
		setBackground(new Color(240, 240, 240));
		getContentPane().setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("Login as");
		lblNewLabel_2.setBounds(52, 60, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email id");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(52, 110, 142, 23);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("password");
		lblNewLabel_4.setBounds(52, 160, 142, 23);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_4);
		
		try {
		
			
		
		 comboBox = new JComboBox<String>();
		comboBox.setBounds(256, 60, 246, 35);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.addItem("Manager");
		comboBox.addItem("Operator");
		getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 110,246, 35);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getExtendedKeyCode()==KeyEvent.VK_ENTER)
				{
					doAction();
				}
			}
		});
		passwordField.setBounds(256, 160, 246, 30);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getExtendedKeyCode()==KeyEvent.VK_ENTER)
				{
					doAction();
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			doAction();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(256, 210, 246, 30);
		getContentPane().add(btnNewButton);
		
		button = new JButton("close");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// frmImageViewer.setState(Frame.ICONIFIED);
			
				System.exit(0);
			}
		});
		button.setForeground(new Color(255, 255, 204));
	
		button.setBackground(new Color(204, 0, 51));
		button.setBounds(600, 0,100, 25);
		getContentPane().add(button);
		
		

		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"\n"+e.getClass());
		}
	}
	public void doAction() {
	try{
		String email=textField_1.getText();
		@SuppressWarnings("deprecation")
		String password=passwordField.getText();
		String post=comboBox.getSelectedItem().toString();
		Operator operator=new Operator(0, "", email, password, post);
		OperatorLogin login=new OperatorLogin();
		
		if(login.getLogin(operator)){
		User.setPost(comboBox.getSelectedItem().toString());
		User.setEmail(textField_1.getText());
		User.setName("surabh");
		JOptionPane.showMessageDialog(null, "login");
		dispose();
		
		
		
		}
		else {
			JOptionPane.showMessageDialog(null, "Please enter currect username and password");
		}
	}
	catch (Exception e) {
		// TODO: handle exception
		
		JOptionPane.showMessageDialog(null, e.getMessage()+"\n"+e.getClass());
	}
	}
}
