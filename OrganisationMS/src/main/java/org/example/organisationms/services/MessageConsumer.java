package org.example.organisationms.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "charity.donation.queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Logique pour traiter le message
    }
}
