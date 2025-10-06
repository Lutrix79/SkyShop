package org.skypro.skyshop.model.errors;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public record ShopError(String code, String message) {

}
