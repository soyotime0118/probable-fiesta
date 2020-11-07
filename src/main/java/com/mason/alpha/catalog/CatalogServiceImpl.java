package com.mason.alpha.catalog;

import lombok.extern.log4j.Log4j2;

import java.util.Set;

@Log4j2
public class CatalogServiceImpl implements CatalogService {

    private final String supprotedType = "CATALOG";

    private CatalogRepository catalogRepository;

    @Override
    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public long create(String name, Set<String> prodNos) {
        log.debug("name : {} prodNos: {}", name, prodNos);
        return catalogRepository.save(name, prodNos);
    }

    @Override
    public boolean isSupportedType(String serviceType) {
        return supprotedType.equals(serviceType);
    }
}
