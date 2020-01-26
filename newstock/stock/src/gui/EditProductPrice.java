package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beans.Product;

import dbdata.RetrieveProduct;
import dbdata.UpdateProductPrice;

public class EditProductPrice extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public EditProductPrice() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setPreferredSize(new Dimension(900,1700));
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 60, 142, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price/Item");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 110, 142, 23);
		add(lblNewLabel_1);
		RetrieveProduct product=new RetrieveProduct();
		try {
			LinkedList<Product> linkedList=product.getAll();
			
		
		 comboBox = new JComboBox<String>();
		comboBox.setBounds(256, 60, 246, 35);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		for (Product rawProduct : linkedList) {
			comboBox.addItem(rawProduct.getProduct());
			
		}
		add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(256, 110,246, 25);
		add(textField);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String product=comboBox.getSelectedItem().toString();
			int price=Integer.parseInt(textField.getText());
			UpdateProductPrice product2=new UpdateProductPrice();
			product2.update(product, price);
			textField.setText("");
			
			repaint();
			JOptionPane.showMessageDialog(new JPanel(), " successfully edited the price/item");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
			}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(256, 160, 246, 25);
		add(btnNewButton);
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
		}



	}

}
