package org.example.donationms.Repositories;

import org.example.donationms.dto.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepo extends JpaRepository<Donation, Long> {
    List<Donation> findByOrganisationId(Long organisationId);
}
