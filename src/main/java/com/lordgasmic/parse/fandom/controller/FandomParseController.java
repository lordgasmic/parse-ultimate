package com.lordgasmic.parse.fandom.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lordgasmic.parse.fandom.model.Comic;
import com.lordgasmic.parse.fandom.service.FandomParseService;

@RestController
public class FandomParseController {

    @Autowired
    private FandomParseService service;

    @PostMapping("/comic/parse")
    public Comic getComicInfo(@RequestParam String url) throws IOException {
        Comic comic = service.get(url);
        return comic;
    }
}
