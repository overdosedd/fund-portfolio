package com.example.mutualfundportfolio.controller;

import com.example.mutualfundportfolio.repository.CurrencyRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<String>> getCurrencies() {
        List<String> currencies = currencyRepository.findAllCurrencyCodes();
        return ResponseEntity.ok(currencies);
    }
}