package com.example.ticketting.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agent extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "currentAgent")
    private Set<SupportTicket> assignedTickets;

    @OneToMany(mappedBy = "manager")
    private Set<SupportTicket> managedTickets;
}
