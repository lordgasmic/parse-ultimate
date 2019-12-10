package com.lordgasmic.recipe.parse.model;

import com.lordgasmic.recipe.parse.casc.UnitOfMeasure;

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
