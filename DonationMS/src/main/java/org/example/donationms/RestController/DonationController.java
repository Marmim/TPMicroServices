package org.example.donationms.RestController;

import org.example.donationms.Repositories.DonationRepo;
import org.example.donationms.dto.Donation;
import org.example.donationms.services.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {
    @Autowired
    private MessageProducer messageProducer;

    private final DonationRepo donationRepo;
    public DonationController(DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
    }

    @PostMapping("/donate")
    public String donate(@RequestParam String donationDetails) {
        messageProducer.sendDonationMessage(donationDetails);
        return "Donation message sent: " + donationDetails;
    }
    @GetMapping
    public List<Donation> getAllDonations() {
        return donationRepo.findAll();
    }

    @GetMapping("/organisation/{organisationId}")
    public List<Donation> getDonationsByOrganisation(@PathVariable Long organisationId) {
        return donationRepo.findByOrganisationId(organisationId);
    }

    @PostMapping("/save")
    public Donation createDonation(@RequestBody Donation donation) {
        return donationRepo.save(donation);
    }
}
