package com.endurance.india.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = {"classpath:settings.properties"})
public class BaseUrlService {

    @Autowired private Environment env;

    public String getUrlPrefix(){
        return env.getProperty("app.tinyurl.env.host_prefix");
    }

}