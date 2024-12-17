package org.example.donationms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.example.donationms.dto.Donation;

import java.util.List;

@Data
public class Organisation {
    private Long id;

    private String name;
    private String description;
    private String address;
    private String date;


}
