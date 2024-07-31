package com.iit.shazvi;

import com.iit.shazvi.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WestminsterShoppingManager implements ShoppingManager {


    private List<Product> productList;

    public WestminsterShoppingManager() {
        this.productList = new ArrayList<>();
    }

    @Override
    public void addProductToSystem(Product product) {
        if (productList.size() < 50) {
            productList.add(product);
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Cannot add more products. Maximum limit reached.");
        }
    }

    @Override
    public void deleteProductFromSystem(String productID) {
        for (Product product : productList) {
            if (product.getProductId().equals(productID)) {
                productList.remove(product);
                System.out.println("Product deleted successfully. Total products left: " + productList.size());
                return;
            }
        }
        System.out.println("Product not found with ID: " + productID);
    }

    @Override
    public void printProductList() {
        productList.sort(Comparator.comparing(Product::getProductId));
        for (Product product : productList) {
            product.displayInfo();
        }
    }

    @Override
    public void saveToFile(String fileName) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        try {

            // Creating stream and writing the object
            FileOutputStream fout
                    = new FileOutputStream(fileName);
            ObjectOutputStream out
                    = new ObjectOutputStream(fout);

            out.writeObject(productList);
            out.flush();
            out.close();

            System.out.println("Product list saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            productList = (List<Product>) ois.readObject();
            System.out.println(productList.toString());
            System.out.println("Product list loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return this.productList;
	}

	@Override
	public Product getProducById(String productId) {
		for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
		return null;
	}

	@Override
	public void reduceProuductQuantity(Product product) {
		// TODO Auto-generated method stub
//	product.setNumberOfAvailableItems(product.getNumberOfAvailableItems()-1);
		
	}

	
}
