package org.skypro.skyshop.model.basket;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.skypro.skyshop.model.product.Product;

@JsonFormat
public record BasketItem(Product product, int quantity) {
}
