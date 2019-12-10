package com.lordgasmic.parse.recipe.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.lordgasmic.parse.recipe.casc.Dictionary;
import com.lordgasmic.parse.recipe.model.Ingredient;
import com.lordgasmic.parse.recipe.model.Recipe;
import com.lordgasmic.parse.recipe.model.Step;
import com.lordgasmic.parse.service.Parser;

public abstract class RecipeParser extends Parser<Recipe> {

    @Override
    protected Recipe offLoad(Document doc) {
        Recipe r = new Recipe();

        Element title = doc.getElementById(getTitle());
        r.setName(title.text());

        // ingredients
        Elements ingredients = doc.select(getIngredientsList());
        for (Element ingredient : ingredients) {
            Ingredient ing = new Ingredient();
            String s = ingredient.text();
            String[] tokens = s.split(" ");
            startPipeline(ing, tokens);
            r.addIngredient(ing);
        }

        // directions
        Elements directions = doc.select(getDirectionsList());
        Elements spans = directions.get(0)
                                   .select(getDirectionItem());
        for (int i = 0; i < spans.size(); i++) {
            Element span = spans.get(i);
            Step step = new Step();
            step.setSequence(i);
            step.setText(span.text());
            r.addStep(step);
        }

        return r;
    }

    private static boolean isFraction(String s) {
        if (s.length() == 3 && NumberUtils.isParsable(s.substring(0, 1)) && NumberUtils.isParsable(s.substring(2, 3)) && ('/' == s.charAt(1))) {
            return true;
        }

        return false;
    }

    private static void startPipeline(Ingredient ingredient, String[] arr) {
        quantityPipeline(ingredient, arr, 0);
    }

    private static void quantityPipeline(Ingredient ingredient, String[] arr, int i) {
        if (NumberUtils.isParsable(arr[i])) {
            ingredient.setQuantity(Integer.parseInt(arr[i]));
            i++;
        } else {
            ingredient.setQuantity(0);
        }

        partialQuantityPipeline(ingredient, arr, i);
    }

    private static void partialQuantityPipeline(Ingredient ingredient, String[] arr, int i) {
        if (isFraction(arr[i])) {
            ingredient.setPartialQuantity(arr[i]);
            i++;
        }

        uomPipeline(ingredient, arr, i);
    }

    private static void uomPipeline(Ingredient ingredient, String[] arr, int i) {
        if (Dictionary.UNIT_OF_MEASURE.containsKey(arr[i].toLowerCase())) {
            ingredient.setUom(Dictionary.UNIT_OF_MEASURE.get(arr[i].toLowerCase()));
            i++;
        }

        remainderPipeline(ingredient, arr, i);
    }

    private static void remainderPipeline(Ingredient ingredient, String[] arr, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < arr.length; j++) {
            sb.append(arr[j]);
            sb.append(' ');
        }
        ingredient.setName(sb.toString()
                             .trim());
    }

    public abstract String getTitle();

    public abstract String getIngredientsList();

    public abstract String getDirectionsList();

    public abstract String getDirectionItem();
}
