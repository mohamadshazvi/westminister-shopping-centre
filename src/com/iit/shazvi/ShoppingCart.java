package com.iit.shazvi;

import com.iit.shazvi.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements IshoppingCart{

    private List<Product> shoppingCartList;

    public List<Product> getShoppingCartList() {
		return shoppingCartList;
	}

	public void setShoppingCartList(List<Product> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}

	public ShoppingCart() {
        this.shoppingCartList = new ArrayList<>();
    }

    public void addProduct(Product product) {
    	product.setNumberOfAvailableItems(product.getNumberOfAvailableItems()-1);
        shoppingCartList.add(product);
        System.out.println("Product Added succefully to Shopping Cart " + product.toString());
        System.out.println("Initial product list" + shoppingCartList.toString());
        this.setShoppingCartList(shoppingCartList);
    }


	public void removeProduct(String productID) {
        for (Product product : shoppingCartList) {
            if (product.getProductId().equals(productID)) {
                shoppingCartList.remove(product);
                break;
            }
        }
    }

    public double calculateTotalCost(double price) {
        double totalCost = 0;
        for (Product product : shoppingCartList) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }
    
    public List<Product> getSelectedProductList(){
    	return this.getShoppingCartList();
    }
}
