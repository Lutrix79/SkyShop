package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountProduct extends Product {

    private final int basePrice;
    private final int discountInPercents;
    private final UUID id;

    public DiscountProduct(String nameOfProduct, int basePrice, int discountInPercents, UUID id) {
        super(nameOfProduct);
        this.basePrice = basePrice;
        this.discountInPercents = discountInPercents;
        this.id = id;
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цены должна быть выше одного рубля");
        }
        if (discountInPercents < 0 || discountInPercents > 100) {
            throw new IllegalArgumentException("Процент должен быть числом в диапазоне от 0 до 100 включительно");
        }
    }

    @Override
    public int getPriceOfProduct() {
        return basePrice - basePrice * discountInPercents / 100;
    }

    @Override
    public String toString() {
        return nameOfProduct + ": " + getPriceOfProduct() + " (" + discountInPercents+ "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public UUID getID() {
        return id;
    }

}
