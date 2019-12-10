package com.lordgasmic.parse.fandom.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.lordgasmic.parse.fandom.model.Comic;
import com.lordgasmic.parse.service.Parser;
import com.lordgasmic.parse.service.ParserFactory;

@Service
public class FandomParseService {

    public Comic get(String url) throws IOException {
        Parser<Comic> parser = ParserFactory.fandomParser();
        return parser.parse(url);
    }
}
