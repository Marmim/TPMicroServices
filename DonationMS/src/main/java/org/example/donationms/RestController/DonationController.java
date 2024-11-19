package org.example.donationms.RestController;

import org.example.donationms.Repositories.DonationRepo;
import org.example.donationms.dto.Donation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationRepo donationRepo;

    public DonationController(DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
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
