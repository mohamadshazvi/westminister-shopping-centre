package com.iit.shazvi;

import java.util.List;

import com.iit.shazvi.models.Product;

public interface ShoppingManager {

    void addProductToSystem(Product product);

    void deleteProductFromSystem(String productID);

    void printProductList();

    void saveToFile(String fileName);

    void loadFromFile(String fileName);
    
    List<Product> getProductList();
    
    Product getProducById(String productId);

	void reduceProuductQuantity(Product product);
}
