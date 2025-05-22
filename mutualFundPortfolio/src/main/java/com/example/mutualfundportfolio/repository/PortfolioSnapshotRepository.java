package com.example.mutualfundportfolio.repository;

import com.example.mutualfundportfolio.entity.PortfolioSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PortfolioSnapshotRepository extends JpaRepository<PortfolioSnapshot, Long> {
    List<PortfolioSnapshot> findByUserIdAndDate(Long userId, LocalDate date);
    List<PortfolioSnapshot> findByUserId(Long userId);
}