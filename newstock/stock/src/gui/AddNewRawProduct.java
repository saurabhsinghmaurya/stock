package gui;

import javax.swing.JPanel;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import beans.RawProduct;

import dbdata.InsertRawProduct;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewRawProduct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public AddNewRawProduct() {
	
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setPreferredSize(new Dimension(900,1700));
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 60, 142, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lowest Quantity");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 110, 142, 23);
		add(lblNewLabel_1);
		textField = new JTextField();
		textField.setBounds(256, 60, 246, 35);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 110,246, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				long i=Long.parseLong( textField_1.getText());
				String product=textField.getText();
				if(!product.trim().equalsIgnoreCase("")){
			RawProduct rawProduct=new RawProduct(0,product ,i,0);
				InsertRawProduct insertRawProduct=new InsertRawProduct();
				
					insertRawProduct.insertRawProduct(rawProduct);
					textField_1.setText("");
					textField.setText("");
					repaint();
					JOptionPane.showMessageDialog(new JPanel(), " successfully added new product");
				}
				else {
					JOptionPane.showMessageDialog(new JPanel(), " Entered data is incorrect");
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(256, 160, 246, 25);
		add(btnNewButton);
		
	}
	}
