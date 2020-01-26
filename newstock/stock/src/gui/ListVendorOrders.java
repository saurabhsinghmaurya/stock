package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import dbdata.RetrieveVendor;
import beans.Vendor;

public class ListVendorOrders extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ListVendorOrders() {
		setBackground(new Color(240, 240, 240));
		RetrieveVendor order=new RetrieveVendor();
		LinkedList<Vendor> ll = null;
		try {
			ll = order.getAllOrder();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = ll.size();
		int n=0;
		Iterator<Vendor> it = ll.iterator();
		Object[][] data = new Object[i][7];
		while (it.hasNext()) {
			Vendor rp = it.next();
			data[n][0]=rp.getSno();
			data[n][1]=rp.getProduct().toUpperCase();
			data[n][2]=rp.getVendor();
			data[n][3]=rp.getQuantity();
			data[n][4]=rp.getPrice();
			data[n][5]=rp.getDate();
			data[n][6]=rp.getStatus();
			n++;
		}
		String[] columnNames = { "S.no", "Product Name","Vendor Name","Quantity","Price/Item","Date","Status"

		};
		
		
		

		final JTable table = new JTable(data, columnNames);
		table.setRowHeight(25);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		final javax.swing.table.TableModel model = table.getModel();
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Ignore extra messages.
				if (e.getValueIsAdjusting())
					return;

				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (lsm.isSelectionEmpty()) {
					//System.out.println("No rows are selected.");
				} else {
				
					
					int selectedRow = lsm.getMinSelectionIndex();
					int i=Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
					String product=model.getValueAt(selectedRow, 1).toString();
					//new EmployeeDetails(model.getValueAt(selectedRow, 2).toString()).setVisible(true);
					new EditOrderStatus(product,i).setVisible(true);
				}
			}
		});
	
		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		table.setOpaque(true);
		table.setShowGrid(true);
		
		table.repaint();
		repaint();
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 828, 197);

		// Add the scroll pane to this panel.
		add(scrollPane);
		
		


	}

}
