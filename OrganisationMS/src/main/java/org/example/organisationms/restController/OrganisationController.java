package org.example.organisationms.restController;

import org.example.organisationms.entities.Organisation;
import org.example.organisationms.repositories.OrganisationRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganisationController {

    private OrganisationRepo organisationRepo;

    public OrganisationController(OrganisationRepo organisationRepo) {
        this.organisationRepo = organisationRepo;
    }

    @GetMapping("/Organisation")
    public List<Organisation> OrganisationList() {
        return organisationRepo.findAll();

    }

    @GetMapping("/Organisation/{id}")
    public Organisation Organisations(@PathVariable Long id) {
        return organisationRepo.findById(id).get();


    }

    @PostMapping("/Organisation/save")
    public Organisation SaveOrganisation(@RequestBody Organisation organisation) {
        return  organisationRepo.save(organisation);
    }

}
