package com.iit.shazvi.models;

import java.io.Serializable;

public class Electronics extends Product implements Serializable {

    
//	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 301020618231607277L;
	private String brand;
    private int warrantyPeriod;

    public Electronics(){

    }

    public Electronics(String brand, int warrantyPeriod) {
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public Electronics(String productId, String productName, int numberOfAvailableItems, double price, String category, String brand, int warrantyPeriod) {
        super(productId, productName, numberOfAvailableItems, price, category);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics - Product ID: " + getProductId() + ", Name: " + getProductName() +
                ", Available Items: " + getNumberOfAvailableItems() + ", Price: $" + getPrice() + ", Category: " + getCategory() +
                ", Brand: " + brand + ", Warranty Period: " + warrantyPeriod + " months");
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", warrantyPeriod='" + warrantyPeriod + '\'' +
                '}';
    }
}
