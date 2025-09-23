package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@SessionScope
@Component
public class ProductBasket {
    private final Map<UUID, Integer> productBasket = new TreeMap<>();

    public void addProductInBasket(UUID id) {
        productBasket.put(id, productBasket.getOrDefault(id, 0) + 1);
    }

    public Map<UUID, Integer> getProductBasket () {
        return Collections.unmodifiableMap(productBasket);
    }
}
