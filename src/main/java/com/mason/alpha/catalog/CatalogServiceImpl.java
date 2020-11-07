package com.mason.alpha.catalog;

import java.util.Set;

public class CatalogServiceImpl implements CatalogService {

    private final String supprotedType = "CATALOG";

    @Override
    public long create(String name, Set<String> prodNos) {
        Catalog catalog = Catalog.builder()
                .name(name)
                .productNos(prodNos).build();
        return catalog.getCatalogNo();
    }

    @Override
    public boolean isSupportedType(String serviceType) {
        return supprotedType.equals(serviceType);
    }
}
