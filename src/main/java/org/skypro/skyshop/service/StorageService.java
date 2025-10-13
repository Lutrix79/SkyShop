package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> storageProduct;
    private final Map<UUID, Article> storageArticle;
    private final Map<UUID, Product> availableProducts;


    public StorageService(Map<UUID, Product> storageProduct, Map<UUID, Article> storageArticle, Map<UUID, Product> availableProducts) {
        this.availableProducts = new HashMap<>();
        this.storageProduct = new HashMap<>();
        this.storageArticle = new HashMap<>();
        initStorage();
    }

    private void initStorage(){
        //добавляем в мапу продукты
        Product apple1 = new FixPriceProduct("Яблоки " + "\"" + "Свежий урожай" + "\"", UUID.randomUUID());
        Product apple2 = new DiscountProduct("Яблоки " + "\"" + "Антоновка" + "\"", 85, 15, UUID.randomUUID());
        Product apple3 = new SimpleProduct("Яблоки " + "\"" + "Золотой налив" + "\"", 150, UUID.randomUUID());
        storageProduct.put(apple1.getID(), apple1);
        storageProduct.put(apple2.getID(), apple2);
        storageProduct.put(apple3.getID(), apple3);
        Product pear1 = new FixPriceProduct("Груши Конференс", UUID.randomUUID());
        Product pear2 = new DiscountProduct("Груши Вильямс", 90, 20, UUID.randomUUID());
        Product pear3 = new SimpleProduct("Груши Аббат", 130, UUID.randomUUID());
        storageProduct.put(pear1.getID(), pear1);
        storageProduct.put(pear2.getID(), pear2);
        storageProduct.put(pear3.getID(), pear3);
        Product peach1 = new FixPriceProduct("Персики Золотой триумф", UUID.randomUUID());
        Product peach2 = new DiscountProduct("Персики Посол мира", 100, 10, UUID.randomUUID());
        Product peach3 = new SimpleProduct("Персики Донецкий белый", 180, UUID.randomUUID());
        storageProduct.put(peach1.getID(), peach1);
        storageProduct.put(peach2.getID(), peach2);
        storageProduct.put(peach3.getID(), peach3);
        Product mango1 = new FixPriceProduct("Манго Дункан", UUID.randomUUID());
        Product mango2 = new DiscountProduct("Манго Карабао", 150, 12, UUID.randomUUID());
        Product mango3 = new SimpleProduct("Манго Альфонсо", 200, UUID.randomUUID());
        storageProduct.put(mango1.getID(), mango1);
        storageProduct.put(mango2.getID(), mango2);
        storageProduct.put(mango3.getID(), mango3);
        Product orange1 = new FixPriceProduct("Манго Дункан", UUID.randomUUID());
        Product orange2 = new DiscountProduct("Манго Карабао", 145, 25, UUID.randomUUID());
        Product orange3 = new SimpleProduct("Манго Альфонсо", 220, UUID.randomUUID());
        storageProduct.put(orange1.getID(), orange1);
        storageProduct.put(orange2.getID(), orange2);
        storageProduct.put(orange3.getID(), orange3);
        availableProducts.putAll(storageProduct);

        //добавляем в мапу статьи
        Article apples = new Article("О ПОЛЬЗЕ ЯБЛОК", "Научно доказано. Ни для кого не секрет, что яблоко помогло Ньютону открыть закон всемирного тяготения", UUID.randomUUID());
        Article pears = new Article("О ПОЛЬЗЕ ГРУШ", "Улучшение пищеварения. Клетчатка в составе груш нормализует работу кишечника, улучшает пищеварение.", UUID.randomUUID());
        Article peaches = new Article("О ПОЛЬЗЕ ПЕРСИКОВ", "Для сердечно-сосудистой системы. Антиоксиданты и минеральные вещества нормализуют кровяное давление, восстанавливают тонус стенок сосудов.", UUID.randomUUID());
        Article mangoes = new Article("О ПОЛЬЗЕ МАНГО", "Повышение иммунитета. Высокое содержание витамина С усиливает эффективность лейкоцитов — белых клеток крови, которые повышают защитную функцию организма.", UUID.randomUUID());
        Article oranges = new Article("О ПОЛЬЗЕ АПЕЛЬСИНОВ", "Влияние на нервную систему. Апельсины укрепляют нервную систему и даже повышают настроение.", UUID.randomUUID());
        storageArticle.put(apples.getID(), apples);
        storageArticle.put(pears.getID(), pears);
        storageArticle.put(peaches.getID(), peaches);
        storageArticle.put(mangoes.getID(), mangoes);
        storageArticle.put(oranges.getID(), oranges);
    }

    public Collection<Searchable> getAllSearchable() {
        return Stream.concat(storageProduct.values().stream(), storageArticle.values().stream())
                .toList();
    }

    public Collection<Article> getAllArticles() {
        return storageArticle.values();
    }

    public Collection<Product> getAllProducts() {
        return storageProduct.values();
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(availableProducts.get(id));
    }

}
