package com.mason.alpha;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mason.alpha.config.DataSourceConfig;
import lombok.extern.log4j.Log4j2;

import javax.transaction.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;


@Log4j2
public class Cars
{

    private AtomikosDataSourceBean mysqlXADataSource;

    private AtomikosDataSourceBean jdbcDataSource;

    public void updateData() throws SystemException, HeuristicRollbackException, HeuristicMixedException, RollbackException, SQLException
    {
        mysqlXADataSource = new DataSourceConfig().mysqlXADataSource();

        jdbcDataSource = new DataSourceConfig().h2XADataSource();

        UserTransactionImp utx = new UserTransactionImp();

        boolean rollback = false;

        try
        {
            utx.begin();
            String uuid = UUID.randomUUID().toString();

            Connection h2Conn = jdbcDataSource.getConnection();
            PreparedStatement pstmt2 = h2Conn.prepareStatement("insert into OWNER(uuid,name) VALUES (?,'user11')");
            pstmt2.setString(1, uuid);
            pstmt2.execute();

            String mysql_query = "insert into cars(uuid,name, price) values (?,'test11', 9999)";


            Connection connection = mysqlXADataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(mysql_query);
            pstmt.setString(1, uuid);
            pstmt.executeUpdate();

            h2Conn.close();
            connection.close();
            throwException();
        }
        catch (NotSupportedException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            rollback = true;
        }
        finally
        {
            if (!rollback) {
                log.debug("커밋");
                utx.commit();
            }
            else {
                log.debug("롤백");
                utx.rollback();
            }
        }

//        utx.rollback();
    }

    private void throwException() throws Exception
    {
        throw new Exception("Exception!");
    }
}
