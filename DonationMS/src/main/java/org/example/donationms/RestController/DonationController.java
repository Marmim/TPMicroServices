package org.example.donationms.RestController;

import org.example.donationms.Repositories.DonationRepo;
import org.example.donationms.dto.Donation;
import org.example.donationms.model.Organisation;
import org.example.donationms.services.DonationService;
import org.example.donationms.services.OrganisationRestClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController( DonationService donationService) {
        this.donationService = donationService;

    }

    @PostMapping("/give")
    public ResponseEntity<String> giveDonation(@RequestBody Donation donationRequest) {
        String response = donationService.makeDonation(donationRequest);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/donorsOrganizations")
    public ResponseEntity<List<Map<String, Object>>> getDonorsWithOrganizations() {
        List<Map<String, Object>> donorsWithOrganizations = donationService.getDonorsWithOrganizations();
        return ResponseEntity.ok(donorsWithOrganizations);
    }
}


