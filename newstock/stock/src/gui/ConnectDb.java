package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import dbdata.CheckDatabase;
import beans.ConnectionBean;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;

public class ConnectDb extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	

	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Create the dialog.
	 */
	public ConnectDb() {
		
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConnectDb.class.getResource("/image/fs.jpg")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBackground(new Color(240, 240, 240));
		setBounds(350, 50, 550, 300);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 110, 142, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 160, 142, 23);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Port");
		lblNewLabel_2.setBounds(52, 210, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_2);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getExtendedKeyCode()==KeyEvent.VK_ENTER)
				{
					doAction();
				}
			}
		});
		textField.setBounds(256, 110, 246, 25);
		textField.setText("root");
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getExtendedKeyCode()==KeyEvent.VK_ENTER)
				{
					doAction();
				}
			}
		});
		
	
		passwordField.setBounds(256, 160,246, 25);
		getContentPane().add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getExtendedKeyCode()==KeyEvent.VK_ENTER)
				{
					doAction();
				}
			}
		});
		textField_2.setBounds(256, 210, 246, 25);
		textField_2.setText("3306");
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getExtendedKeyCode()==KeyEvent.VK_ENTER)
				{
					doAction();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				doAction();
			}});
		btnNewButton.setBounds(52, 260, 142, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnNewButton_2.setBounds(337, 260, 162, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Connect with mysql host");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(52, 21, 236, 62);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ConnectDb.class.getResource("/image/mysql-logo.jpg")));
		lblNewLabel_4.setBounds(291, 11, 211, 88);
		getContentPane().add(lblNewLabel_4);
		
		
	

	}
	@SuppressWarnings("deprecation")
	public void doAction() {
		try {
			Integer port=Integer.parseInt(textField_2.getText());
			ConnectionBean.setUser(textField.getText());
			ConnectionBean.setPassword(passwordField.getText());
			ConnectionBean.setPort(port);
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:"+ConnectionBean.getPort()+"/"
					+ "mysql", ConnectionBean.getUser(), ConnectionBean.getPassword());
				//System.out.println(new CheckDatabase().checkDatabase(con));
				CheckDatabase  database=new CheckDatabase();
				if(!database.checkDatabase(con)){
				database.execute(con);
				}
				JOptionPane.showMessageDialog(new JPanel(),"Connected with "+con.getMetaData().getDatabaseProductName());
				dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
				JOptionPane.showMessageDialog(new JPanel(),e.getMessage()+e.getClass());
			}
		}
	
	
}
