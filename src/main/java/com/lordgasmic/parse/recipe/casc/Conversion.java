package com.lordgasmic.parse.recipe.casc;

public class Conversion {

    public static int convertToTsp(UnitOfMeasure uom, int quantity) {
        if (uom.isCatchWeight()) {
            throw new IllegalArgumentException();
        }

        return quantity * uom.getConversion();
    }

    public static int convertToOunces(UnitOfMeasure uom, int quantity) {
        if (!uom.isCatchWeight()) {
            throw new IllegalArgumentException();
        }

        return quantity * uom.getConversion();
    }

}
