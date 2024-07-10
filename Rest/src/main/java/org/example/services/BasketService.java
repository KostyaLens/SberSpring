package org.example.services;

import org.example.emptity.Basket;
import org.example.emptity.Client;
import org.example.emptity.Product;
import org.example.repository.BasketRepository;
import org.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    public void addProductInBasket(Product product, long idBasket){
        basketRepository.addProductInBasket(product, idBasket);
    }
    public void deleteProductFromBasket(long idBasket, long idProduct){
        deleteProductFromBasket(idBasket, idProduct);
    }
}
