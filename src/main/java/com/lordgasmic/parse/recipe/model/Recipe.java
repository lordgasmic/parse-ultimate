package com.lordgasmic.parse.recipe.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Recipe {

    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private List<Step> steps;

    public void addIngredient(Ingredient ingredient) {
        if (null == ingredients) {
            ingredients = new ArrayList<Ingredient>();
        }

        ingredients.add(ingredient);
    }

    public void addStep(Step step) {
        if (null == steps) {
            steps = new ArrayList<Step>();
        }

        steps.add(step);
    }

}
