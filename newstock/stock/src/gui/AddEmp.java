package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beans.Employee;

import com.toedter.calendar.JDateChooser;

import dbdata.EmpValidation;
import dbdata.InsertEmp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_8;
    JPanel jPanel;
    JPanel jPanel1;
	/**
	 * Create the panel.
	 */
	public AddEmp() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setPreferredSize(new Dimension(900,700));
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 60, 142, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FatherName");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 110, 142, 23);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile");
		lblNewLabel_2.setBounds(52, 160, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Salary");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(52, 210, 142, 23);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(52, 260, 142, 23);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_4);
		
		JLabel lblDe = new JLabel("Designation");
		lblDe.setBounds(52, 310, 142, 23);
		lblDe.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblDe);
		
		JLabel lblBirthDay = new JLabel("Birth Day");
		lblBirthDay.setBounds(52, 360,142, 23);
		lblBirthDay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblBirthDay);
		
		JLabel lblJoiningDate = new JLabel("Joining Date");
		lblJoiningDate.setBounds(52, 410, 142, 14);
		lblJoiningDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblJoiningDate);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddress.setBounds(52, 460, 142, 23);
		add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(256, 60, 246, 25);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 110,246, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(256, 160, 246, 25);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(256, 210, 246, 25);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(256, 260, 246, 25);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(256, 310,246, 25);
		add(textField_5);
		textField_5.setColumns(10);
		
		
		jPanel=new JDateChooser(new Date(),"yyyy-MM-dd");
		jPanel.setBounds(256, 360, 246, 25);
		add(jPanel);
		
		jPanel1=new JDateChooser(new Date(),"yyyy-MM-dd");
		jPanel1.setBounds(256, 410, 246, 25);
		add(jPanel1);
		 
		textField_8 = new JTextField();
		
		textField_8.setBounds(256, 460, 246, 25);
		add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doAction();
						}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(256, 510, 246, 35);
		add(btnNewButton);
		
	
		
	}
	public void doAction() {
		try {
			String name=textField.getText();
			String father=textField_1.getText();
			String mobile=textField_2.getText();
			int salary=Integer.parseInt(textField_3.getText());
			String email=textField_4.getText();
			String designation=textField_5.getText();
			JTextField bday=(JTextField) jPanel.getComponent(1);
			JTextField jday=(JTextField) jPanel1.getComponent(1);
			String bdayString=bday.getText();
			String joindayString=jday.getText();
			String address=textField_8.getText();
			InsertEmp  emp=new InsertEmp();
		Employee employee=new Employee(name, father, "male", bdayString, mobile, salary, "working", joindayString, designation, email, address) ;
		if(new EmpValidation().validation(employee))
		{
			emp.insertEmp(employee);
		
			
			textField_1.setText("");
			textField.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_8.setText("");
			bday.setText(new Date().toString());
			jday.setText(new Date().toString());
			repaint();
			JOptionPane.showMessageDialog(new JPanel(), " successfully added new Employee");
		}
		else {
			JOptionPane.showMessageDialog(new JPanel(), " Entered data is incorrect");
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
			}
			

	}
}
