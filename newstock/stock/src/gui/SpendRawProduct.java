package gui;

import java.awt.Color;
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

import beans.RawProduct;
import beans.RawSubProduct;

import dbdata.IdHandler;
import dbdata.InsertRawSubProduct;
import dbdata.RetrieveRawProduct;
import dbdata.SimpleFormatDate;

public class SpendRawProduct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_2;
	private JComboBox<String> comboBox;
	/**
	 * Create the panel.
	 */
	public SpendRawProduct() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("Product name");
		lblNewLabel_2.setBounds(52, 60, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setBounds(52, 110, 142, 23);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_4);
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(256, 110, 246, 35);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				try{
				String product=comboBox.getSelectedItem().toString();
				Long quantity=Long.parseLong(textField_2.getText());
			
				RetrieveRawProduct rawProduct=new RetrieveRawProduct();
				long quan=rawProduct.getQuan(product);
				if(quan>quantity){
					
				quantity=-quantity;
				if(rawProduct.getLimit(product)>(quan+quantity)){
					JOptionPane.showMessageDialog(new JPanel(), " Available quantity is less than lower limit");
				}
				int pid=new IdHandler().getPid(product);
				InsertRawSubProduct insert=new InsertRawSubProduct();
				insert.insert(new RawSubProduct(1, quantity, 0, "Spend", new SimpleFormatDate().getDate().toString(), pid));
				
				textField_2.setText("");
				repaint();
				JOptionPane.showMessageDialog(new JPanel(),"Response added");
				}
				else {
					JOptionPane.showMessageDialog(new JPanel(), " Entered data is incorrect\n Spend Quantity is more than Available Quantity");
				}
				}
				catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(256, 210, 246, 30);
		add(btnNewButton);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
		}

	}

}
