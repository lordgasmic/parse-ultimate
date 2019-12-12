package com.lordgasmic.parse.fandom.model;

import lombok.Data;

@Data
public class Comic {

    private String title;
    private String imageUrl;
    private int issue;
    private int volume;
    private boolean variant;

    public void merge(Comic other) {
        this.imageUrl = other.imageUrl;
        this.issue = other.issue;
        this.volume = other.volume;
        this.variant = other.variant;
    }
}
