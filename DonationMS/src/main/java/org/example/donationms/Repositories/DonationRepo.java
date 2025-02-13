package org.example.donationms.Repositories;

import org.example.donationms.dto.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationRepo extends JpaRepository<Donation, Long> {

    @Query("SELECT d FROM Donation d WHERE d.organisationId IS NOT NULL")
    List<Donation> findAllWithOrganizations();

}
