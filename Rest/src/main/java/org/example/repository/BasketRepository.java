package org.example.repository;

import org.example.emptity.Basket;
import org.example.emptity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BasketRepository {
    private List<Basket> basketList = new ArrayList<Basket>();
    private long id = -1;

    private void createBasket(){
        Basket basket = new Basket(id++, new ArrayList<>(), "");
        basketList.add(basket);
    }

    public void addProductInBasket(Product product, long idBasket){
        if (idBasket >= id){
            createBasket();
        }
        basketList.get((int) idBasket).getProductList().add(product);
    }


    public void deleteProductFromBasket(long idBasket, long idProduct){
        basketList.get((int) idBasket).getProductList().removeIf(p -> p.getId() == id);
    }
}
