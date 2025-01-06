package com.nani.webApp.service;

import com.nani.webApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "Canon Camera", 70000),
            new Product(103, "Bat", 10000)
    ));

    // Get all products
    public List<Product> getProducts() {
        return products;
    }

    // Get a product by its ID using Stream API
    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(prodId, "No Item", 0));
    }

    // Add a new product
    public void addProduct(Product prod) {
        products.add(prod);
    }

    // Update a product by its ID
    public void updateProductById(Product prod) {
        Optional<Product> existingProduct = products.stream()
                .filter(p -> p.getProdId() == prod.getProdId())
                .findFirst();

        if (existingProduct.isPresent()) {
            // Replace the existing product with the new one
            products.set(products.indexOf(existingProduct.get()), prod);
        } else {
            // If not found, add the product as new
            products.add(prod);
        }
    }

    // Delete a product by its ID
    public void deleteProductById(int prodId) {
        boolean removed = products.removeIf(p -> p.getProdId() == prodId);
        if (!removed) {
            throw new IllegalArgumentException("Product with ID " + prodId + " not found");
        }
    }
}

