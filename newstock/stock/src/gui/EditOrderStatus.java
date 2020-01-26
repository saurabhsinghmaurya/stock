package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dbdata.RetrieveVendor;
import dbdata.UpdateOrderStatus;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditOrderStatus extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public EditOrderStatus(String product,final int i) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		setBounds(300, 100, 663, 328);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(240,240,240));
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(296, 110, 246, 25);
		comboBox.addItem("Order Pending");
		comboBox.addItem("Accept ");
		comboBox.addItem("Cancel");
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("product Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 60, 142, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Order Status");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 110, 142, 23);
		getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setText(product);
		lblNewLabel_5.setBounds(296, 60, 142, 25);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_5);

		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String status=comboBox.getSelectedItem().toString();
				UpdateOrderStatus orderStatus=new UpdateOrderStatus();
				RetrieveVendor retrieveVendor=new RetrieveVendor();
				String currentStatus=retrieveVendor.getStatus(i);
					if(currentStatus.equalsIgnoreCase("Order Pending"))
					{	
						JOptionPane.showMessageDialog(new JPanel(), "After accepting or cancel order you cannot change status");
					orderStatus.update(status, i);
					repaint();
					JOptionPane.showMessageDialog(new JPanel(), " successfully update Order status");
					dispose();
					}
					else {
						JOptionPane.showMessageDialog(new JPanel(), " Can not change");
						dispose();
					}
					} catch (Exception e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(296, 160, 246, 25);
		getContentPane().add(btnNewButton);
	}
}
