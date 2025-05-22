package com.example.mutualfundportfolio.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fund_positions")
public class FundPositions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fund_id")
    private MutualFund mutualFund;

    @Column(name = "units", precision = 18, scale = 6)
    private BigDecimal units;

    @Column(name = "cash_amount", precision = 18, scale = 2)
    private BigDecimal cashAmount;


    public FundPositions(Long id, User user, MutualFund mutualFund, BigDecimal units, BigDecimal cashAmount) {
        this.id = id;
        this.user = user;
        this.mutualFund = mutualFund;
        this.units = units;
        this.cashAmount = cashAmount;
    }
    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MutualFund getMutualFund() {
        return mutualFund;
    }

    public void setMutualFund(MutualFund mutualFund) {
        this.mutualFund = mutualFund;
    }

    public BigDecimal getUnits() {
        return units;
    }

    public void setUnits(BigDecimal units) {
        this.units = units;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }
}