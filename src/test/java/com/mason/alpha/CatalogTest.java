package com.mason.alpha;

import com.mason.alpha.catalog.CatalogService;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;


@Log4j2
class CatalogTest {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();
    CatalogService catalogService;

    @Test
    void create() {
        catalogService = (CatalogService) serviceFactory.makeSvc("CATALOG");
        HashSet set = new HashSet<String>();
        set.add("B");
        long catalogNo = catalogService.create("AAA", set);
        log.debug(catalogNo);
        assertThat(catalogNo, IsNull.notNullValue());
    }
}