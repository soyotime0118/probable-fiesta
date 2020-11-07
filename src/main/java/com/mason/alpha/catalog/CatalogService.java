package com.mason.alpha.catalog;

import com.mason.alpha.Service;

import java.util.Set;

public interface CatalogService extends Service {
    long create(String name, Set<String> prodNos);
}
