package com.fishyRestaurant.billing.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isInvoiced() {
        return invoiced;
    }

    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }

    public OffsetDateTime getChargedDate() {
        return chargedDate;
    }

    public void setChargedDate(OffsetDateTime chargedDate) {
        this.chargedDate = chargedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Orders order = (Orders) o;
        return Objects.equals(getId(), order.getId())
          && Objects.equals(getAccountNumber(), order.getAccountNumber())
          && Objects.equals(getAmount(), order.getAmount())
          && Objects.equals(getChargedDate(), order.getChargedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountNumber(), getAmount(), getChargedDate());
    }

    @Override
    public String toString() {
        return "Order{ " +
          "id=" + getId() + '\'' +
          ", accountNumber=" + getAccountNumber() + '\'' +
          ", amount= " + getAmount() + '\'' +
          ", chargedDate=" + getChargedDate() + '\'' +
          '}';
    }


}
