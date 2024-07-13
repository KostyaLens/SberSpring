package org.example.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.emptity.Basket;
import org.example.emptity.Client;
import org.example.emptity.Product;
import org.example.repository.BasketRepository;
import org.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    public void addProductInBasket(long idProduct, long idBasket){
        basketRepository.add(idProduct, idBasket);
    }
    public void deleteProductFromBasket(long idBasket, long idProduct){
        basketRepository.deleteProductFromBasket(idBasket, idProduct);
    }
}
