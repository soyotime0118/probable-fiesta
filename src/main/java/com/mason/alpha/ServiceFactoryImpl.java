package com.mason.alpha;

import com.mason.alpha.catalog.CatalogServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {
    CatalogServiceImpl catalogService = new CatalogServiceImpl();

    @Override
    public Service makeSvc(String serviceType) {
        if (catalogService.isSupportedType(serviceType)) {
            return catalogService;
        }
        throw new IllegalArgumentException();
    }
}
