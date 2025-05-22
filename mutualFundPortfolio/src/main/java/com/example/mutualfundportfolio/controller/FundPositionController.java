package com.example.mutualfundportfolio.controller;
import com.example.mutualfundportfolio.dto.FundPositionDto;
import com.example.mutualfundportfolio.service.FundPositionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fund-position")
public class FundPositionController {

    private final FundPositionService fundPositionService;

    public FundPositionController(FundPositionService fundPositionService) {
        this.fundPositionService = fundPositionService;
    }

    @GetMapping("/positions/{userId}")
    public List<FundPositionDto> getUserPositions(@PathVariable Long userId) {
        return fundPositionService.getPositionsByUserId(userId);
    }
    }