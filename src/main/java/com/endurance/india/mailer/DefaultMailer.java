package com.endurance.india.mailer;

import org.springframework.stereotype.Component;

@Component
public class DefaultMailer implements Mailer{

    @Override
    public void sendMail() {
        System.out.println("DefaulterMailer: Sent mail.");
    }

}