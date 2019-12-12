package com.lordgasmic.parse.fandom.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.lordgasmic.parse.fandom.model.Comic;
import com.lordgasmic.parse.service.Parser;

public class FandomPageParser extends Parser<Comic> {

    @Override
    protected Comic offLoad(Document doc) {
        Comic comic = new Comic();

        String supl = getExtras().get("supl");
        String coverName = null;

        Elements uls = doc.select("ul:not([class])");
        for (Element element : uls) {
            if (element.text()
                       .contains(getExtras().get("upc"))) {
                Elements covers = element.children()
                                         .select("ul")
                                         .select("li");

                for (Element cover : covers) {
                    if (cover.text()
                             .contains(supl)) {
                        String[] tokens = cover.text()
                                               .split(";");
                        coverName = tokens[1].trim();

                        break;
                    }
                }

                break;
            }
        }

        Elements gallery = doc.select("div.wikia-gallery-item");
        for (Element item : gallery) {
            if (item.text()
                    .contains(coverName)) {
                String imageUrl = item.select("img")
                                      .get(0)
                                      .attr("src");
                comic.setImageUrl(imageUrl);

                break;
            }
        }

        int issue = Integer.parseInt(supl.subSequence(0, 3)
                                         .toString());
        boolean variant = !supl.subSequence(3, 4)
                               .equals("1");
        int volume = Integer.parseInt(supl.substring(4));

        comic.setIssue(issue);
        comic.setVolume(volume);
        comic.setVariant(variant);

        return comic;
    }

}
