package com.example.mutualfundportfolio.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PortfolioDto {
    private String fundName;
    private BigDecimal units;
    private BigDecimal cashAmount;

    public PortfolioDto(String fundName, BigDecimal units, BigDecimal cashAmount) {
        this.fundName = fundName;
        this.units = units;
        this.cashAmount = cashAmount;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
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
