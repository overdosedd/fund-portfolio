package com.example.mutualfundportfolio.controller;

import com.example.mutualfundportfolio.dto.PortfolioDto;
import com.example.mutualfundportfolio.dto.PortfolioSummaryDto;
import com.example.mutualfundportfolio.entity.FundPositions;
import com.example.mutualfundportfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<PortfolioSummaryDto> getPortfolio(
            @RequestParam(defaultValue = "SGD") String currency) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Long userId = portfolioService.getUserIdByEmail(email);

        List<PortfolioDto> portfolio = portfolioService.getPortfolio(userId, currency);
        double totalToday = portfolio.stream()
                .map(PortfolioDto::getCashAmount)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();

        // Fetch yesterday’s value (hardcoded or from DB for now)
        double totalYesterday = 2435.0;

        double dailyChange = totalToday - totalYesterday;
        double percentChange = (dailyChange / totalYesterday) * 100;

        PortfolioSummaryDto summary = new PortfolioSummaryDto(totalToday, dailyChange, percentChange, portfolio);
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/portfolio/summary")
    public ResponseEntity<Map<String, Object>> getPortfolioSummary() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()
                || authentication.getPrincipal().equals("anonymousUser")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String email = authentication.getName();

        Long userId = portfolioService.getUserIdByEmail(email);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found"));
        }

        double totalValue = portfolioService.calculateTotalValue(userId);
        double dailyChangeAmount = portfolioService.calculateDailyChangeAmount(userId);
        double dailyChangePercent = (dailyChangeAmount / (totalValue - dailyChangeAmount)) * 100;

        Map<String, Object> summary = new HashMap<>();
        summary.put("totalValue", totalValue);
        summary.put("dailyChangeAmount", dailyChangeAmount);
        summary.put("dailyChangePercent", dailyChangePercent);

        System.out.println("Authentication: " + authentication);
        System.out.println("Email from token: " + email);
        System.out.println("UserId from service: " + userId);

        return ResponseEntity.ok(summary);
    }

}