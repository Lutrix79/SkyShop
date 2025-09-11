package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {

    protected String nameOfProduct;

    public Product(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
        if (nameOfProduct == null || nameOfProduct.isBlank()){
            throw new IllegalArgumentException("Название продукта не может быть null или пустым");
        }
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public abstract int getPriceOfProduct();

    public abstract boolean isSpecial();

    @JsonIgnore
    @Override
    public String findSearchTerm() {
        return nameOfProduct;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return nameOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(nameOfProduct, product.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameOfProduct);
    }
}
