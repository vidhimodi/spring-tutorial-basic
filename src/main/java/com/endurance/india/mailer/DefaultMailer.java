package com.endurance.india.mailer;

public class DefaultMailer implements Mailer{

    @Override
    public void sendMail() {
        System.out.println("DefaulterMailer: Sent mail.");
    }

}