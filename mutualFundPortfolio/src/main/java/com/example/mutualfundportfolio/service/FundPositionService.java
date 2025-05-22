package com.example.mutualfundportfolio.service;
import com.example.mutualfundportfolio.dto.FundPositionDto;
import com.example.mutualfundportfolio.entity.FundPositions;
import com.example.mutualfundportfolio.entity.MutualFund;
import com.example.mutualfundportfolio.repository.FundPositionsRepository;
import com.example.mutualfundportfolio.repository.MutualFundRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FundPositionService {
    private static final Logger log = LoggerFactory.getLogger(FundPositionService.class);
    private final FundPositionsRepository fundPositionRepository;
    private final MutualFundRepository mutualFundRepository;

    public FundPositionService(FundPositionsRepository fundPositionRepository,
                               MutualFundRepository mutualFundRepository) {
        this.fundPositionRepository = fundPositionRepository;
        this.mutualFundRepository = mutualFundRepository;
    }

    public List<FundPositionDto> getPositionsByUserId(Long userId) {
        List<FundPositions> positions = fundPositionRepository.findByUserId(userId);
        log.info("position", positions);

        // Fetch all mutual funds involved to get names
        List<Long> fundIds = positions.stream()
                .map(FundPositions::getId)
                .distinct()
                .collect(Collectors.toList());

        Map<Long, String> fundIdToName = mutualFundRepository.findAllById(fundIds).stream()
                .collect(Collectors.toMap(MutualFund::getId, MutualFund::getName));

        // Map positions to DTOs
        return positions.stream()
                .map(pos -> new FundPositionDto(
                        fundIdToName.getOrDefault(pos.getId(), "Unknown Fund"),
                        pos.getUnits(),
                        pos.getCashAmount()
                ))
                .collect(Collectors.toList());
    }
}