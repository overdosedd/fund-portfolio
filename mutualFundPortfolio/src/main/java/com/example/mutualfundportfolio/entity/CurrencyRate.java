package com.example.mutualfundportfolio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "currency_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_currency", length = 3)
    private String baseCurrency;

    @Column(name = "target_currency", length = 3)
    private String targetCurrency;

    @Column(name = "rate", precision = 18, scale = 6)
    private BigDecimal rate;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
