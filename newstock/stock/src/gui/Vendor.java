package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import dbdata.InsertVendor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vendor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the panel.
	 */
	public Vendor() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);


		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 60, 142, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vendor Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 110, 142, 23);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(52, 160, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price/Item");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(52, 210, 142, 23);
		add(lblNewLabel_3);
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
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String product=textField.getText();
				String vendor=textField_1.getText();
				if(!product.trim().equalsIgnoreCase("")&&!vendor.trim().equalsIgnoreCase("")){
				int quantity=Integer.parseInt(textField_2.getText());
			int price=Integer.parseInt(textField_3.getText());
			String date= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String status="order pending";
			InsertVendor  insertVendor=new InsertVendor();
		
			insertVendor.insertVendor(new beans.Vendor(1,product, vendor, quantity, price, date, status));
			textField.setText("");
			textField_1.setText("");
			textField.setText("");
			textField_2.setText("");
			textField_3.setText("");
			repaint();
			JOptionPane.showMessageDialog(new JPanel(), " successfully added new Order");
		} else {
			JOptionPane.showMessageDialog(new JPanel(), " Entered data is incorrect");
		}
	}
				
				catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
		}
			
			
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(256, 260, 246, 25);
		add(btnNewButton);
		
	}

}
