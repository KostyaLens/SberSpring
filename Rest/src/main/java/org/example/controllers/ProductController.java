package org.example.controllers;

import org.example.emptity.Product;
import org.example.services.ClientService;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<String> productCreate(@RequestBody Product product) throws URISyntaxException {
        return ResponseEntity.created(new URI("http://localhost:8080/product/" + productService.saveProduct(product))).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> productGet(@PathVariable long id){
        Optional<Product> product = Optional.ofNullable(productService.searchProduct(id));
        return product.isPresent()
                ? ResponseEntity.ok().body(product.get())
                : ResponseEntity.notFound().build();
    }


    @GetMapping("/filter/{name}")
    public ResponseEntity<List<Product>> productGetByName(@PathVariable String name){
        List<Product> product = productService.searchProductByName(name);
        return !product.isEmpty()
                ? ResponseEntity.ok().body(product)
                : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public void productDelete(@PathVariable long id){
         productService.deleteProduct(id);
    }
}
