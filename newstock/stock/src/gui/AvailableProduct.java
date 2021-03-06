package gui;

import java.awt.Color;
import java.awt.Font;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import beans.Product;
import dbdata.RetrieveProduct;

public class AvailableProduct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AvailableProduct() {
		setBackground(new Color(240, 240, 240));
		 RetrieveProduct product=new RetrieveProduct();
		LinkedList<Product> ll = null;
		try {
			ll =product.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = ll.size();
		int n=0;
		Iterator<Product> it = ll.iterator();
		Object[][] data = new Object[i][3];
		while (it.hasNext()) {
			Product rp = it.next();
			data[n][0]=n+1;
			data[n][1]=rp.getProduct().toUpperCase();
			data[n][2]=rp.getPrice();
			
			n++;
		}
		String[] columnNames = { "S.no", "Product","Price/Item"

		};
		
		
		

		final JTable table = new JTable(data, columnNames);
		table.setRowHeight(25);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		final javax.swing.table.TableModel model = table.getModel();
		
			
		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		table.setOpaque(true);
		table.setShowGrid(true);
		
		table.repaint();
		repaint();
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 774, 197);

		// Add the scroll pane to this panel.
		add(scrollPane);
		


	}

}
