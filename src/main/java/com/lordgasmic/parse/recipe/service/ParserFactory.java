package com.lordgasmic.parse.service;

public class ParserFactory {

    public static Parser allRecipesParser() {
        return new AllRecipesParser();
    }
}
