package org.example.donationms;

import org.example.donationms.Repositories.DonationRepo;
import org.example.donationms.dto.Donation;
import org.example.donationms.model.Organisation;
import org.example.donationms.model.User;
import org.example.donationms.services.OrganisationRestClient;
import org.example.donationms.services.UserRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DonationMsApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(DonationMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
