package com.lordgasmic.parse.fandom.service;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.lordgasmic.parse.fandom.model.Comic;
import com.lordgasmic.parse.service.Parser;
import com.lordgasmic.parse.service.ParserFactory;

public class FandomSearchParser extends Parser<Comic> {

    @Override
    protected Comic offLoad(Document doc) {
        Elements resultsWrapper = doc.select("li.result");
        Element result = resultsWrapper.get(0);

        Element h1 = result.getElementsByTag("h1")
                           .get(0);

        String title = h1.text();

        String articleUrl = h1.getElementsByTag("a")
                              .get(0)
                              .attr("href");

        Parser<Comic> parser = ParserFactory.fandomPageParser();
        Comic comic;
        try {
            comic = parser.parse(articleUrl);
        } catch (IOException e) {
            comic = new Comic();
        }

        comic.setTitle(title);

        return comic;
    }

}
