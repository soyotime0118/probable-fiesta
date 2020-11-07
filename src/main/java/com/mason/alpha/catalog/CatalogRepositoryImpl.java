package com.mason.alpha.catalog;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CatalogRepositoryImpl implements CatalogRepository {

    private Map<Long, Catalog> longCatalogMap = new HashMap<>();
    private long catalogId = 0L;

    private final String supprotedType = "CATALOG";

    @Override
    public boolean isSupportedType(String serviceType) {
        return supprotedType.equals(serviceType);
    }

    @Override
    public long save(String name, Set<String> prodNos) {
        ++catalogId;
        Catalog catalog = Catalog.builder()
                .name(name)
                .catalogNo(catalogId)
                .productNos(prodNos).build();
        longCatalogMap.put(catalogId, catalog);
        return catalogId;
    }
}
