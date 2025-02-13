//package org.example.organisationms.kafka;
//
//import jakarta.jms.Message;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrganisationProducer {
//
//
//        private final KafkaTemplate<String, String> kafkaTemplate;
//
//        public OrganisationProducer(KafkaTemplate<String, String> kafkaTemplate) {
//            this.kafkaTemplate = kafkaTemplate;
//        }
//
//        // Méthode pour envoyer un message
//        public void sendMessage(Message message) {
//            kafkaTemplate.send("thing1", message.toString()); // Envoie un message au topic "organization-topic"
//            System.out.println("Message envoyé : " + message); // Affiche le message dans la console
//        }
//
//    }
