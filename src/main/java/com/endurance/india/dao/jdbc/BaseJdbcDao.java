package com.endurance.india.dao.jdbc;

import com.endurance.india.dao.BaseDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class BaseJdbcDao implements BaseDao {

    protected JdbcTemplate jdbcTemplateObject;
    public void setDataSource(DataSource ds) {
        this.jdbcTemplateObject = new JdbcTemplate(ds);
    }

}