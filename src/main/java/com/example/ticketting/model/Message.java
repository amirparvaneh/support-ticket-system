package com.example.ticketting.model;


import com.example.ticketting.model.enums.SenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message extends BaseEntity{
    private String message;
    private LocalDateTime timestamp;
    @Enumerated(EnumType.STRING)
    private SenderType senderType;

    @ManyToOne
    @JoinColumn(name = "support_ticket_id")
    private SupportTicket supportTicket;
}
