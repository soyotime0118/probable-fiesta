package com.mason.alpha.infra.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.SQLException;

public class DataSourceConfig
{
    public AtomikosDataSourceBean mysqlXADataSource() throws SQLException
    {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPassword("mycat123");
        mysqlXADataSource.setUrl("jdbc:mysql://localhost/test");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("mysql");
        return atomikosDataSourceBean;
    }

    public AtomikosDataSourceBean h2XADataSource() {
        JdbcDataSource h2XADataSource = new JdbcDataSource();
        h2XADataSource.setUser("sa");
        h2XADataSource.setPassword("");
        h2XADataSource.setUrl("jdbc:h2:tcp://localhost:1521/test");
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(h2XADataSource);
        atomikosDataSourceBean.setUniqueResourceName("h2");
        return atomikosDataSourceBean;
    }
}
