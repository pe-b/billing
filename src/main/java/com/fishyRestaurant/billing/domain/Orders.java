package com.fishyRestaurant.billing.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "accountNumber", nullable= false)
    private String accountNumber;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "invoiced", nullable = false)
    private boolean invoiced;

    @Column(name = "chargedDate", nullable = false)
    private OffsetDateTime chargedDate;

    public Orders() {}

    public Orders(String accountNumber, BigDecimal amount, boolean invoiced, OffsetDateTime chargedDate) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.invoiced = invoiced;
        this.chargedDate = chargedDate;
    }

}
