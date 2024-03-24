package tech.claudioed.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    public Long id;
    public BigDecimal amount;
    public String customerId;
    public String city;
    public LocalDateTime at;

}
