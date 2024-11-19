package org.example.donationms.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
     @Id
    @GeneratedValue

    private Long id;
    private String donorName;
    private Double amount;
    private Long organisationId;
}
