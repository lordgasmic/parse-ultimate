package com.lordgasmic.parse.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class Parser<T> {

    public T parse(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                            .get();

        return offLoad(doc);
    }

    protected abstract T offLoad(Document doc);

    protected abstract String getTitle();

    protected abstract String getIngredientsList();

    protected abstract String getDirectionsList();

    protected abstract String getDirectionItem();
}
