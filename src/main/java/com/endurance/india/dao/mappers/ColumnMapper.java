package com.endurance.india.dao.mappers;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.Date;

public abstract class ColumnMapper<T> implements RowMapper<T> {

    protected Integer getInt(ResultSet resultSet, String columnName) {
        Integer result = null;

        try {
            result = resultSet.getInt(columnName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    protected String getString(ResultSet resultSet, String columnName) {
        String result = null;

        try {
            result = resultSet.getString(columnName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    protected Boolean getBoolean(ResultSet resultSet, String columnName) {
        Boolean result = null;

        try {
            result = resultSet.getBoolean(columnName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    protected Date getDate(ResultSet resultSet, String columnName) {
        Date result = null;

        try {
            result = new Date(resultSet.getTimestamp(columnName).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}