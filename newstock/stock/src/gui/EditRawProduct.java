package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beans.RawProduct;

import dbdata.RetrieveRawProduct;
import dbdata.UpdateRawProduct;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditRawProduct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox<String> comboBox;

	/**
	 * Create the panel.
	 */
	public EditRawProduct() {
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
		RetrieveRawProduct product=new RetrieveRawProduct();
		try {
			LinkedList<RawProduct> linkedList=product.getAll();
			
		
		 comboBox = new JComboBox<String>();
		comboBox.setBounds(256, 60, 246, 35);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		for (RawProduct rawProduct : linkedList) {
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
			int limit=Integer.parseInt(textField.getText());
			UpdateRawProduct product2=new UpdateRawProduct();
			product2.update(product, limit);
			textField.setText("");
			
			repaint();
			JOptionPane.showMessageDialog(new JPanel(), " successfully edited the lower limit");
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
