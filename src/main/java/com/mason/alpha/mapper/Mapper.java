package com.mason.alpha.mapper;

import com.mason.alpha.domain.DomainObject;
import com.mason.alpha.infra.DB;
import lombok.extern.log4j.Log4j2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

@Log4j2
public class Mapper
{

    DataMap dataMap;


    public DomainObject findObject(Long key)
    {
        log.info("컬럼정보로 쿼리문 생성 시작");
        String sql = "\nSELECT" + dataMap.columnList() + " \nFROM " + dataMap.getTableName() + " \nWHERE ID = ? ";
        log.info("\t쿼리 생성 : {} ", sql);
        log.info("컬럼정보로 쿼리문 생성 끝\n");

        PreparedStatement stmt = null;
        ResultSet rs = null;
        DomainObject result = null;
        try
        {
            stmt = DB.prepare(sql);
            stmt.setLong(1, key);
            log.info("생성된 쿼리문 실행 시작");
            log.info("실행 쿼리 {}", stmt.toString());
            rs = stmt.executeQuery();
            log.info("생성된 쿼리문 실행 끝\n");
            rs.next();
            result = load(rs);
            log.info("생성된 도메인객체 {}", result.toString());
            return result;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DB.cleanUp(stmt, rs);
        }
        return result;
    }

    private DomainObject load(ResultSet rs) throws SQLException, IllegalAccessException, InstantiationException
    {
        log.info("\tDB결과로 객체 매핑 시작");
        Long key = rs.getLong("ID");
        DomainObject result = (DomainObject) dataMap.getDomainClass().newInstance();
        result.setID(key);
        log.info("\tID 설정 -> {}", result.toString());
        loadFields(rs, result);
        log.info("\tDB결과로 객체 매핑 끝\n");
        return result;
    }

    private void loadFields(ResultSet rs, DomainObject result) throws SQLException
    {
        for (Iterator it = dataMap.getColumns(); it.hasNext(); )
        {
            ColumnMap columnMap = (ColumnMap) it.next();
            Object columnValue = rs.getObject(columnMap.getColumnName());
            columnMap.setField(result, columnValue);
            log.info("\t\t리플렉션을 사용한 설정 -> {}", result.toString());
        }
    }
}
