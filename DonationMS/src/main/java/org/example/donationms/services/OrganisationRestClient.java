package org.example.donationms.services;

import org.example.donationms.model.Organisation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "OrganisationMS")
public interface OrganisationRestClient{
    @GetMapping("/organisations/{id}")
    Organisation getOrganisationById(@PathVariable("id") int id);

    @GetMapping("/organisation")
    List<Organisation> getOrganisations();
}
