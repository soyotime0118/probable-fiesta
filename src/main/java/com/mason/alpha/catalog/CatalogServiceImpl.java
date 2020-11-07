package com.mason.alpha.catalog;

import lombok.Setter;

import java.util.Set;

public class CatalogServiceImpl implements CatalogService {

    private final String supprotedType = "CATALOG";

    @Setter
    private CatalogRepository catalogRepository;

    @Override
    public long create(String name, Set<String> prodNos) {
        return catalogRepository.save(name, prodNos);
    }

    @Override
    public boolean isSupportedType(String serviceType) {
        return supprotedType.equals(serviceType);
    }
}
