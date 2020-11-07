package com.mason.alpha;

import com.mason.alpha.catalog.CatalogRepositoryImpl;

public class RepositoryFactoryImpl implements RepositoryFactory{

    private CatalogRepositoryImpl catalogRepository = new CatalogRepositoryImpl();

    @Override
    public Repository makeRepository(String serviceType) {
        if(catalogRepository.isSupportedType(serviceType))
        {
            return catalogRepository;
        }
        throw new IllegalArgumentException();
    }
}
