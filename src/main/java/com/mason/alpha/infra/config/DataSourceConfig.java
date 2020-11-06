package com.mason.alpha.infra.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.h2.jdbcx.JdbcDataSource;

import javax.annotation.Resource;
import java.sql.SQLException;

public class DataSourceConfig
{
    @Resource(name = "jdbc/testMysql")
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

    @Resource(name = "jdbc/testH2")
    public AtomikosDataSourceBean h2XADataSource() throws SQLException
    {
        JdbcDataSource h2XADataSource = new JdbcDataSource();
        h2XADataSource.setUser("sa");
        h2XADataSource.setPassword("");
        h2XADataSource.setUrl("jdbc:h2:tcp://localhost:1521/test/TEST_h2");
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(h2XADataSource);
        atomikosDataSourceBean.setUniqueResourceName("h2");
        return atomikosDataSourceBean;
    }
}
