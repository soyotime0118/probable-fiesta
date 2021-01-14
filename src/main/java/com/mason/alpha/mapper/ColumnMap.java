package com.mason.alpha.mapper;

import lombok.ToString;

import java.lang.reflect.Field;

@ToString(of = {"columnName", "fieldName"})
public class ColumnMap {
    private String columnName;
    private String fieldName;
    private Field field;
    private DataMap dataMap;

    public ColumnMap(String columnName, String fieldName, DataMap dataMap) {
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.dataMap = dataMap;
        initField();
    }

    public String getFieldName() {
        return fieldName;
    }

    private void initField() {
        try {
            field = dataMap.getDomainClass().getDeclaredField(getFieldName());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("필드 설정 불가 " + fieldName, e);
        }
    }

    public String getColumnName() {
        return columnName;
    }

    public void setField(Object result, Object columnValue) {
        try {
            field.setAccessible(true);
            field.set(result, columnValue);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("필드 설정 불가 " + fieldName, e);
        }
    }
}
