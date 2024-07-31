package com.iit.shazvi.models;

import java.io.Serializable;

public abstract class Product implements Serializable {

    
//	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5673837070710083516L;
	private String productId;
    private String productName;
    private int numberOfAvailableItems;
    private double price;
    private String category;

    public abstract void displayInfo();

    public Product(){

    }

    public Product(String productId, String productName, int numberOfAvailableItems, double price, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.numberOfAvailableItems = numberOfAvailableItems;
		this.price = price;
		this.category = category;
	}

	public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumberOfAvailableItems() {
        return numberOfAvailableItems;
    }

    public void setNumberOfAvailableItems(int numberOfAvailableItems) {
        this.numberOfAvailableItems = numberOfAvailableItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", numberOfAvailableItems="
				+ numberOfAvailableItems + ", price=" + price + ", category=" + category + "]";
	}


}
