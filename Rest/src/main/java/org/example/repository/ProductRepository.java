package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.emptity.Client;
import org.example.emptity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ProductRepository {
    private List<Product> productList = new ArrayList<Product>();
    private long id = -1;
    public long addProduct(Product product){
        id++;
        product.setId(id);
        productList.add(product);
        return product.getId();
    }
    public Product search(long id) {
        return productList.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }
    public void deleteProduct(long id){
        productList.removeIf(p -> p.getId() == id);
    }

    public List<Product> searchByName(String name) {
        return productList.stream().filter(x -> x.getName() == name).toList();
    }
}
