package com.lordgasmic.parse.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.lordgasmic.parse.recipe.model.Recipe;

@Service
public class RecipeParseService {

    public Recipe get(String url) throws IOException {
        Parser parser = ParserFactory.allRecipesParser();
        return parser.parse(url);
    }

}
