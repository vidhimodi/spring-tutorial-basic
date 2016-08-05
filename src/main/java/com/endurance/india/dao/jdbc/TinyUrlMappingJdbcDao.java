package com.endurance.india.dao.jdbc;

import com.endurance.india.dao.TinyUrlMappingDao;
import com.endurance.india.dao.mappers.TinyUrlMapper;
import com.endurance.india.models.TinyUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TinyUrlMappingJdbcDao extends BaseJdbcDao implements TinyUrlMappingDao {

    @Autowired private TinyUrlMapper tinyUrlMapper;

    @Override
    public boolean save(TinyUrlMapping tinyUrlMapping) {
        String query = "INSERT INTO tiny_url_map(short_key, long_url) VALUES (?, ?)";
        return jdbcTemplateObject.update(query, tinyUrlMapping.getShortKey(), tinyUrlMapping.getLongUrl()) == 1;
    }

    @Override
    public TinyUrlMapping findByShortKey(String shortKey) {
        String query = "SELECT id, short_key, long_url FROM tiny_url_map WHERE short_key = ?";
        return jdbcTemplateObject.queryForObject(query, tinyUrlMapper, shortKey);
    }

    @Override
    public TinyUrlMapping findByLongUrl(String longUrl) {
        String query = "SELECT id, short_key, long_url FROM tiny_url_map WHERE long_url = ?";
        return jdbcTemplateObject.queryForObject(query, tinyUrlMapper, longUrl);
    }

    @Override
    public List<TinyUrlMapping> findAll() {
        String query = "SELECT id, short_key, long_url FROM tiny_url_map";
        return jdbcTemplateObject.query(query, tinyUrlMapper);
    }

}