package com.mason.alpha.catalog;

import lombok.extern.log4j.Log4j2;

import java.util.HashSet;

@Log4j2
public class CatalogUtility {
    public static void main(String[] args) {
        CatalogService catalogService = (name, prodNos) -> {
            log.info("name : {}, prodNos: {}", name, prodNos);
            return 10;
        };
        HashSet<String> prodNos = new HashSet<>();
        prodNos.add("A");

        Long catalogNo = catalogService.create("하하하", prodNos);
        log.info(catalogNo);
    }
}
