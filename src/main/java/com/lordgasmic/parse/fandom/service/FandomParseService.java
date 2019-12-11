package com.lordgasmic.parse.fandom.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.lordgasmic.parse.fandom.model.Comic;
import com.lordgasmic.parse.service.Parser;
import com.lordgasmic.parse.service.ParserFactory;

@Service
public class FandomParseService {

    public Comic get(String upc, String supl) throws IOException {
        Parser<Comic> search = ParserFactory.fandomSearchParser();
        Parser<Comic> page = ParserFactory.fandomPageParser();

        page.getExtras()
            .put("upc", upc);
        page.getExtras()
            .put("supl", supl);

        Comic comic = search.parse(buildUrl(upc));
        Comic temp = page.parse(comic.getImageUrl());

        comic.merge(temp);

        return comic;
    }

    private String buildUrl(String upc) {
        return "https://starwars.fandom.com/wiki/Special:Search?query=" + upc;
    }
}
