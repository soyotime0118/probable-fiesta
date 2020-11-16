package com.mason.alpha.catalog;

import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

@Log4j2
public class CatalogServiceImpl implements CatalogService {

    private final String supprotedType = "CATALOG";

    private CatalogRepository catalogRepository;

    private DataSource dataSource;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public long create(String name, Set<String> prodNos) {
        log.debug("name : {} prodNos: {}", name, prodNos);

        TransactionSynchronizationManager.initSynchronization();
        Connection c = DataSourceUtils.getConnection(dataSource);
        long catalogId = 0;
        try {
            catalogId = catalogRepository.save(name, prodNos);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DataSourceUtils.releaseConnection(c, dataSource);
            TransactionSynchronizationManager.unbindResource(this.dataSource);
            TransactionSynchronizationManager.clearSynchronization();
        }

        return catalogId;
    }

    @Override
    public boolean isSupportedType(String serviceType) {
        return supprotedType.equals(serviceType);
    }
}
