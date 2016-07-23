package com.endurance.india.dao;

public class PostgreSQLDatabase implements Database {

    @Override
    public void executeQuery(String query) {
        System.out.println("PostgreSQLDatabase: executed query - " + query);
    }

}