package com.example.mutualfundportfolio.controller;

import com.example.mutualfundportfolio.dto.PortfolioDto;
import com.example.mutualfundportfolio.entity.FundPositions;
import com.example.mutualfundportfolio.entity.MutualFund;
import com.example.mutualfundportfolio.entity.User;
import com.example.mutualfundportfolio.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PortfolioController.class)
@Import(PortfolioControllerTest.class) // import the test config with mock bean
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PortfolioService portfolioService; // this is the mock injected manually

    @Test
    void testGetPortfolio() throws Exception {
        List<PortfolioDto> mockPositions = List.of(
                new PortfolioDto("FUND1", new BigDecimal("100.0"), new BigDecimal("2000.00")),
                new PortfolioDto("FUND2", new BigDecimal("50.0"), new BigDecimal("1500.00"))
        );

        when(portfolioService.getPortfolio(1L, "SGD")).thenReturn(mockPositions);

        mockMvc.perform(get("/portfolio")
                        .param("userId", "1")
                        .param("currency", "SGD"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].units").value(100.0))
                .andExpect(jsonPath("$[1].cashAmount").value(1500.00));
    }
}