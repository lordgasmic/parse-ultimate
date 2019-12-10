package com.lordgasmic.parse.recipe.model;

import com.lordgasmic.parse.recipe.casc.UnitOfMeasure;

import lombok.Data;

@Data
public class Ingredient {

    private int inventoryId;
    private String name;
    private String adjective;
    private int quantity;
    private String partialQuantity;
    private UnitOfMeasure uom;
    private int sequence;

}
