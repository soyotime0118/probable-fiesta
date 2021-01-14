package com.mason.alpha.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataMap {
    private String tableName;
    private Class domainClass;
    private List columnMaps = new ArrayList<>();

    public DataMap(Class domainClass, String tableName) {
        this.tableName = tableName;
        this.domainClass = domainClass;
    }

    public Class getDomainClass() {
        return domainClass;
    }

    public void addColumn(String columnName, String jdbcType, String fieldName) {
        columnMaps.add(new ColumnMap(columnName, fieldName, this));
    }

    public void addIDColumn(String columnName, String fieldName) {
        columnMaps.add((new ColumnMap(columnName, fieldName, this)));
    }

    public String columnList() {
        StringBuffer result = new StringBuffer(" catalog_id");
        for (Iterator it = columnMaps.iterator(); it.hasNext(); ) {
            result.append(",");
            ColumnMap columnMap = (ColumnMap) it.next();
            result.append(columnMap.getColumnName());
        }
        return result.toString();
    }

    public String getTableName() {
        return tableName;
    }

    public Iterator getColumns() {
        return columnMaps.iterator();
    }
}
