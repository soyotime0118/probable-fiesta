package com.mason.alpha;

import com.mason.alpha.catalog.CatalogService;

public interface ServiceFactory {

    CatalogService makeSvc();
}
