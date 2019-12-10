package com.lordgasmic.parse.recipe.casc;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    public static final Map<String, UnitOfMeasure> UNIT_OF_MEASURE = new HashMap<>();

    static {
        UNIT_OF_MEASURE.put("", UnitOfMeasure.DEFAULT);

        UNIT_OF_MEASURE.put("teaspoon", UnitOfMeasure.TEASPOON);
        UNIT_OF_MEASURE.put("teaspoons", UnitOfMeasure.TEASPOON);
        UNIT_OF_MEASURE.put("tsp", UnitOfMeasure.TEASPOON);

        UNIT_OF_MEASURE.put("tablespoon", UnitOfMeasure.TABLESPOON);
        UNIT_OF_MEASURE.put("tablespoons", UnitOfMeasure.TABLESPOON);
        UNIT_OF_MEASURE.put("tbsp", UnitOfMeasure.TABLESPOON);

        UNIT_OF_MEASURE.put("cup", UnitOfMeasure.CUP);
        UNIT_OF_MEASURE.put("cups", UnitOfMeasure.CUP);

        UNIT_OF_MEASURE.put("ounce", UnitOfMeasure.OUNCE);
        UNIT_OF_MEASURE.put("ounces", UnitOfMeasure.OUNCE);
        UNIT_OF_MEASURE.put("oz", UnitOfMeasure.OUNCE);

        UNIT_OF_MEASURE.put("pound", UnitOfMeasure.POUND);
        UNIT_OF_MEASURE.put("pounds", UnitOfMeasure.POUND);
        UNIT_OF_MEASURE.put("lb", UnitOfMeasure.POUND);
        UNIT_OF_MEASURE.put("lbs", UnitOfMeasure.POUND);
    }
}
