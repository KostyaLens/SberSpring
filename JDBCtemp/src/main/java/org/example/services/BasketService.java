package org.example.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public long addId(){
        return basketRepository.create();
    }
}