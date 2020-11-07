package com.mason.alpha.catalog;

import com.mason.alpha.Repository;

import java.util.Set;

public interface CatalogRepository extends Repository {
    long save(String name, Set<String> prodNos);

}
