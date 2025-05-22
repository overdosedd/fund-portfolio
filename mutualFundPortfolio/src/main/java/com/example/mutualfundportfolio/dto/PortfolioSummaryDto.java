package com.example.mutualfundportfolio.dto;

import lombok.Data;

import java.util.List;
@Data
public class PortfolioSummaryDto {
    private double totalValue;
    private double dailyChangeAmount;
    private double dailyChangePercentage;
    private List<PortfolioDto> holdings;

    public PortfolioSummaryDto(double totalValue, double dailyChangeAmount, double dailyChangePercentage, List<PortfolioDto> holdings) {
        this.totalValue = totalValue;
        this.dailyChangeAmount = dailyChangeAmount;
        this.dailyChangePercentage = dailyChangePercentage;
        this.holdings = holdings;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getDailyChangeAmount() {
        return dailyChangeAmount;
    }

    public void setDailyChangeAmount(double dailyChangeAmount) {
        this.dailyChangeAmount = dailyChangeAmount;
    }

    public double getDailyChangePercentage() {
        return dailyChangePercentage;
    }

    public void setDailyChangePercentage(double dailyChangePercentage) {
        this.dailyChangePercentage = dailyChangePercentage;
    }

    public List<PortfolioDto> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<PortfolioDto> holdings) {
        this.holdings = holdings;
    }

}