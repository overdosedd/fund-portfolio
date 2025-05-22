package com.example.mutualfundportfolio.dto;

import java.math.BigDecimal;

public class FundPositionDto {
    private String fundName;      // From mutual_funds table
    private BigDecimal units;
    private BigDecimal cashAmount;

    public FundPositionDto(String fundName, BigDecimal units, BigDecimal cashAmount) {
        this.fundName = fundName;
        this.units = units;
        this.cashAmount = cashAmount;
    }

    // Getters and setters
    public String getFundName() { return fundName; }
    public void setFundName(String fundName) { this.fundName = fundName; }

    public BigDecimal getUnits() { return units; }
    public void setUnits(BigDecimal units) { this.units = units; }

    public BigDecimal getCashAmount() { return cashAmount; }
    public void setCashAmount(BigDecimal cashAmount) { this.cashAmount = cashAmount; }
}
