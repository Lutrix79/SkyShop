package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.errors.NoSuchProductException;
import org.skypro.skyshop.model.errors.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> noSuchProductHandler(NoSuchProductException e) {
        return new ResponseEntity<>(new ShopError("По запросу ничего не найдено", "Продукт с данным id не существует"), HttpStatus.NOT_FOUND);
    }
}
