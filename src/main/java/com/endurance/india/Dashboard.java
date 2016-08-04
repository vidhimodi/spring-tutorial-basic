package com.endurance.india;

import com.endurance.india.dao.Database;
import com.endurance.india.mailer.Mailer;

public class Dashboard {

    private Database dao;
    private Mailer mailer;

    public void doSomething(){
        dao.executeQuery("SELECT * FROM table");
        System.out.println("Dashboard: Do Something!!");
        mailer.sendMail();
    }

    public Dashboard(){}

    public Dashboard(Database dao, Mailer mailer) {
        this.dao = dao;
        this.mailer = mailer;
    }

    public Database getDao() {
        return dao;
    }

    public void setDao(Database dao) {
        System.out.println("Setting dao");
        this.dao = dao;
    }

    public Mailer getMailer() {
        return mailer;
    }

    public void setMailer(Mailer mailer) {
        System.out.println("Setting mailer");
        this.mailer = mailer;
    }
}