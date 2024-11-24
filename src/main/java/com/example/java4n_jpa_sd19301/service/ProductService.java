package com.example.java4n_jpa_sd19301.service;


import com.example.java4n_jpa_sd19301.entity.Product;
import com.example.java4n_jpa_sd19301.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    ProductRepository productRepository = new ProductRepository();

    public ArrayList<Product> getProducts() {

        return productRepository.getProducts();
    }

    public Product getProductById(Long id) {

        return productRepository.getProductById(id);
    }

    public void updateProduct(Product product) {

        productRepository.updateProduct(product);
    }

    public void deleteProduct(long id) {

        productRepository.deleteProduct(id);
    }

    public void addProduct(Product product) {

        productRepository.addProduct(product);
    }

    // JPQL
    public List<Product> getProductsByNameOrId_2(String name, long id) {

        return productRepository.getProductsByNameOrId_2(name, id);
    }

    public List<Product> getProductsByNameOrId_3(String name, long id) {

        return productRepository.getProductsByNameOrId_3(name, id);
    }

    public List<Product> getProductsByNameOrId_4(String name, long id) {

        return productRepository.getProductsByNameOrId_4(name, id);
    }

    public List<Product> getProductsByNameOrId_5(String name, long id) {

        return productRepository.getProductsByNameOrId_5(name, id);
    }

    public List<Product> findProductsByNameContaining(String name) {

        return productRepository.findProductsByNameContaining(name);
    }

}
