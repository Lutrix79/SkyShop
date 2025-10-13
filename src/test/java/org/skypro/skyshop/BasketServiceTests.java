package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.errors.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;
import org.skypro.skyshop.util.StorageFixture;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTests {
    private final StorageFixture storageFixture = new StorageFixture();

    @Mock
    private StorageService storageService;
    @Mock
    private ProductBasket productBasket;

    @InjectMocks
    private BasketService basketService;


    @DisplayName("Добавление несуществующего товара в корзину приводит к выбросу исключения")
    @Test
    public void givenProductNotExist_WhenAddToBasket_ThenThrowException() {
        UUID id = UUID.randomUUID();

        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.empty());

        basketService.addProductInBasketById(id);

        assertThatExceptionOfType(NoSuchProductException.class);
    }

    @DisplayName("Добавление существующего товара вызывает метод addProduct у мока ProductBasket")
    @Test
    public void givenProductExist_WhenAddToBasket_ThenAddProductInProductBasket() {
        Product searchable = storageFixture.randomProduct();
        UUID id = searchable.getID();
        Optional<Product> product = Optional.of(searchable);

        Mockito.when(storageService.getProductById(id)).thenReturn(product);

        basketService.addProductInBasketById(id);

        Assertions.assertTrue(product.isPresent());
    }

    @DisplayName("Метод getUserBasket возвращает пустую корзину, если ProductBasket пуст")
    @Test
    public void givenGetUserBasket_WhenEmptyProductBasket_ThenReturnEmptyBasket(){
        ProductBasket userBasket = new ProductBasket(storageService);

        userBasket.getProductBasket();

        Assertions.assertTrue(userBasket.getProductBasket().isEmpty());
    }

    @DisplayName("Метод getUserBasket возвращает подходящую корзину, если в ProductBasket есть товары")
    @Test
    public void givenGetUserBasket_WhenFFullProductBasket_ThenReturnEmptyBasket(){
        ProductBasket userBasket = new ProductBasket(storageService);
        UUID id = UUID.randomUUID();
        userBasket.addProductInBasket(id);

        userBasket.getProductBasket();

        Assertions.assertFalse(userBasket.getProductBasket().isEmpty());
    }
}
