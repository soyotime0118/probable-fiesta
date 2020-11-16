package com.mason.alpha;

import com.mason.alpha.catalog.CatalogRepository;
import com.mason.alpha.catalog.CatalogService;
import com.mason.alpha.infra.config.DataSourceConfig;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;


@Log4j2
class CatalogTest {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();
    RepositoryFactory repositoryFactory = new RepositoryFactoryImpl();
    CatalogService catalogService;
    CatalogRepository catalogRepository;
    DataSource dataSource = new DataSourceConfig().h2XADataSource();

    @Test
    void create() {
        catalogRepository = (CatalogRepository) repositoryFactory.makeRepository("CATALOG");
        catalogService = (CatalogService) serviceFactory.makeSvc("CATALOG");
        catalogService.setCatalogRepository(catalogRepository);
        catalogService.setDataSource(dataSource);

        HashSet set = new HashSet<String>();
        set.add("B");
        long catalogNo = catalogService.create("AAA", set);
        log.debug(catalogNo);
        assertThat(catalogNo, IsNull.notNullValue());
    }
}