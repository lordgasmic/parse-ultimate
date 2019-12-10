package com.lordgasmic.recipe.parse.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lordgasmic.recipe.parse.model.Recipe;
import com.lordgasmic.recipe.parse.service.RecipeParseService;

@RestController
public class RecipeParseController {

    @Autowired
    private RecipeParseService service;

    @PostMapping("/parse")
    public Recipe getRecipe(@RequestParam String url) throws IOException {
        Recipe recipe = service.get(url);
        return recipe;
    }
}
