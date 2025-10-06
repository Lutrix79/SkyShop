package org.skypro.skyshop.model.basket;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

@JsonFormat
public final class UserBasket {
    private final List <BasketItem> basketItem;
    private final double total;

    public List<BasketItem> getBasketItem() {
        return basketItem;
    }

    public double getTotal() {
        return total;
    }

    public UserBasket(List<BasketItem> basketItem) {
        this.basketItem = basketItem;
        this.total = calculateTotal(basketItem);
    }

    private double calculateTotal(List<BasketItem> basketItem) {
        return basketItem.stream()
                .mapToDouble(item -> item.product().getPriceOfProduct() * item.quantity())
                .sum();
    }

}
