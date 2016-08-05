package com.endurance.india.dao;

import com.endurance.india.models.TinyUrlMapping;

import java.util.List;

public interface TinyUrlMappingDao extends BaseDao {

    boolean save(TinyUrlMapping tinyUrlMapping);

    TinyUrlMapping findByShortKey(String shortKey);
    TinyUrlMapping findByLongUrl(String longUrl);
    List<TinyUrlMapping> findAll();

}