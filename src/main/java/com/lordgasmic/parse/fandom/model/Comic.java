package com.lordgasmic.parse.fandom.model;

import lombok.Data;

@Data
public class Comic {

    private String title;
    private String imageUrl;
    private int issue;
    private int volume;
    private boolean variant;
}
