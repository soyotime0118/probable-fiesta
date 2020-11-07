package com.mason.alpha.catalog;

import java.util.Set;

public interface CatalogService {
    long create(String name, Set<String> prodNos);
}
