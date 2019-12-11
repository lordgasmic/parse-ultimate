package com.lordgasmic.parse.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class Parser<T> {

    protected static final Map<String, String> extras = new HashMap<>();

    public T parse(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                            .get();

        return offLoad(doc);
    }

    public Map<String, String> getExtras() {
        return Parser.extras;
    }

    protected abstract T offLoad(Document doc);
}
