package com.mason.alpha.mapper;

import com.mason.alpha.domain.Catalog;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertThat;


@Log4j2
class CatalogMapperTest {

    @Test
    void selectCatalog() {
        CatalogMapper catalogMapper = new CatalogMapper();
        List<Catalog> result = catalogMapper.findByName("ABC");

//        assertTh(result.get(0)).

        assertThat(result.get(0).getId(), IsEqual.equalTo(1L));
    }

    @Test
    void updateCatalog() {
        CatalogMapper catalogMapper = new CatalogMapper();

        Catalog catalog = new Catalog(1L,"NEW_ABC","NEW_IMG");
//        assertTh(result.get(0)).
        catalogMapper.update(catalog);

//        assertThat(result.get(0).getId(), IsEqual.equalTo(1L));
    }
}