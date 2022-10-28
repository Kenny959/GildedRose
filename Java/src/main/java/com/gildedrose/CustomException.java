package com.gildedrose;

public class CustomException extends RuntimeException {
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}
