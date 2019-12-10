package com.lordgasmic.parse.service;

import com.lordgasmic.parse.fandom.service.FandomPageParser;
import com.lordgasmic.parse.fandom.service.FandomSearchParser;
import com.lordgasmic.parse.recipe.service.AllRecipesParser;
import com.lordgasmic.parse.recipe.service.RecipeParser;

public class ParserFactory {

    public static RecipeParser allRecipesParser() {
        return new AllRecipesParser();
    }

    public static FandomSearchParser fandomSearchParser() {
        return new FandomSearchParser();
    }

    public static FandomPageParser fandomPageParser() {
        return new FandomPageParser();
    }
}
