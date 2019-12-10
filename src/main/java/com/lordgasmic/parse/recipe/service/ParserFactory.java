package com.lordgasmic.parse.recipe.service;

public class ParserFactory {

    public static Parser allRecipesParser() {
        return new AllRecipesParser();
    }
}
