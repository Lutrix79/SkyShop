package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product{

    private final int priceOfProduct;
    private final UUID id;

    public SimpleProduct(String nameOfProduct, int priceOfProduct, UUID id) {
        super(nameOfProduct);
        this.priceOfProduct = priceOfProduct;
        this.id = id;
        if (priceOfProduct <= 0) {
            throw new IllegalArgumentException("Цены должна быть выше одного рубля");
        }
    }

    @Override
    public UUID getID() {
        return id;
    }

    @Override
    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    @Override
    public String toString() {
        return nameOfProduct + ": " + getPriceOfProduct();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
