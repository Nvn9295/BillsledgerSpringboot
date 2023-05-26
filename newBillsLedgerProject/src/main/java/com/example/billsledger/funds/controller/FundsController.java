package com.example.billsledger.funds.controller;

import com.example.billsledger.funds.model.dto.FundsDto;
import com.example.billsledger.funds.service.FundsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FundsController {
    private final FundsService service;

    @PostMapping("/add-funds")
    private FundsDto addFunds(@RequestBody FundsDto fundsDto) {
        return service.saveFunds(fundsDto);
    }

    @GetMapping("/get-funds")
    private List<FundsDto> getFunds() {
        return service.getFunds();
    }

}
