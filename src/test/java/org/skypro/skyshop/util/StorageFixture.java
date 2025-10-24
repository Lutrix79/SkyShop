package org.skypro.skyshop.util;

import org.skypro.skyshop.model.product.DiscountProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

public class StorageFixture {
    public final List<Searchable> storageSearchable;
    public final List <Product> storageProducts;
    private final Random random = new Random();

    public StorageFixture() {
        this.storageProducts = List.of(
                new FixPriceProduct("Яблоки " + "\"" + "Свежий урожай" + "\"", UUID.randomUUID()),
                new DiscountProduct("Яблоки " + "\"" + "Антоновка" + "\"", 85, 15, UUID.randomUUID()),
                new SimpleProduct("Яблоки " + "\"" + "Золотой налив" + "\"", 150, UUID.randomUUID())
                );
        this.storageSearchable = List.of(
                new FixPriceProduct("Яблоки " + "\"" + "Свежий урожай" + "\"", UUID.randomUUID()),
                new DiscountProduct("Яблоки " + "\"" + "Антоновка" + "\"", 85, 15, UUID.randomUUID()),
                new SimpleProduct("Яблоки " + "\"" + "Золотой налив" + "\"", 150, UUID.randomUUID())
        );
    }

    public Product randomProduct() {
        return storageProducts.get(random.nextInt(0,3));
    }
}
