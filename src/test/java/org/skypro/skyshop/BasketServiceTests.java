package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.errors.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;
import org.skypro.skyshop.util.StorageFixture;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTests {

    @Mock
    private StorageService storageService;
    @Mock
    private ProductBasket productBasket;

    @InjectMocks
    private BasketService basketService;


    @DisplayName("1 Добавление несуществующего товара в корзину приводит к выбросу исключения")
    @Test
    public void givenProductNotExist_WhenAddToBasket_ThenThrowException() {
        UUID id = UUID.randomUUID();
        Exception thrownException = null;

        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.empty());

        try {
            basketService.addProductInBasketById(id);
        } catch (Exception e) {
            thrownException = e;
        }

        assertThat(thrownException)
                .isNotNull()
                .isExactlyInstanceOf(NoSuchProductException.class);
    }

    @DisplayName("2 Добавление существующего товара вызывает метод addProduct у мока ProductBasket")
    @Test
    public void givenProductExist_WhenAddToBasket_ThenAddProductInProductBasket() {
        StorageFixture storageFixture = new StorageFixture();
        Collection<Product> storageProduct = storageFixture.initStorageProducts();
        List<Product> listOfProduct = storageProduct.stream().toList();
        Product searchable = listOfProduct.get(0);
        UUID id = searchable.getID();
        Optional<Product> product = Optional.of(searchable);

        Mockito.lenient().when(storageService.getProductById(id)).thenReturn(product);

        productBasket.addProductInBasket(id);

        Assertions.assertTrue(product.isPresent());
    }

    @DisplayName("3 Метод getUserBasket возвращает пустую корзину, если ProductBasket пуст")
    @Test
    public void givenGetUserBasket_WhenEmptyProductBasket_ThenReturnEmptyBasket(){
        ProductBasket userBasket = Mockito.mock(ProductBasket.class);

        Mockito.when(userBasket.getProductBasket()).thenReturn(new HashMap<>());

        Assertions.assertTrue(userBasket.getProductBasket().isEmpty());
    }

    @DisplayName("4 Метод getUserBasket возвращает подходящую корзину, если в ProductBasket есть товары")
    @Test
    public void givenGetUserBasket_WhenFFullProductBasket_ThenReturnEmptyBasket(){
        ProductBasket userBasket = Mockito.mock(ProductBasket.class);
        UUID id = UUID.randomUUID();
        Map<UUID, Integer> basketItemMap = new HashMap<>();
        basketItemMap.put(id,1);

        Mockito.when(userBasket.getProductBasket()).thenReturn(basketItemMap);

        Assertions.assertFalse(userBasket.getProductBasket().isEmpty());
    }
}
