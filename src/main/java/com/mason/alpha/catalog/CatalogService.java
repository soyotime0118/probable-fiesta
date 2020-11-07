package com.mason.alpha.catalog;

import com.mason.alpha.Service;

import java.util.Set;

public interface CatalogService extends Service {

    void setCatalogRepository(CatalogRepository catalogRepository);

    long create(String name, Set<String> prodNos);
}
