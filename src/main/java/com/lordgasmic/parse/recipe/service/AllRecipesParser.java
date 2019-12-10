package com.lordgasmic.parse.recipe.service;

public class AllRecipesParser extends Parser {

    @Override
    public String getTitle() {
        return "recipe-main-content";
    }

    @Override
    public String getIngredientsList() {
        return "[itemprop=recipeIngredient]";
    }

    @Override
    public String getDirectionsList() {
        return "[itemprop=recipeInstructions]";
    }

    @Override
    public String getDirectionItem() {
        return ".recipe-directions__list--item";
    }

}
