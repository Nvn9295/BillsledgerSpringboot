package com.example.billsledger.transferfunds.controller;

import com.example.billsledger.totalfunds.service.TotalFundsService;
import com.example.billsledger.transferfunds.model.dto.TransferFundsDto;
import com.example.billsledger.transferfunds.services.TransferFundService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransferFundController {
    private final TransferFundService service;
    private final TotalFundsService totalFundsService;

    @PostMapping("/add-transfer-fund")
    private TransferFundsDto addTransferFund(@RequestBody TransferFundsDto transferFundsDto) {
        return service.saveTransferFund(transferFundsDto);
    }

    @GetMapping("/get-transfer-funds")
    private List<TransferFundsDto> getTransferFunds() {
        return service.getTransferFunds();
    }
}
