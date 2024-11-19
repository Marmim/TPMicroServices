package org.example.organisationms.repositories;

import org.example.organisationms.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository

public interface OrganisationRepo  extends JpaRepository<Organisation, Long> {
}
