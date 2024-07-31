package com.iit.shazvi.models;

import java.io.Serializable;

public class Clothing extends Product implements Serializable {
	
//	private static final long serialVersionUID = 1L;

    /**
	 * 
	 */
	private static final long serialVersionUID = 3838530900057912823L;
	private String size;
    private String colour;

    public Clothing(){

    }

    public Clothing(String size, String colour) {
        this.size = size;
        this.colour = colour;
    }

    public Clothing(String productId, String productName, int numberOfAvailableItems, double price, String category, String size, String colour) {
        super(productId, productName, numberOfAvailableItems, price, category);
        this.size = size;
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void displayInfo() {
        System.out.println("Clothing - Product ID: " + getProductId() + ", Name: " + getProductName() +
                ", Available Items: " + getNumberOfAvailableItems() + ", Price: $" + getPrice() + ", Category: " + getCategory() +
                ", Size: " + size + ", Color: " + colour);
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
