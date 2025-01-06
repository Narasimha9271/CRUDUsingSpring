package com.nani.webApp.service;

import com.nani.webApp.model.Product;
import com.nani.webApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101, "Iphone", 50000),
//            new Product(102, "Canon Camera", 70000),
//            new Product(103, "Bat", 10000)
//    ));

    // Get all products
    public List<Product> getProducts() {
        return repo.findAll();
    }

    // Get a product by its ID using Stream API
    public Product getProductById(int prodId) {
        return repo.findById(prodId)
                .orElse(new Product(prodId, "No Item", 0));
    }

    // Add a new product
    public void addProduct(Product prod) {
        repo.save(prod);
    }

    // Update a product by its ID
    public void updateProductById(Product prod) {
        repo.save(prod);
    }

    // Delete a product by its ID
    public void deleteProductById(int prodId) {
        repo.deleteById(prodId);
    }
}

