package com.lordgasmic.parse.recipe.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.lordgasmic.parse.recipe.model.Recipe;
import com.lordgasmic.parse.service.Parser;
import com.lordgasmic.parse.service.ParserFactory;

@Service
public class RecipeParseService {

    public Recipe get(String url) throws IOException {
        Parser<Recipe> parser = ParserFactory.allRecipesParser();
        return parser.parse(url);
    }

}
