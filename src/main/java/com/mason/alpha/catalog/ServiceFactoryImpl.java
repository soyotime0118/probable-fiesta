package com.mason.alpha.catalog;

public class ServiceFactoryImpl implements ServiceFactory {
    @Override
    public CatalogService makeSvc() {
        return new CatalogServiceImpl();
    }
}
