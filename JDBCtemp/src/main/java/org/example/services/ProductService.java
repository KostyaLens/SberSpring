package org.example.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.emptity.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public long saveProduct(Product product){
        return productRepository.addProduct(product);
    }

    public Optional<Product> searchProduct(long id){
        return productRepository.searchProduct(id);
    }

    public List<Product> searchProductByName(String name){
        return productRepository.searchByName(name);
    }

    public void deleteProduct(long id){
        productRepository.deleteProduct(id);
    }
}