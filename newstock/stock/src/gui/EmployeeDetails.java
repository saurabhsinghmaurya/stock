package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dbdata.RetriveEmp;

import beans.Employee;

public class EmployeeDetails extends JDialog {

	/**
	 * Launch the application.
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public EmployeeDetails(String email) {
		try {

			Employee emp = new RetriveEmp().getEmp(email);
			if (emp == null) {
				throw new Exception();
			}
			setModalityType(ModalityType.APPLICATION_MODAL);
			setBackground(new Color(240, 240, 240));
			setBounds(300, 50, 700, 650);
			getContentPane().setBackground(new Color(240, 240, 240));
			getContentPane().setLayout(null);
			setPreferredSize(new Dimension(900, 700));
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNewLabel.setBounds(52, 60, 142, 23);
			getContentPane().add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("FatherName");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(52, 110, 142, 23);
			getContentPane().add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Mobile");
			lblNewLabel_2.setBounds(52, 160, 142, 23);
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Salary");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNewLabel_3.setBounds(52, 210, 142, 23);
			getContentPane().add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Email");
			lblNewLabel_4.setBounds(52, 260, 142, 23);
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_4);

			JLabel lblDe = new JLabel("Designation");
			lblDe.setBounds(52, 310, 142, 23);
			lblDe.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblDe);

			JLabel lblBirthDay = new JLabel("Birth Day");
			lblBirthDay.setBounds(52, 360, 142, 23);
			lblBirthDay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblBirthDay);

			JLabel lblJoiningDate = new JLabel("Joining Date");
			lblJoiningDate.setBounds(52, 410, 142, 25);
			lblJoiningDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblJoiningDate);

			JLabel lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblAddress.setBounds(52, 460, 142, 23);
			getContentPane().add(lblAddress);

			JLabel lblNewLabel_5 = new JLabel(emp.getName());
			lblNewLabel_5.setBounds(296, 60, 222, 25);
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_5);

			JLabel lblNewLabel_6 = new JLabel(emp.getFather());
			lblNewLabel_6.setBounds(296, 110, 142, 25);
			lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_6);

			
			
			JLabel lblNewLabel_7 = new JLabel(emp.getMobile());
					
			lblNewLabel_7.setBounds(296, 160, 222, 25);
			lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_7);
            Long salary=new Long(emp.getSalary());
			JLabel lblNewLabel_8 = new JLabel(
					salary.toString());
			lblNewLabel_8.setBounds(296, 210, 222, 25);
			lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_8);

			JLabel lblNewLabel_9 = new JLabel(emp.getEmail());
			lblNewLabel_9.setBounds(296, 260, 341, 25);
			lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_9);

			JLabel lblNewLabel_10 = new JLabel(emp.getDesignation());
			lblNewLabel_10.setBounds(296, 310, 222, 25);
			lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_10);

			JLabel lblNewLabel_11 = new JLabel(emp.getBday());
			lblNewLabel_11.setBounds(296, 360, 222, 25);
			lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_11);

			JLabel lblNewLabel_12 = new JLabel(emp.getJoinDate());
			lblNewLabel_12.setBounds(296, 410, 222, 25);
			lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_12);

			JLabel lblNewLabel_13 = new JLabel(emp.getAddress());
			lblNewLabel_13.setBounds(296, 460, 222, 25);
			lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			getContentPane().add(lblNewLabel_13);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(new JPanel(), e.getMessage());
		}
	}

}
