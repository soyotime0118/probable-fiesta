package com.mason.alpha.mapper;

import com.mason.alpha.domain.DomainObject;
import com.mason.alpha.infra.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class Mapper {

    DataMap dataMap;


    public DomainObject findObject(Long key) {
        String sql = "SELECT" + dataMap.columnList() + " FROM " + dataMap.getTableName() + " WHERE catalog_id = ? ";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        DomainObject result = null;
        try {
            stmt = DB.prepare(sql);
            stmt.setLong(1, key);
            rs = stmt.executeQuery();
            rs.next();
            result = load(rs);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            DB.cleanUp(stmt, rs);
        }
        return result;
    }

    private DomainObject load(ResultSet rs) throws SQLException, IllegalAccessException, InstantiationException {
        Long key = rs.getLong("catalog_id");
        DomainObject result = (DomainObject) dataMap.getDomainClass().newInstance();
        result.setID(key);
        loadFields(rs,result);
        return result;
    }

    private void loadFields(ResultSet rs, DomainObject result) throws SQLException {
        for(Iterator it = dataMap.getColumns();it.hasNext();)
        {
            ColumnMap columnMap = (ColumnMap)it.next();
            Object columnValue = rs.getObject(columnMap.getColumnName());
            columnMap.setField(result,columnValue);
        }
    }
}
