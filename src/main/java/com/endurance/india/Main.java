package com.endurance.india;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Dashboard bean = ctx.getBean(Dashboard.class);

        System.out.print("\n\n");
        bean.doSomething();
        System.out.print("\n\n");

        ((AnnotationConfigApplicationContext) (ctx)).close();
    }

}