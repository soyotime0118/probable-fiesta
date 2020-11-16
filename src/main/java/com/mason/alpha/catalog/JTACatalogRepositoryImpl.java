package com.mason.alpha.catalog;

import com.mason.alpha.infra.config.DataSourceConfig;
import com.mason.alpha.infra.config.TransactionManagerFactoryImpl;

import javax.transaction.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public class JTACatalogRepositoryImpl implements CatalogRepository {

    private long catalogId = 0L;

    private final String supprotedType = "CATALOG";

    private UserTransaction userTransaction;


    @Override
    public boolean isSupportedType(String serviceType) {
        return supprotedType.equals(serviceType);
    }

    @Override
    public long save(String name, Set<String> prodNos) {

        userTransaction = new TransactionManagerFactoryImpl().makeTransactionManager();
        try {
            userTransaction.begin();
            String uuid = UUID.randomUUID().toString();

            Connection h2Conn = new DataSourceConfig().h2XADataSource().getConnection();

            PreparedStatement pstmt2 = h2Conn.prepareStatement("insert into OWNER(uuid,name) VALUES (?,'user11')");
            pstmt2.setString(1, uuid);
            pstmt2.execute();

            userTransaction.commit();

        } catch (NotSupportedException | SystemException | SQLException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
        return catalogId;
    }
}
