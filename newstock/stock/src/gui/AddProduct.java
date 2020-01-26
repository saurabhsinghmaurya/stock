package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import dbdata.InsertProduct;

import beans.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProduct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public AddProduct() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Product name");
		lblNewLabel.setBounds(52, 60, 142, 23);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(256, 60, 246, 25);
		add(textField);
		JLabel lblNewLabel_1 = new JLabel("Price/Unit");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 110, 142, 23);
		add(lblNewLabel_1);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(256, 110,246, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int i=Integer.parseInt( textField_1.getText());
					String product=textField.getText();
					if(!product.trim().equalsIgnoreCase("")){
				Product product1=new Product(0,product ,i);
			InsertProduct	insertProduct=new InsertProduct();
					
						insertProduct.insertProduct(product1);
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
		btnNewButton.setBounds(256, 160, 246, 25);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(btnNewButton);
		

	}

}
