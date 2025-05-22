package com.example.mutualfundportfolio.repository;

import com.example.mutualfundportfolio.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<CurrencyRate, Long> {

    // Custom query to fetch only the currency codes
    @Query("SELECT c.baseCurrency FROM CurrencyRate c")
    List<String> findAllCurrencyCodes();

    Optional<CurrencyRate> findByBaseCurrencyAndTargetCurrency(String baseCurrency, String targetCurrency);
}