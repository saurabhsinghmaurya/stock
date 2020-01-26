package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dbdata.RetrieveOperator;
import dbdata.UpdateOperator;

import beans.Operator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RemoveOperator extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;

	/**
	 * Create the panel.
	 */
	public RemoveOperator() { 
		try{
	
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("Select an operator");
		lblNewLabel_2.setBounds(52, 60, 142, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNewLabel_2);
		RetrieveOperator operator=new RetrieveOperator();
		LinkedList<Operator> linkedList=operator.getAll();
		 comboBox = new JComboBox<String>();
			comboBox.setBounds(256, 60, 246, 25);
			comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			for (Operator operator2 : linkedList) {
				comboBox.addItem(operator2.getEmail());
			}
			add(comboBox);
			
			JButton btnNewButton = new JButton("Remove ");
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
			btnNewButton.setBounds(256, 110, 246, 30);
			add(btnNewButton);
	}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
		}
}
	public void doAction() {
		try{
		String email=comboBox.getSelectedItem().toString();
		UpdateOperator operator=new  UpdateOperator();
		if(	JOptionPane.showConfirmDialog(null, "Are you sure you want to remove operator?")==0){
		operator.removeOperator(email);
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(new JPanel(), e.getMessage()+"\n"+e.getClass());
		}
	}

}
