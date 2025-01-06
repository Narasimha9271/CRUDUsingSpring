package com.nani.webApp.controller;

import com.nani.webApp.model.Product;
import com.nani.webApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        System.out.println(prod);
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProductById(@RequestBody Product prod){
        service.updateProductById(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProductById(@PathVariable int prodId){
        service.deleteProductById(prodId);
    }
}