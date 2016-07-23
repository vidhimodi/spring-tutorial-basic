package com.endurance.india;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        MessagePrinter bean = ctx.getBean(MessagePrinter.class);

        System.out.print("\n\n");
        bean.printMessage();
        System.out.print("\n\n");

        ((ClassPathXmlApplicationContext) (ctx)).close();
    }

}