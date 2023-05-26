package com.example.billsledger.banks.controller;

import com.example.billsledger.banks.model.dto.BanksDto;
import com.example.billsledger.banks.service.BanksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class BanksController {

    private final BanksService banksService;

    @PostMapping("/add-bank")
    private BanksDto addBank(@RequestBody BanksDto addBankDto) {

        return banksService.addBank(addBankDto);
    }

    @GetMapping("/get-banks")
    private List<BanksDto> getBanks() {
        return banksService.getBanks();
    }
}

