package com.lordgasmic.parse.recipe.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lordgasmic.parse.recipe.model.Recipe;
import com.lordgasmic.parse.recipe.service.RecipeParseService;

@RestController
public class RecipeParseController {

    @Autowired
    private RecipeParseService service;

    @PostMapping("/recipe/parse")
    public Recipe getRecipe(@RequestParam String url) throws IOException {
        Recipe recipe = service.get(url);
        return recipe;
    }
}
