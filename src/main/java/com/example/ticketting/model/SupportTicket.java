package com.example.ticketting.model;


import com.example.ticketting.model.enums.Priority;
import com.example.ticketting.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SupportTicket extends BaseEntity{

    private Float price;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdatedDate;
    private LocalDateTime resolvedDate;
    private LocalDateTime closedDate;
    private Integer slaResponseTime;
    private Integer escalationReduction;
    private LocalDateTime escalationTimeLimit;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent currentAgent;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Agent manager;

    @OneToMany(mappedBy = "supportTicket")
    private Set<Message> ticketMessages;

    @OneToOne(mappedBy = "supportTicket")
    private Escalation escalation;

}
