package com.endurance.india;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        System.out.println("Is the Bean 'singleton'? " + ctx.isSingleton("printer"));
        System.out.println("Is the Bean 'prototype'? " + ctx.isPrototype("printer"));

        System.out.print("\n\n");
        MessagePrinter bean = (MessagePrinter) ctx.getBean("printer");
        bean.printMessage();
        bean.setMessage(">>> New Message Set in the Bean.");
        bean.printMessage();
        System.out.print("\n\n");
        MessagePrinter anotherBean = (MessagePrinter) ctx.getBean("printer");
        anotherBean.printMessage();
        System.out.print("\n\n");

        Thread.sleep(1500);

        ((ClassPathXmlApplicationContext) (ctx)).close();
    }

}