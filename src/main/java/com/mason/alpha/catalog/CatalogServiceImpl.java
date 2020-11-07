package com.mason.alpha.catalog;

import java.util.Set;

public class CatalogServiceImpl implements CatalogService {


    @Override
    public long create(String name, Set<String> prodNos) {
        Catalog catalog = Catalog.builder()
                .name(name)
                .productNos(prodNos).build();
        return catalog.getCatalogNo();
    }
}
