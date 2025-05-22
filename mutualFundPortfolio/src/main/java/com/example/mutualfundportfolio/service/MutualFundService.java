package com.example.mutualfundportfolio.service;

import com.example.mutualfundportfolio.entity.MutualFund;
import com.example.mutualfundportfolio.repository.MutualFundRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MutualFundService {

    private final MutualFundRepository mutualFundRepository;

    public MutualFundService(MutualFundRepository mutualFundRepository) {
        this.mutualFundRepository = mutualFundRepository;
    }

    public List<MutualFund> getAllFunds() {
        return mutualFundRepository.findAll();
    }

    public Optional<MutualFund> getFundById(Long id) {
        return mutualFundRepository.findById(id);
    }

    public Optional<MutualFund> getFundByIsin(String isin) {
        return mutualFundRepository.findByIsin(isin);
    }

    public MutualFund createFund(MutualFund mutualFund) {
        return mutualFundRepository.save(mutualFund);
    }

    public MutualFund updateFund(Long id, MutualFund updatedFund) {
        return mutualFundRepository.findById(id)
                .map(existingFund -> {
                    existingFund.setName(updatedFund.getName());
                    existingFund.setIsin(updatedFund.getIsin());
                    existingFund.setCurrency(updatedFund.getCurrency());
                    return mutualFundRepository.save(existingFund);
                })
                .orElseThrow(() -> new RuntimeException("Mutual fund not found with id: " + id));
    }

    public void deleteFund(Long id) {
        mutualFundRepository.deleteById(id);
    }
}
