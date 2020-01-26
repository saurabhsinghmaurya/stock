package gui;

import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesDate extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private 	JDateChooser chooser1;
	private JDateChooser chooser;
	
	/**
	 * Create the panel.
	 */
	public SalesDate() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		chooser=new JDateChooser(new Date(),"yyyy-MM-dd");
		chooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooser1.setMinSelectableDate(chooser.getDate());
				chooser.setMaxSelectableDate(chooser1.getDate());
				chooser.repaint();
				chooser1.repaint();
			}
		});
		chooser.setMaxSelectableDate(new Date());
		chooser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chooser.setBounds(73,60, 142, 23);
		add(chooser);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblFrom.setBounds(10, 60, 67, 23);
		add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTo.setBounds(308, 60, 53, 23);
		add(lblTo);
		
		 chooser1=new JDateChooser(new Date(),"yyyy-MM-dd");
		 chooser1.getCalendarButton().addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		chooser1.setMinSelectableDate(chooser.getDate());
				chooser.setMaxSelectableDate(chooser1.getDate());
				chooser.repaint();
				chooser1.repaint();
		 	}
		 });
		chooser1.setMaxSelectableDate(new Date());
		chooser1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chooser1.setBounds(350,60, 142, 23);
		add(chooser1);
		
		
		
		JButton btnGenerateSalesReport = new JButton("Generate Sales Report");
		btnGenerateSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				JTextField date=(JTextField) chooser.getComponent(1);
				JTextField date1=(JTextField) chooser1.getComponent(1);
				try {
					new SalesReprotGui(date.getText(), date1.getText()).setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnGenerateSalesReport.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGenerateSalesReport.setBounds(185, 128, 224, 29);
		add(btnGenerateSalesReport);
	}
}
