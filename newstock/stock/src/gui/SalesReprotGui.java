package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import beans.Sales;

import dbdata.SalesReport;

public class SalesReprotGui extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public SalesReprotGui(String date, String date1) throws Exception {
	
		setBounds(300, 50, 806, 501);
		getContentPane().setBackground(new Color(240, 240, 240));
		setModalityType(ModalityType.APPLICATION_MODAL);
		SalesReport salesReport=new SalesReport();
		LinkedList<Sales>ll=salesReport.getSalesReport(date, date1);
		int i = ll.size();
		int n = 0;
		//int totalQuan = 0;
		long totalPrice = 0;
		Iterator<Sales> it = ll.iterator();
		Object[][] data = new Object[i][6];
		while (it.hasNext()) {
			Sales rp = it.next();
			data[n][0] = n + 1;
			data[n][1] = rp.getProduct();
			data[n][2] = rp.getQuantity();
			data[n][3] = rp.getTotalPrice();
			//totalQuan += rp.getQuantity();
			totalPrice += (rp.getTotalPrice() * rp.getQuantity());
			n++;
		}
		String[] columnNames = { "S.no", "Product", "Item Sold","Total Price"

		};

		final JTable table = new JTable(data, columnNames);
		table.setRowHeight(25);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// final javax.swing.table.TableModel model = table.getModel();

		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		table.setOpaque(true);
		table.setShowGrid(true);

		table.repaint();
		repaint();
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 774, 197);

		// Add the scroll pane to this panel.
		getContentPane().add(scrollPane);
		JLabel lblNewLabel = new JLabel("Total Revenue Earned :");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setBounds(10, 300, 185, 40);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel);
		Long quan = totalPrice;
		JLabel lblNewLabel_1 = new JLabel(quan.toString());
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setBounds(226, 300, 262, 40);
		// lblNewLabel_1.setText("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_1);

	}

}
