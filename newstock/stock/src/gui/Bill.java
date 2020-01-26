package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import beans.BillUserName;
import beans.Product;

import dbdata.InsertBill;
import dbdata.InsertBillUser;
import dbdata.RetrieveProduct;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bill extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	String name;
	String mobile;
	LinkedList<beans.Bill> list = new LinkedList<beans.Bill>();

	/**
	 * Create the panel.
	 */
	public Bill() {

		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setPreferredSize(new Dimension(900, 1700));
		JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 60, 142, 23);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mobile");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 110, 142, 23);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Product name");
		lblNewLabel_2.setBounds(52, 160, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setBounds(52, 210, 142, 23);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_4);
		textField = new JTextField();
		textField.setBounds(256, 60, 246, 25);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(256, 110, 246, 25);
		add(textField_1);
		textField_1.setColumns(10);
		RetrieveProduct product = new RetrieveProduct();
		try {
			LinkedList<Product> pList = product.getAll();

			final JComboBox<String> comboBox = new JComboBox<String>();
			comboBox.setBounds(256, 160, 246, 25);
			for (Product product2 : pList) {
				comboBox.addItem(product2.getProduct());
			}
			add(comboBox);

			textField_4 = new JTextField();
			textField_4.setBounds(256, 210, 246, 25);
			add(textField_4);
			textField_4.setColumns(10);

			JButton btnNewButton = new JButton("Add More Item");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					try {
						InsertBillUser billUser = new InsertBillUser();
						int billId=billUser.getBillId();
						String product = comboBox.getSelectedItem().toString();
						int quantity = Integer.parseInt(textField_4.getText());
						int price = new RetrieveProduct().getPrice(product);
						list.add(new beans.Bill(product, quantity, price, billId));
						textField_4.setText("");
						comboBox.setSelectedIndex(0);
						repaint();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						JOptionPane.showMessageDialog(new JPanel(),
								e.getMessage() + "\n" + e.getClass());
					}

				}
			});
			btnNewButton.setBounds(256, 260, 246, 25);
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			add(btnNewButton);

			JButton btnNewButton_1 = new JButton("Generate  Bill");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					name = textField.getText();
					mobile = textField_1.getText();
					boolean mob=Pattern.matches("^[0-9]{10}",mobile);
					if(mob&&!name.trim().equalsIgnoreCase("")){
					String date = new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date());
					try {
						InsertBillUser billUser = new InsertBillUser();
						int billId=billUser.getBillId();
						InsertBill bill=new InsertBill();
						BillUserName billUserName=new BillUserName(billId, name,
								mobile, date, "deva");
						billUser.insertBillUser(billUserName);
						String product = comboBox.getSelectedItem().toString();
						int quantity = Integer.parseInt(textField_4.getText());
						int price = new RetrieveProduct().getPrice(product);
						list.add(new beans.Bill(product, quantity, price,billId ));
						for (beans.Bill list2 : list) {
							bill.insertBill(list2);
						}
						new GeneratedBill(list, billUserName).setVisible(true);
						textField.setText("");
						textField_1.setText("");
						textField_4.setText("");
						list.clear();
						comboBox.setSelectedIndex(0);
						repaint();
					} 
					
					catch (Exception e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						JOptionPane.showMessageDialog(new JPanel(),
								e.getMessage() + "\n" + e.getClass());
					}
					}
else {
	JOptionPane.showMessageDialog(new JPanel(), " Entered data is incorrect \n mobile number should be 10 digit");
}
				}
			});
			btnNewButton_1.setBounds(256, 310, 246, 25);
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			add(btnNewButton_1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
