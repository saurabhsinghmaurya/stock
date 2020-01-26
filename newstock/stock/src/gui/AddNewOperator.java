package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import beans.Employee;
import beans.Operator;
import dbdata.InsertOperator;
import dbdata.OperatorLogin;
import dbdata.RetriveEmp;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddNewOperator extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<String> comboBox;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public AddNewOperator() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("Select an employee");
		lblNewLabel_2.setBounds(52, 60, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Set Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(52, 110, 142, 23);
		add(lblNewLabel_3);
	
		RetriveEmp emp=new RetriveEmp();
	
		try {
			LinkedList<Employee> linkedList=emp.getAllEmp();
			
		
		 comboBox = new JComboBox<String>();
		comboBox.setBounds(256, 60, 246, 25);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		for (Employee emp1 : linkedList) {
			comboBox.addItem(emp1.getEmail());
			
		}
		add(comboBox);
		
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
		passwordField.setBounds(256, 110,246, 25);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
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
		btnNewButton.setBounds(256, 160, 246, 25);
		add(btnNewButton);
	
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void doAction()  {
		try{
		String email=comboBox.getSelectedItem().toString();
		@SuppressWarnings("deprecation")
		String password=passwordField.getText();
		RetriveEmp emp=new RetriveEmp();
		Employee employee=emp.getEmp(email);
		String name=employee.getName();
		String post="Operator";
		OperatorLogin login=new OperatorLogin();
		if(!login.Check(email)){
		Operator operator=new Operator(1, name, email, password, post);
		new InsertOperator().insertOpertor(operator);
		JOptionPane.showMessageDialog(null, "Operator Added.");
		passwordField.setText("");
		}
		else {
			JOptionPane.showMessageDialog(null, "Operator already exist.");	
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage()+"\n"+e.getClass());
		}
		
	}
}
