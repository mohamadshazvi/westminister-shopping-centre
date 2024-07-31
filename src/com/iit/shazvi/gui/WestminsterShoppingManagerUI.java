package com.iit.shazvi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.iit.shazvi.ShoppingManager;
import com.iit.shazvi.WestminsterShoppingManager;
import com.iit.shazvi.models.Clothing;
import com.iit.shazvi.models.Electronics;
import com.iit.shazvi.models.Product;
import com.iit.shazvi.IshoppingCart;
import com.iit.shazvi.ShoppingCart;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WestminsterShoppingManagerUI {

	protected JFrame frame;
	private JTable table;
	DefaultTableModel defaultTableModel;

	ShoppingManager shoppingManager = new WestminsterShoppingManager();
	IshoppingCart shoppingCart = new ShoppingCart();
	/**
	 * Launch the application.
	 */

	List<Product> selectedProductList = new ArrayList<Product>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WestminsterShoppingManagerUI window = new WestminsterShoppingManagerUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WestminsterShoppingManagerUI() {
		initialize();
		String fileName = "Shopping.txt";
		File f = new File(fileName);
		if (f.exists() && !f.isDirectory()) {
			shoppingManager.loadFromFile(fileName);
		}
		addRowToJTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Westminster Shopping Centre");
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 875, 713);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1009, 688);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Select Product Category");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(136, 60, 167, 31);
		panel.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String query = comboBox.getSelectedItem().toString();
				filter(query);
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "All", "Electronics", "Clothing" }));
		comboBox.setBounds(364, 65, 127, 21);
		panel.add(comboBox);

		JButton btnNewButton = new JButton("Shopping Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartUI shoppingCartUI = new ShoppingCartUI();
				shoppingCartUI.setVisible(true);
				shoppingCartUI.addRowToJTable(selectedProductList);
				frame.dispose();
			}
		});
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(654, 20, 127, 39);
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 134, 743, 222);
		panel.add(scrollPane);

		JLabel lblNewLabel_1 = new JLabel("Selected Product - Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(136, 366, 264, 39);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Product Id : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(158, 401, 82, 21);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Category : ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(158, 432, 82, 21);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Size : ");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(158, 494, 82, 21);
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Name : ");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(158, 463, 82, 21);
		panel.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Colour : ");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(158, 525, 82, 21);
		panel.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_4_1 = new JLabel("Items Available : ");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4_1.setBounds(158, 556, 110, 21);
		panel.add(lblNewLabel_2_4_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(299, 401, 82, 21);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(299, 432, 82, 21);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(299, 463, 82, 21);
		panel.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_1_2 = new JLabel("");
		lblNewLabel_3_1_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(299, 494, 82, 21);
		panel.add(lblNewLabel_3_1_2);

		JLabel lblNewLabel_3_1_3 = new JLabel("");
		lblNewLabel_3_1_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3_1_3.setBounds(299, 525, 82, 21);
		panel.add(lblNewLabel_3_1_3);

		JLabel lblNewLabel_3_1_4 = new JLabel("");
		lblNewLabel_3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_4.setBounds(299, 556, 82, 21);
		panel.add(lblNewLabel_3_1_4);

		JButton btnNewButton_1 = new JButton("Add to Shopping Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (lblNewLabel_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Select a Product");
				} else {
					JOptionPane.showMessageDialog(null, "Product Succefully Added to the Shipping Cart");

					int i = table.getSelectedRow();
					Product product = shoppingManager.getProducById(defaultTableModel.getValueAt(i, 0).toString());
					shoppingCart.addProduct(product);
//					shoppingManager.reduceProuductQuantity(product);
					selectedProductList = shoppingCart.getSelectedProductList();

				}
			}
		});

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(343, 593, 183, 21);
		panel.add(btnNewButton_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				lblNewLabel_3.setText(defaultTableModel.getValueAt(i, 0).toString());
				lblNewLabel_3_1.setText(defaultTableModel.getValueAt(i, 2).toString());
				lblNewLabel_3_1_1.setText(defaultTableModel.getValueAt(i, 1).toString());
				Product product = shoppingManager.getProducById(defaultTableModel.getValueAt(i, 0).toString());
				if (product.getCategory().equalsIgnoreCase("Electronics")) {

					lblNewLabel_2_3.setText("Brand : ");
					lblNewLabel_2_4.setText("Warranty Period : ");
					lblNewLabel_3_1_2.setText(((Electronics) product).getBrand().toString());
					lblNewLabel_3_1_3.setText(String.valueOf(((Electronics) product).getWarrantyPeriod()));

				} else {
					lblNewLabel_2_3.setText("Size : ");
					lblNewLabel_2_4.setText("Colour : ");
					lblNewLabel_3_1_2.setText(((Clothing) product).getColour().toString());
					lblNewLabel_3_1_3.setText(((Clothing) product).getSize().toString());
				}
				lblNewLabel_3_1_4.setText(String.valueOf(product.getNumberOfAvailableItems()));

			}
		});

		defaultTableModel = new DefaultTableModel();
		Object[] column = { "Product ID", "Name", "Category", "Price($)", "Info" };
		Object[] raw = new Object[0];
		defaultTableModel.setColumnIdentifiers(column);
		table.setModel(defaultTableModel);
		scrollPane.setViewportView(table);
	}

	private void addRowToJTable() {

		Electronics electronis;
		Clothing clothing;
		List<Product> productList = shoppingManager.getProductList();
		Object rowData[] = new Object[5];
		for (int i = 0; i < productList.size(); i++) {
			rowData[0] = productList.get(i).getProductId();
			rowData[1] = productList.get(i).getProductName();
			rowData[2] = productList.get(i).getCategory();
			rowData[3] = productList.get(i).getPrice();
			if (productList.get(i).getCategory().equalsIgnoreCase("Electronics")) {
				electronis = (Electronics) productList.get(i);
				rowData[4] = electronis.getBrand() + "," + electronis.getWarrantyPeriod();
			} else {
				clothing = (Clothing) productList.get(i);
				rowData[4] = clothing.getSize() + "," + clothing.getColour();
			}
			if(productList.get(i).getNumberOfAvailableItems()>=1) {
				defaultTableModel.addRow(rowData);
				table.setDefaultRenderer(Object.class, new CustomRowColorRenderer());
			}
			

		}
	}

	private void filter(String query) {
		TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(defaultTableModel);
		table.setRowSorter(tableRowSorter);
		if (!query.equalsIgnoreCase("ALL")) {
			tableRowSorter.setRowFilter(RowFilter.regexFilter(query));
		} else {
			table.setRowSorter(tableRowSorter);
		}

	}

	// Custom TableCellRenderer to set row colors
	private class CustomRowColorRenderer extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			Product product = shoppingManager.getProducById(table.getValueAt(row, 0).toString());

			int count = product.getNumberOfAvailableItems();
			// Change row color based on row index
			if (count < 3) {
				renderer.setBackground(Color.red);
			} else {
				renderer.setBackground(Color.LIGHT_GRAY);
			}

			return renderer;
		}
	}
}
