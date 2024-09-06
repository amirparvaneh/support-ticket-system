package com.example.ticketting.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Escalation extends BaseEntity{
    private LocalDateTime escalationDate;
    private Integer newResponseTimeLimit;

    @OneToOne
    @JoinColumn(name = "support_ticket_id")
    private SupportTicket supportTicket;
}
