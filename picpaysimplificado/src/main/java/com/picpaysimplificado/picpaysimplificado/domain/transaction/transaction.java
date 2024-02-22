package com.picpaysimplificado.picpaysimplificado.domain.transaction;


import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal amount;

    @JoinColumn(name = "sender_id")
    @ManyToOne
    private User sender;

    @JoinColumn(name = "receiver_id")
    @ManyToOne
    private User receiver;

    private LocalDateTime dateTime;

}
