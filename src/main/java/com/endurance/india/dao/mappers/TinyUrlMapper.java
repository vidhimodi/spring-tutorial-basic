package com.endurance.india.dao.mappers;

import com.endurance.india.models.TinyUrlMapping;
import com.endurance.india.services.BaseUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public class TinyUrlMapper extends ColumnMapper<TinyUrlMapping> {

    @Autowired private BaseUrlService baseUrlService;

    @Override
    public TinyUrlMapping mapRow(ResultSet resultSet, int i) {
        TinyUrlMapping mapping = new TinyUrlMapping();
        mapping.setId(getInt(resultSet, "id"));
        mapping.setShortKey(getString(resultSet, "short_key"));
        mapping.setLongUrl(getString(resultSet, "long_url"));

        mapping.setTinyUrl(baseUrlService.getUrlPrefix() + mapping.getShortKey());

        return mapping;
    }

}