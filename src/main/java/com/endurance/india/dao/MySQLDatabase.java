package com.endurance.india.dao;

import org.springframework.stereotype.Component;

@Component
public class MySQLDatabase implements Database {

    @Override
    public void executeQuery(String query) {
        System.out.println("MySQLDatabase: executed query - " + query);
    }

}