package com.iit.shazvi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.iit.shazvi.IshoppingCart;
import com.iit.shazvi.ShoppingCart;
import com.iit.shazvi.WestminsterShoppingManager;
import com.iit.shazvi.models.Clothing;
import com.iit.shazvi.models.Electronics;
import com.iit.shazvi.models.Product;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShoppingCartUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private JLabel lblNewLabel = new JLabel("");
	private JLabel lblNewLabel_1 = new JLabel("");
	private JLabel lblNewLabel_2 = new JLabel("");
	private JLabel lblNewLabel_3 = new JLabel("");

	DefaultTableModel defaultTableModel;

	IshoppingCart shoppingCart = new ShoppingCart();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCartUI frame = new ShoppingCartUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShoppingCartUI() {
		setTitle("Shopping Cart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 84, 768, 216);
		contentPane.add(scrollPane);

		table = new JTable();
		defaultTableModel = new DefaultTableModel();
		Object[] column = { "Product", "Quantity", "Price($)" };
		Object[] raw = new Object[0];
		defaultTableModel.setColumnIdentifiers(column);
		table.setModel(defaultTableModel);
		table.setBackground(new Color(175, 238, 238));
		scrollPane.setViewportView(table);

		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(726, 339, 86, 23);
		contentPane.add(lblNewLabel);

		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(726, 372, 86, 24);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(726, 406, 86, 23);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(726, 439, 86, 21);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1 = new JLabel("Three Items in Same Category Discount (20%)");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(270, 406, 359, 23);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Final Total");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(543, 439, 86, 21);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_1_1 = new JLabel("Firtst Purchase Discount (10%)");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(400, 372, 229, 24);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblTitle = new JLabel("Total");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(543, 339, 86, 23);
		contentPane.add(lblTitle);

		JButton btnNewButton = new JButton("Back To Main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WestminsterShoppingManagerUI westminsterShoppingManagerUI = new WestminsterShoppingManagerUI();
				westminsterShoppingManagerUI.frame.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(23, 10, 120, 33);
		contentPane.add(btnNewButton);

	}

	public void addRowToJTable(List<Product> productList) {

		double price = 0;
		double firstPurchaseDiscount = 0;
		double threeItemSameCategoryDiscount = 0;
		Map<String, Integer> parameterOccurrences = new HashMap<>();

		Map<String, Integer> elementCountMap = new HashMap<>();

		Object rowData[] = new Object[3];
		for (int i = 0; i < productList.size(); i++) {

			elementCountMap.put(productList.get(i).getProductId(),
					elementCountMap.getOrDefault(productList.get(i).getProductId(), 0) + 1);

			price = price + productList.get(i).getPrice();
			System.out.println("Totalcost " + price);
			parameterOccurrences.put(productList.get(i).getProductId(),
					parameterOccurrences.getOrDefault(productList.get(i).getProductId(), 0) + 1);

		}

		for (Map.Entry<String, Integer> entry : elementCountMap.entrySet()) {
			System.out.println("Element: " + entry.getKey() + ", Occurrences: " + entry.getValue());

			// Use HashSet to get unique values
			HashSet<Product> uniqueValuesSet = new HashSet<>(productList);

			// Convert the unique set back to a list if needed
			List<Product> uniqueValuesList = new ArrayList<>(uniqueValuesSet);
			for (Product product : uniqueValuesList) {
				if (product.getProductId().equals(entry.getKey())) {
					if (product.getCategory().equalsIgnoreCase("Electronics")) {
						rowData[0] = product.getProductId() + ", " + product.getProductName() + ", "
								+ ((Electronics) product).getBrand().toString() + ", "
								+ ((Electronics) product).getWarrantyPeriod();
					} else {
						rowData[0] = product.getProductId() + ", " + product.getProductName() + ", "
								+ ((Clothing) product).getColour().toString() + ", " + ((Clothing) product).getSize();
					}

					rowData[1] = entry.getValue();
					rowData[2] = product.getPrice() * entry.getValue();
					defaultTableModel.addRow(rowData);
				}
			}

		}

		boolean hasThreeOccurrences = false;
		for (Map.Entry<String, Integer> entry : parameterOccurrences.entrySet()) {
			if (entry.getValue() == 3) {
				System.out.println("Parameter '" + entry.getKey() + "' has 3 occurrences.");
				hasThreeOccurrences = true;
				break; // Stop checking once a parameter with 3 occurrences is found
			}
		}

		if (hasThreeOccurrences) {
			System.out.println("No parameter has 3 occurrences.");
			threeItemSameCategoryDiscount = price * 0.2;
		} else {
			threeItemSameCategoryDiscount = 0.0;
		}

		System.out.println("Cost" + price);
		firstPurchaseDiscount = price * 0.1;

		double total = price - firstPurchaseDiscount - threeItemSameCategoryDiscount;

		lblNewLabel.setText(String.valueOf(price) + "$");
		lblNewLabel_1.setText("-" + firstPurchaseDiscount + "$");
		lblNewLabel_2.setText("-" + threeItemSameCategoryDiscount + "$");
		lblNewLabel_3.setText("" + total + "$");
	}
}
