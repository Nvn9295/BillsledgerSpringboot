package com.example.billsledger.totalfunds.controller;

import com.example.billsledger.totalfunds.model.dto.TotalFundsDto;
import com.example.billsledger.totalfunds.service.TotalFundsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class TotalFundsController {
    private final TotalFundsService totalFundsService;

    @GetMapping("available-funds")
    private final TotalFundsDto getAvailableFunds() {
        return totalFundsService.getAvailableFunds();
    }
}
