package com.example.mutualfundportfolio.repository;

import com.example.mutualfundportfolio.entity.FundPositions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FundPositionsRepository extends JpaRepository<FundPositions, Long> {
    List<FundPositions> findByUserId(Long userId);
}
