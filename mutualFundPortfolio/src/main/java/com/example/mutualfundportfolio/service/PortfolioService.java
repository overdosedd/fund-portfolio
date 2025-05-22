package com.example.mutualfundportfolio.service;

import com.example.mutualfundportfolio.dto.PortfolioDto;
import com.example.mutualfundportfolio.dto.PortfolioSummaryDto;
import com.example.mutualfundportfolio.entity.FundPositions;
import com.example.mutualfundportfolio.entity.PortfolioSnapshot;
import com.example.mutualfundportfolio.repository.FundPositionsRepository;
import com.example.mutualfundportfolio.repository.PortfolioSnapshotRepository;
import com.example.mutualfundportfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.example.mutualfundportfolio.entity.User;
@Service
public class PortfolioService {
    @Autowired
    private FundPositionsRepository repo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PortfolioSnapshotRepository snapshotRepository;


    public List<PortfolioDto> getPortfolio(Long userId, String currency) {
        List<FundPositions> positions = repo.findByUserId(userId);
        List<PortfolioDto> response = new ArrayList<>();

        for (FundPositions pos : positions) {
            String fundName = pos.getMutualFund().getName();
            response.add(new PortfolioDto(fundName, pos.getUnits(), pos.getCashAmount()));
        }

        return response;
    }

    public Long getUserIdByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(User::getId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public double calculateTotalValue(Long userId) {
        List<FundPositions> positions = repo.findByUserId(userId);

        // Sum cashAmount for all positions
        return positions.stream()
                .map(FundPositions::getCashAmount)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
    }

    // Calculate daily change amount (today value - yesterday value)
    public double calculateDailyChangeAmount(Long userId) {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        double todayValue = calculateTotalValue(userId);

        // Fetch yesterday snapshot
        List<PortfolioSnapshot> yesterdaySnapshots = snapshotRepository.findByUserIdAndDate(userId, yesterday);
        double yesterdayValue = yesterdaySnapshots.stream()
                .map(PortfolioSnapshot::getTotalValue)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();

        return todayValue - yesterdayValue;
    }
}
