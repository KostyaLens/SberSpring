package org.example.services;

import org.example.emptity.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public long saveProduct(Product product){
        return productRepository.addProduct(product);
    }

    public Product searchProduct(long id){
        return productRepository.search(id);
    }

    public List<Product> searchProductByName(String name){
        return productRepository.searchByName(name);
    }

    public void deleteProduct(long id){
        productRepository.deleteProduct(id);
    }
}
