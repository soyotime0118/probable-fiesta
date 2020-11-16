package com.mason.alpha.catalog;

import com.mason.alpha.Service;

import javax.sql.DataSource;
import java.util.Set;

public interface CatalogService extends Service {

    void setDataSource(DataSource dataSource);

    void setCatalogRepository(CatalogRepository catalogRepository);

    long create(String name, Set<String> prodNos);
}
