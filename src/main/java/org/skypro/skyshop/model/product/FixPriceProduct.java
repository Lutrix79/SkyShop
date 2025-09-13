package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product{

    private final UUID id;
    public FixPriceProduct(String nameOfProduct, UUID id) {
        super(nameOfProduct);
        this.id = id;
    }

    @Override
    public int getPriceOfProduct() {
        return 100;
    }

    @Override
    public String toString() {
        return nameOfProduct + ": Фиксированая цена " + getPriceOfProduct();
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
