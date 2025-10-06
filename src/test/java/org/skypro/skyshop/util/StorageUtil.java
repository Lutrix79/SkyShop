package org.skypro.skyshop.util;

import org.skypro.skyshop.model.product.DiscountProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

public class StorageUtil {
    private final List<Searchable> storageProduct;

    public StorageUtil() {
        this.storageProduct = new ArrayList<Searchable>();
    }

    public List<Searchable> initStorage(){
        //добавляем в мапу продукты
        Product apple1 = new FixPriceProduct("Яблоки " + "\"" + "Свежий урожай" + "\"", UUID.randomUUID());
        Product apple2 = new DiscountProduct("Яблоки " + "\"" + "Антоновка" + "\"", 85, 15, UUID.randomUUID());
        Product apple3 = new SimpleProduct("Яблоки " + "\"" + "Золотой налив" + "\"", 150, UUID.randomUUID());
        storageProduct.add(apple1);
        storageProduct.add(apple2);
        storageProduct.add(apple3);
        Product pear1 = new FixPriceProduct("Груши Конференс", UUID.randomUUID());
        Product pear2 = new DiscountProduct("Груши Вильямс", 90, 20, UUID.randomUUID());
        Product pear3 = new SimpleProduct("Груши Аббат", 130, UUID.randomUUID());
        storageProduct.add( pear1);
        storageProduct.add(pear2);
        storageProduct.add(pear3);
        Product peach1 = new FixPriceProduct("Персики Золотой триумф", UUID.randomUUID());
        Product peach2 = new DiscountProduct("Персики Посол мира", 100, 10, UUID.randomUUID());
        Product peach3 = new SimpleProduct("Персики Донецкий белый", 180, UUID.randomUUID());
        storageProduct.add(peach1);
        storageProduct.add(peach2);
        storageProduct.add(peach3);
        Product mango1 = new FixPriceProduct("Манго Дункан", UUID.randomUUID());
        Product mango2 = new DiscountProduct("Манго Карабао", 150, 12, UUID.randomUUID());
        Product mango3 = new SimpleProduct("Манго Альфонсо", 200, UUID.randomUUID());
        storageProduct.add(mango1);
        storageProduct.add(mango2);
        storageProduct.add(mango3);
        Product orange1 = new FixPriceProduct("Манго Дункан", UUID.randomUUID());
        Product orange2 = new DiscountProduct("Манго Карабао", 145, 25, UUID.randomUUID());
        Product orange3 = new SimpleProduct("Манго Альфонсо", 220, UUID.randomUUID());
        storageProduct.add(orange1);
        storageProduct.add(orange2);
        storageProduct.add(orange3);
        return storageProduct;
    }

}
