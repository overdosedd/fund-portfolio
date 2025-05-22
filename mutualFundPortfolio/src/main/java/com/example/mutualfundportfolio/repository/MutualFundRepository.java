package com.example.mutualfundportfolio.repository;

import com.example.mutualfundportfolio.entity.MutualFund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MutualFundRepository extends JpaRepository<MutualFund, Long> {

    // Optional custom method to find a fund by its ISIN code
    Optional<MutualFund> findByIsin(String isin);
}