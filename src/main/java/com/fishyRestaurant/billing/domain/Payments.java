package com.fishyRestaurant.billing.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "accountNumber", nullable = false)
    private String accountNumber;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @OneToMany(targetEntity = Invoices.class)
    @Column(name = "invoices")
    private Set<Invoices> invoicesPaid;

    @Column(name = "paidOnDate", nullable = false)
    private OffsetDateTime paidOnDate;

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

    public Set<Invoices> getInvoicesPaid() {
        return invoicesPaid;
    }

    public void setInvoicesPaid(Set<Invoices> invoicesPaid) {
        this.invoicesPaid = invoicesPaid;
    }

    public OffsetDateTime getPaidOnDate() {
        return paidOnDate;
    }

    public void setPaidOnDate(OffsetDateTime paidOnDate) {
        this.paidOnDate = paidOnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Payments payment = (Payments) o;
        return Objects.equals(getId(), payment.getId())
          && Objects.equals(getAccountNumber(), payment.getAccountNumber())
          && Objects.equals(getAmount(), payment.getAmount())
          && Objects.equals(getInvoicesPaid(), payment.getInvoicesPaid())
          && Objects.equals(getPaidOnDate(), payment.getPaidOnDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountNumber(), getAmount(), getInvoicesPaid(), getPaidOnDate());
    }

    @Override
    public String toString() {
        return "Payment{ " +
          "id=" + getId() + '\'' +
          ", accountNumber=" + getAccountNumber() + '\'' +
          ", amount= " + getAmount() + '\'' +
          ", invoicesPaid= " + getInvoicesPaid() + '\'' +
          ", paidOnDate=" + getPaidOnDate() + '\'' +
          '}';
    }
}
