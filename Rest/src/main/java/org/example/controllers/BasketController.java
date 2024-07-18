package org.example.controllers;

import org.example.emptity.Product;
import org.example.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("Basket")
public class BasketController {
    @Autowired
    private BasketService basketService;
    @PostMapping("/add")
    public void addProductToBasket(@PathVariable long idProduct, @PathVariable long idBasket){
       basketService.addProductInBasket(idProduct, idBasket);
    }

    @DeleteMapping("/delete")
    public void deleteProductFromBasket(@PathVariable long idBasket, @PathVariable long idProduct){
        basketService.deleteProductFromBasket(idBasket, idProduct);
    }
}
