package org.example.donationms.services;

import org.example.donationms.Repositories.DonationRepo;
import org.example.donationms.dto.Donation;
import org.example.donationms.model.Organisation;
import org.example.donationms.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DonationService {

    private final DonationRepo donationRepo;
    private final OrganisationRestClient organisationRestClient;
    private final UserRestClient userRestClient;

    public DonationService(DonationRepo donationRepo, OrganisationRestClient organizationClient, UserRestClient userRestClient) {
        this.donationRepo = donationRepo;
        this.organisationRestClient = organizationClient;
        this.userRestClient = userRestClient;
    }

    public String makeDonation(Donation donationRequest) {
        var organization =organisationRestClient.getOrganizationById(donationRequest.getOrganisationId());
        if (organization == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found");
        }

        Donation donation = new Donation();
        donation.setUserId(donationRequest.getUserId());
        donation.setOrganisationId(donationRequest.getOrganisationId());
        donation.setAmount(donationRequest.getAmount());
        donationRepo.save(donation);

        return "Donation successfully made to " + organization.getName();
    }

    public List<Map<String, Object>> getDonorsWithOrganizations() {
        List<Donation> donations = donationRepo.findAllWithOrganizations();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Donation donation : donations) {
            Map<String, Object> donorInfo = new HashMap<>();
            User user = userRestClient.getUserById(donation.getUserId());
            Organisation organization = organisationRestClient.getOrganizationById(donation.getOrganisationId());

            donorInfo.put("user", user);
            donorInfo.put("organization", organization);

            result.add(donorInfo);
        }

        return result;
    }
}
