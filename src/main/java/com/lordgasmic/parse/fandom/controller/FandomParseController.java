package com.lordgasmic.parse.fandom.controller;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lordgasmic.parse.fandom.model.Barcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lordgasmic.parse.fandom.model.Comic;
import com.lordgasmic.parse.fandom.service.FandomParseService;

@RestController
public class FandomParseController {

    @Autowired
    private FandomParseService service;

    @PostMapping("/comic/parse")
    public Comic getComicInfo(@RequestBody Barcode barcode) throws IOException {
        System.out.println(Date.from(Instant.now())
                               .toString()
                + ":: Recieved request for [upc: " + barcode.getUpc() + "; supl: " + barcode.getSupl()+ "]");
        Comic comic = service.get(barcode.getUpc(), barcode.getSupl());
        return comic;
    }

    @PostMapping("/comic/derp")
    public String getDerp(){
        return "derp";
    }

    @PostMapping("/comic/search")
    public Map<String, String> getDerpQuery(@RequestParam String name){
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return map;
    }
}
