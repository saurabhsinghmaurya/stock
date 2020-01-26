package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import beans.User;

public class Fran {

	private JFrame frame;
	JTabbedPane pane2;
	JTabbedPane pane1;
	JTabbedPane pane4;
	JTabbedPane pane3;
	private JScrollPane jsp1;

	private JScrollPane pane;
	JPanel jPanel1;
	JPanel jpanel2;
	JPanel jpanel3;
	JPanel jpanel4;
	JPanel jpanel5;
	JPanel jpanel6;
	JPanel jpanel7;
	JPanel jpanel8;
	JPanel jpanel9;
	JPanel jpanel10;
	JPanel jPanel11;
	JPanel jPanel12;
	JPanel jPanel13;
	JPanel jPanel14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				new ConnectDb().setVisible(true);	
					new Login().setVisible(true);
					Fran window = new Fran();
				
					
					
					try {
						for (LookAndFeelInfo info : UIManager
								.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (Exception e) {
						// If Nimbus is not available, you can set the GUI to
						// another look and feel.
						JOptionPane.showMessageDialog(null, e.getMessage()+"\n"+e.getClass());
					}

					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage()+"\n"+e.getClass());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fran() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try{
		
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Fran.class.getResource("/image/fs.jpg")));
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);

		// panel initialization
		jPanel1 = new AddEmp();
		jpanel2 = new ListEmp1();
		jpanel3 = new ListEmp();
		jpanel5 = new AddNewRawProduct();
		jpanel6 = new EditRawProduct();
		jpanel7 = new AddRawProduct();
		jpanel8 = new SpendRawProduct();
		jpanel9 = new AvailableRawProduct();
		jpanel10 = new Vendor();
		jPanel11 = new ListVendorOrders();
		jPanel12 = new AddProduct();
		jPanel13 = new SalesDate();

		// first tabbed pane.
		pane = new JScrollPane();
		pane.getVerticalScrollBar().setUnitIncrement(16);
		pane.setViewportView(jPanel1);
		pane1 = new JTabbedPane(JTabbedPane.LEFT);
		pane1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				JScrollPane jsp=new JScrollPane(new AddEmp());
				jsp.getVerticalScrollBar().setUnitIncrement(16);
				pane1.removeAll();
				pane1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				pane1.addTab("<html><body marginwidth=75>Add Employee</body><html>",
						jsp);
				pane1.addTab("Edit Employee Details", new ListEmp1());
				pane1.addTab("Add New Operator", new AddNewOperator());
				pane1.addTab("Remove Operator", new RemoveOperator());
				pane1.addTab("Operator List", new OperatorList());
				pane1.addTab("Employee List", new  ListEmp());
				pane1.addTab("Change Password", new ChangePassword());
				
				if(User.getPost().equalsIgnoreCase("Manager"))
				{
				
				}
				else {
					pane1.setEnabledAt(0, false);
					pane1.setEnabledAt(1, false);
					pane1.setEnabledAt(2, false);
					pane1.setEnabledAt(3, false);
					pane1.setSelectedIndex(4);
				}
				
				
			}
		});
		pane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		pane1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pane1.addTab("<html><body marginwidth=75>Add Employee</body><html>",
				pane);
		pane1.addTab("Edit Employee Details", jpanel2);
		pane1.addTab("Add New Operator", new AddNewOperator());
		pane1.addTab("Remove Operator", new RemoveOperator());
		pane1.addTab("Operator List", new OperatorList());
		pane1.addTab("Employee List", jpanel3);
	
		pane1.addTab("Change Password", new ChangePassword());
		if(User.getPost().equalsIgnoreCase("Manager"))
		{
		
		}
		else {
			pane1.setEnabledAt(0, false);
			pane1.setEnabledAt(1, false);
			pane1.setEnabledAt(2, false);
			pane1.setEnabledAt(3, false);
			pane1.setSelectedIndex(4);
		}
		
		// second tabbed pane. for raw material

		pane2 = new JTabbedPane(JTabbedPane.LEFT);
		pane2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				pane2.removeAll();
				pane2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				pane2.addTab("<html><body marginwidth=75>Add Raw Product</body><html>",
						new AddNewRawProduct());
				pane2.addTab("Edit Lowest Limit",new EditRawProduct());
				pane2.addTab("AddItemToStock", new AddRawProduct());
				pane2.addTab("Spend Product", new SpendRawProduct());
				pane2.addTab("Available Product",new AvailableRawProduct());
				if(User.getPost().equalsIgnoreCase("Manager"))
				{
				
				}
				else {
					pane2.setEnabledAt(0, false);
					pane2.setEnabledAt(1, false);
					pane2.setSelectedIndex(2);
				}
				
			}
		});

		pane2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pane2.addTab("<html><body marginwidth=75>Add Raw Product</body><html>",
				jpanel5);
		pane2.addTab("Edit Lowest Limit", jpanel6);
		pane2.addTab("AddItemToStock", jpanel7);
		pane2.addTab("Spend Product", jpanel8);
		pane2.addTab("Available Product", jpanel9);
		if(User.getPost().equalsIgnoreCase("Manager"))
		{
		
		}
		else {
			pane2.setEnabledAt(0, false);
			pane2.setEnabledAt(1, false);
			pane2.setSelectedIndex(2);
		}
		

		// third pane. for vendor order.

		pane3 = new JTabbedPane(JTabbedPane.LEFT);
		pane3.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				pane3.removeAll();
				pane3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				pane3.addTab("<html><body marginwidth=75>New Order</body><html>",
						new Vendor() );
				pane3.addTab("Change Order Status", new ListVendorOrders() );

				
			}
		});
		pane3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pane3.addTab("<html><body marginwidth=75>New Order</body><html>",
				jpanel10);
		pane3.addTab("Change Order Status", jPanel11);

		jsp1 = new JScrollPane();
		jsp1.getVerticalScrollBar().setUnitIncrement(16);
		jsp1.setViewportView(new Bill());

		// fourth tabbed . for auditing.
		pane4 = new JTabbedPane(JTabbedPane.LEFT);
		pane4.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				JScrollPane jsp=new JScrollPane(new Bill());
				jsp.getVerticalScrollBar().setUnitIncrement(16);
				pane4.removeAll();
				pane4.addTab("<html><body marginwidth=105>Add Product</body><html>",
						new AddProduct());
				pane4.addTab("Edit Price/item", new EditProductPrice());
				pane4.addTab("Available Product", new AvailableProduct());
				pane4.addTab("Sales Report", new  SalesDate());
				pane4.addTab("Generate Bill", jsp);
				if(User.getPost().equalsIgnoreCase("Manager"))
				{
				
				}
				else {
					pane4.setEnabledAt(0, false);
					pane4.setEnabledAt(1, false);
					pane4.setSelectedIndex(2);
					pane4.setEnabledAt(3, false);
				}
				
			}
		});

		pane4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pane4.addTab("<html><body marginwidth=105>Add Product</body><html>",
				new  AddProduct());
		pane4.addTab("Sales Report", new SalesDate());
		pane4.addTab("Generate Bill", jsp1);
		if(User.getPost().equalsIgnoreCase("Manager"))
		{
		
		}
		else {
			pane4.setEnabledAt(0, false);
			pane4.setEnabledAt(1, false);
			pane4.setSelectedIndex(2);
		
		}
		
		// main tabbd pane.
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tabbedPane
				.addTab("<html><body marginwidth=58 marginheight=2><h3>Employee Management </h3></body><html>",
						pane1);
		tabbedPane.addTab("<html><body marginwidth=55><h3>Raw Material Management</h3></body><html>",
				pane2);
		tabbedPane.addTab("<html><body marginwidth=55><h3>Vendor Order</h3></body><html>",
				pane3);
		tabbedPane.addTab("<html><body marginwidth=55 ><h3>Auditing & Billing</h3></body><html>",
				pane4);
		
		if(User.getPost().equalsIgnoreCase("Manager"))
		{
		
		}
		else {
		tabbedPane.setEnabledAt(2, false);
			
		
		}
		
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tabbedPane.setBounds(-16, 98, 1120, 500);

		frame.getContentPane().add(tabbedPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Fran.class
				.getResource("/image/logo.png")));

		lblNewLabel.setBounds(10, 0, 378, 87);
		frame.getContentPane().add(lblNewLabel);

		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(150, 50, 1100, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage()+"\n"+e.getClass());
			System.exit(0);
		}
	}
}
