package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.errors.NoSuchProductExceptionById;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.StorageService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@SessionScope
@Component
public class ProductBasket {
    private final Map<UUID, Integer> productBasket = new TreeMap<>();
    private final StorageService storageService;

    public ProductBasket(StorageService storageService) {
        this.storageService = storageService;
    }

    public void addProductInBasket(UUID id) {
        Product productById = storageService.getProductById(id).orElseThrow(() -> new NoSuchProductExceptionById("Продукта с иднтификатором " + id.toString() +" не существует"));
//        if (productById.isPresent()) {
//            System.out.println("Такой продукт уже есть, увеличиваю количество на 1");
//        } else {
//            System.out.println("Это первый продукт");
//        }
        productBasket.put(id, productBasket.getOrDefault(id, 0) + 1);
    }

    public Map<UUID, Integer> getProductBasket () {
        return Collections.unmodifiableMap(productBasket);
    }
}
