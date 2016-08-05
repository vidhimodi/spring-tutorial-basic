package com.endurance.india;

import com.endurance.india.dao.Database;
import com.endurance.india.mailer.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dashboard {

    @Autowired private Database dao;
    @Autowired private Mailer mailer;

    public void doSomething(){
        dao.executeQuery("SELECT * FROM table");
        System.out.println("Dashboard: Do Something!!");
        mailer.sendMail();
    }

    public Dashboard(){}

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