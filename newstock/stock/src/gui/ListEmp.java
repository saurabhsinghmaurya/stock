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

import beans.Employee;
import dbdata.RetriveEmp;

public class ListEmp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8567130384877053125L;

	/**
	 * Create the panel.
	 */
	public ListEmp() {
	
		setBackground(new Color(240, 240, 240));
		RetriveEmp emp=new RetriveEmp();
		LinkedList<Employee> ll = null;
		try {
			ll = emp.getAllEmp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = ll.size();
		int n=0;
		Iterator<Employee> it = ll.iterator();
		Object[][] data = new Object[i][3];
		while (it.hasNext()) {
			Employee rp = it.next();
			data[n][0]=n+1;
			data[n][1]=rp.getName().toUpperCase();
			data[n][2]=rp.getEmail();
			n++;
		}
		String[] columnNames = { "S.no", "Employee Name","Email Id"

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
					
					
					new EmployeeDetails(model.getValueAt(selectedRow, 2).toString()).setVisible(true);
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
