package com.mason.alpha.catalog;

import lombok.extern.log4j.Log4j2;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;


@Log4j2
class CatalogTest {


    @Test
    void create() {
        HashSet set = new HashSet<String>();
        set.add("B");
        long catalogNo = Catalog.create("AAA", set);
        log.debug(catalogNo);
        assertThat(catalogNo, IsNull.notNullValue());
    }
}