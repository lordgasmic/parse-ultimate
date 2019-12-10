package com.lordgasmic.recipe.parse.service;

public class ParserFactory {

    public static Parser allRecipesParser() {
        return new AllRecipesParser();
    }
}
