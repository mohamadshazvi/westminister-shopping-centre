package com.iit.shazvi;

import java.util.List;

import com.iit.shazvi.models.Product;

public interface IshoppingCart {
	
	void addProduct(Product product);
	
	void removeProduct(String productID);
	
	double calculateTotalCost(double price);
	
	List<Product> getSelectedProductList();

}
