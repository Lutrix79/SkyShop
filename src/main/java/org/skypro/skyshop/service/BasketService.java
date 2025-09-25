package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductInBasketById (UUID id){
        Optional<Product> product = storageService.getProductById(id);
        if (product.isPresent()) {
            productBasket.addProductInBasket(id);
        } else {
            throw new IllegalArgumentException("Продукт не найден по ID: " + id);
        }
    }

    public UserBasket getUserBasket (){
        Map<UUID, Integer> basketMap = productBasket.getProductBasket();
        List<BasketItem> basketItemList = basketMap.entrySet().stream()
                .map(map -> new BasketItem(storageService.getProductById(map.getKey()).orElseThrow(), map.getValue()))
                .collect(Collectors.toList());
        return new UserBasket(basketItemList);
    }

}
