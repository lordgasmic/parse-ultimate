package com.lordgasmic.recipe.parse.casc;

import lombok.Getter;

public enum UnitOfMeasure {

    DEFAULT("", false, 0), TEASPOON("tsp", false, 1), TABLESPOON("tbl", false, 3), OUNCE("oz", true, 1), POUND("lbs", true, 16),
    CUP("cup", false, 48);

    @Getter
    private String value;

    @Getter
    private boolean catchWeight;

    @Getter
    private int conversion;

    private UnitOfMeasure(String value, boolean catchWeight, int conversion) {
        this.value = value;
        this.catchWeight = catchWeight;
        this.conversion = conversion;
    }
}
