package org.example.donationms.services;

import org.example.donationms.model.Organisation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "OrganisationMS")
public interface OrganisationRestClient{

    @GetMapping("/Organisation")
    List<Organisation> getOrganisations();

    @GetMapping("Organisation/{id}")
    Organisation getOrganizationById(@PathVariable("id") Long id);
}


