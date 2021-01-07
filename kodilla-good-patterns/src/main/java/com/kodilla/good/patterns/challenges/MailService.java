package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService{
    @Override
    public void inform(User user) {
        System.out.println("Sending acceptance Email to: " + user.getUserName() + " " + user.getUserSurname());
    }
}
