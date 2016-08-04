package com.endurance.india;

import com.endurance.india.dao.Database;
import com.endurance.india.mailer.Mailer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Dashboard implements InitializingBean, DisposableBean {

    private Database dao;
    private Mailer mailer;

    private String title;

    public void doSomething(){
        System.out.println("Bean Lifecycle Stage - In Use");
        dao.executeQuery("SELECT * FROM table");
        System.out.println("Dashboard: Do Something!!");
        mailer.sendMail();
    }

    public Dashboard(Database dao, Mailer mailer) {
        System.out.println("Bean Lifecycle Stage - Instantiate");
        this.dao = dao;
        this.mailer = mailer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        System.out.println("Bean Lifecycle Stage - Populate Property");
        this.title = title;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean Lifecycle Stage - After Property Set");
    }

    public void customInitMethod() throws Exception {
        System.out.println("Bean Lifecycle Stage - Custom Init Method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean Lifecycle Stage - Destroy Method");
    }

    public void customDistroyMethod() throws Exception {
        System.out.println("Bean Lifecycle Stage - Custom Destroy Method");
    }
}