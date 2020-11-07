package com.mason.alpha;

import com.mason.alpha.catalog.CatalogService;
import com.mason.alpha.catalog.CatalogServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {
    @Override
    public CatalogService makeSvc() {
        return new CatalogServiceImpl();
    }
}
