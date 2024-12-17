package org.example.donationms.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.donationms.model.Organisation;
import org.example.donationms.model.User;

import java.util.Collection;


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
    private Long userId;
    private Long organisationId;
    @Transient
    private Organisation organisation;
    @Transient
    private User users;

}