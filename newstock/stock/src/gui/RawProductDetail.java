package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import beans.RawSubProduct;
import dbdata.RetrieveRawSubProduct;
import javax.swing.JLabel;

public class RawProductDetail extends JDialog {

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
	public RawProductDetail(int pid,String prString,String q) {
		getContentPane().setBackground(new Color(240, 240, 240));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(300, 100, 800, 400);
		
	RetrieveRawSubProduct product=new RetrieveRawSubProduct();
		LinkedList<RawSubProduct> ll = null;
		try {
			ll = product.getProductDetail(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = ll.size();
		int n=0;
		long quan = 0;
		Iterator<RawSubProduct> it = ll.iterator();
		Object[][] data = new Object[i][6];
		while (it.hasNext()) {
			RawSubProduct rp = it.next();
			data[n][0]=n+1;
			data[n][1]=rp.getQuantity();
			data[n][2]=rp.getPrice();
			data[n][3]=rp.getAction();
			data[n][4]=rp.getDate();
          quan+=rp.getQuantity();
			n++;
		}
		String[] columnNames = { "S.no", "Quantity","Price/Item","Action","Date"

		};
		
		
		

		final JTable table = new JTable(data, columnNames);
		table.setRowHeight(25);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//final javax.swing.table.TableModel model = table.getModel();
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
				
					
				//	int selectedRow = lsm.getMinSelectionIndex();
					
					
					//new EmployeeDetails(model.getValueAt(selectedRow, 2).toString()).setVisible(true);
				}
			}
		});
	
		
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
		
		JLabel lblNewLabel = new JLabel("Raw product name:");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setBounds(10, 240, 185, 40);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel);
		//IdHandler handler=new IdHandler();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setBounds(226, 240, 262, 40);
		lblNewLabel_1.setText(prString);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total Available Quantity");
		lblNewLabel_2.setBounds(10, 308, 185, 40);
lblNewLabel_2.setForeground(new Color(102, 102, 102));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_2);
		Long long1=quan;
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setText(long1.toString());
		lblNewLabel_3.setForeground(new Color(102, 102, 102));
		lblNewLabel_3.setBounds(226, 308, 92, 40);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_3);
		


	}
}
