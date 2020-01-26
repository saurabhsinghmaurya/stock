package gui;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import beans.RawProduct;
import dbdata.IdHandler;
import dbdata.RetrieveRawProduct;

import java.awt.Color;
import java.awt.Font;

public class AvailableRawProduct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8896110194506424248L;
	String sno, product;

	/**
	 * Create the panel.
	 */
	public AvailableRawProduct() {
		
		
		setBackground(new Color(240, 240, 240));
		 RetrieveRawProduct rawProduct=new RetrieveRawProduct();
		LinkedList<RawProduct> ll = null;
		try {
			ll = rawProduct.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = ll.size();
		int n=0;
		Iterator<RawProduct> it = ll.iterator();
		Object[][] data = new Object[i][4];
		while (it.hasNext()) {
			RawProduct rp = it.next();
			data[n][0]=n+1;
			data[n][1]=rp.getProduct().toUpperCase();
			data[n][2]=rp.getLimit();
			data[n][3]=rp.getQuantity();
			n++;
		}
		String[] columnNames = { "S.no", "Product","Lowest Limit","Quantity"

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
					System.out.println("No rows are selected.");
				} else {
				
					
					int selectedRow = lsm.getMinSelectionIndex();
					
					
			String product=model.getValueAt(selectedRow, 1).toString();
			String q=model.getValueAt(selectedRow, 3).toString();
			
			IdHandler handler=new IdHandler();
			try {
				int pid=handler.getPid(product);
				
			new RawProductDetail(pid,product,q).setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
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
		scrollPane.setBounds(10, 11, 774, 197);

		// Add the scroll pane to this panel.
		add(scrollPane);
		
		
	}
}
