package com.example.billsledger.beneficiary.controller;

import com.example.billsledger.beneficiary.model.dto.BeneficiaryDto;
import com.example.billsledger.beneficiary.service.BeneficiaryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class BeneficiaryController {
    private final BeneficiaryService beneficiaryService;

    @PostMapping("/add-name")
    private BeneficiaryDto saveName(@RequestBody BeneficiaryDto beneficiaryDto) {
        return beneficiaryService.addName(beneficiaryDto);
    }

    @GetMapping("/get-names")
    private List<BeneficiaryDto> getNames() {
        return beneficiaryService.getNames();
    }

}
