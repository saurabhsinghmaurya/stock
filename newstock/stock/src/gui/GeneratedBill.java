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

import beans.Bill;
import beans.BillUserName;

public class GeneratedBill extends JDialog {

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
	public GeneratedBill(LinkedList<Bill> ll, BillUserName userName) {
		setBounds(100, 100, 806, 501);
		getContentPane().setBackground(new Color(240, 240, 240));
		setModalityType(ModalityType.APPLICATION_MODAL);
		int i = ll.size();
		int n = 0;
		int totalQuan = 0;
		int totalPrice = 0;
		Iterator<Bill> it = ll.iterator();
		Object[][] data = new Object[i][6];
		while (it.hasNext()) {
			Bill rp = it.next();
			data[n][0] = n + 1;
			data[n][1] = rp.getProduct();
			data[n][2] = rp.getPrice();
			data[n][3] = rp.getQuantity();
			totalQuan += rp.getQuantity();
			totalPrice += (rp.getPrice() * rp.getQuantity());
			n++;
		}
		String[] columnNames = { "S.no", "Product", "Price/Item", "Quantity"

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

		Object[][] data1 = new Object[1][6];
		data1[0][0] = userName.getBillId();
		data1[0][1] = userName.getName();
		data1[0][2] = userName.getMobile();
		data1[0][3] = userName.getDate();
		data1[0][4] = userName.getOperator();
		String[] columnNames1 = { "Bill Id", "Customer Name", "Mobile NO",
				"Bill Date", "Operator Name"

		};
		final JTable table1 = new JTable(data1, columnNames1);
		//table1.setSize(774, 100);
		//table1.setLocation(10, 250);
		table1.setRowHeight(25);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		table1.setOpaque(true);
		table1.repaint();
		table1.setShowGrid(true);
		repaint();
		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBounds(10, 250, 774, 55);
       getContentPane().add(scrollPane1);

		

 
		JLabel lblNewLabel = new JLabel("Total Product Quantity:");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setBounds(10, 300, 185, 40);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel);
		Integer quan = totalQuan;
		JLabel lblNewLabel_1 = new JLabel(quan.toString());
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setBounds(226, 300, 262, 40);
		// lblNewLabel_1.setText("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Total Price");
		lblNewLabel_2.setBounds(10, 350, 185, 40);
		lblNewLabel_2.setForeground(new Color(102, 102, 102));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_2);
		Integer price = totalPrice;
		JLabel lblNewLabel_3 = new JLabel(price.toString());
		// lblNewLabel_3.setText(q);
		lblNewLabel_3.setForeground(new Color(102, 102, 102));
		lblNewLabel_3.setBounds(226, 350, 92, 40);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_3);

	}

}
