package com.example.ticketting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {
    private String code;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "customer")
    private Set<SupportTicket> supportTickets;
}
