package com.example.mutualfundportfolio.controller;

import com.example.mutualfundportfolio.entity.MutualFund;
import com.example.mutualfundportfolio.repository.MutualFundRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funds")
public class MutualFundController {

    private final MutualFundRepository mutualFundRepository;

    public MutualFundController(MutualFundRepository mutualFundRepository) {
        this.mutualFundRepository = mutualFundRepository;
    }

    // GET /api/funds - list all mutual funds
    @GetMapping
    public ResponseEntity<List<MutualFund>> getAllFunds() {
        return ResponseEntity.ok(mutualFundRepository.findAll());
    }

    // GET /api/funds/{id} - get one fund by ID
    @GetMapping("/{id}")
    public ResponseEntity<MutualFund> getFundById(@PathVariable Long id) {
        Optional<MutualFund> fund = mutualFundRepository.findById(id);
        return fund.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET /api/funds/isin/{isin} - get one fund by ISIN
    @GetMapping("/isin/{isin}")
    public ResponseEntity<MutualFund> getFundByIsin(@PathVariable String isin) {
        Optional<MutualFund> fund = mutualFundRepository.findByIsin(isin);
        return fund.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/funds - create a new mutual fund
    @PostMapping
    public ResponseEntity<MutualFund> createFund(@RequestBody MutualFund mutualFund) {
        MutualFund savedFund = mutualFundRepository.save(mutualFund);
        return ResponseEntity.ok(savedFund);
    }
}