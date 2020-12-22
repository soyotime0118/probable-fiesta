package com.mason.alpha.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Catalog {
    private Long id;
    private String name;
    private String imageUrl;

    public Catalog(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
