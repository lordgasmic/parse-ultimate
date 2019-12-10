package com.lordgasmic.parse.recipe.casc;

import java.util.Arrays;

import lombok.Getter;

public enum QuantityCode {

    DEFAULT(""), ONE_QUARTER("1/4"), ONE_THIRD("1/3"), ONE_HALF("1/2"), TWO_THIRDS("2/3"), THREE_QUARTERS("3/4");

    @Getter
    private String value;

    private QuantityCode(String value) {
        this.value = value;
    }

    public static boolean matches(String s) {
        return Arrays.stream(values())
                     .anyMatch(code -> code.getValue()
                                           .equals(s));
    }
}
