package com.lordgasmic.parse.recipe.service;

public class ParserFactory {

    public static RecipeParser allRecipesParser() {
        return new AllRecipesParser();
    }
}
