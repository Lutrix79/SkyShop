package org.skypro.skyshop.util;

import org.skypro.skyshop.model.product.DiscountProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

public class StorageFixture {
    private final List<Searchable> storageSearchable;
    private final List <Product> storageProducts;

    public StorageFixture() {
        this.storageProducts = new ArrayList<Product>();
        this.storageSearchable = new ArrayList<Searchable>();
    }

    public Collection<Searchable> initStorageSearchable(){
        //добавляем в мапу продукты
        Product apple1 = new FixPriceProduct("Яблоки " + "\"" + "Свежий урожай" + "\"", UUID.randomUUID());
        Product apple2 = new DiscountProduct("Яблоки " + "\"" + "Антоновка" + "\"", 85, 15, UUID.randomUUID());
        Product apple3 = new SimpleProduct("Яблоки " + "\"" + "Золотой налив" + "\"", 150, UUID.randomUUID());
        storageSearchable.add(apple1);
        storageSearchable.add(apple2);
        storageSearchable.add(apple3);
        Product pear1 = new FixPriceProduct("Груши Конференс", UUID.randomUUID());
        Product pear2 = new DiscountProduct("Груши Вильямс", 90, 20, UUID.randomUUID());
        Product pear3 = new SimpleProduct("Груши Аббат", 130, UUID.randomUUID());
        storageSearchable.add( pear1);
        storageSearchable.add(pear2);
        storageSearchable.add(pear3);
        Product peach1 = new FixPriceProduct("Персики Золотой триумф", UUID.randomUUID());
        Product peach2 = new DiscountProduct("Персики Посол мира", 100, 10, UUID.randomUUID());
        Product peach3 = new SimpleProduct("Персики Донецкий белый", 180, UUID.randomUUID());
        storageSearchable.add(peach1);
        storageSearchable.add(peach2);
        storageSearchable.add(peach3);
        Product mango1 = new FixPriceProduct("Манго Дункан", UUID.randomUUID());
        Product mango2 = new DiscountProduct("Манго Карабао", 150, 12, UUID.randomUUID());
        Product mango3 = new SimpleProduct("Манго Альфонсо", 200, UUID.randomUUID());
        storageSearchable.add(mango1);
        storageSearchable.add(mango2);
        storageSearchable.add(mango3);
        return storageSearchable;
    }

    public Collection<Product> initStorageProducts(){
        //добавляем в мапу продукты
        Product apple1 = new FixPriceProduct("Яблоки " + "\"" + "Свежий урожай" + "\"", UUID.randomUUID());
        Product apple2 = new DiscountProduct("Яблоки " + "\"" + "Антоновка" + "\"", 85, 15, UUID.randomUUID());
        Product apple3 = new SimpleProduct("Яблоки " + "\"" + "Золотой налив" + "\"", 150, UUID.randomUUID());
        storageProducts.add(apple1);
        storageProducts.add(apple2);
        storageProducts.add(apple3);
        Product pear1 = new FixPriceProduct("Груши Конференс", UUID.randomUUID());
        Product pear2 = new DiscountProduct("Груши Вильямс", 90, 20, UUID.randomUUID());
        Product pear3 = new SimpleProduct("Груши Аббат", 130, UUID.randomUUID());
        storageProducts.add( pear1);
        storageProducts.add(pear2);
        storageProducts.add(pear3);
        Product peach1 = new FixPriceProduct("Персики Золотой триумф", UUID.randomUUID());
        Product peach2 = new DiscountProduct("Персики Посол мира", 100, 10, UUID.randomUUID());
        Product peach3 = new SimpleProduct("Персики Донецкий белый", 180, UUID.randomUUID());
        storageProducts.add(peach1);
        storageProducts.add(peach2);
        storageProducts.add(peach3);
        Product mango1 = new FixPriceProduct("Манго Дункан", UUID.randomUUID());
        Product mango2 = new DiscountProduct("Манго Карабао", 150, 12, UUID.randomUUID());
        Product mango3 = new SimpleProduct("Манго Альфонсо", 200, UUID.randomUUID());
        storageProducts.add(mango1);
        storageProducts.add(mango2);
        storageProducts.add(mango3);
        return storageProducts;
    }

}
