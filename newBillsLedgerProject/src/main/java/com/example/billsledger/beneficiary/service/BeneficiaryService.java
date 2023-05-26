package com.example.billsledger.beneficiary.service;

import com.example.billsledger.beneficiary.model.dto.BeneficiaryDto;
import com.example.billsledger.beneficiary.model.entity.Beneficiary;
import com.example.billsledger.beneficiary.repository.BeneficiaryRepository;
import com.example.billsledger.beneficiary.transformer.BeneficiaryDtoToEntityConverter;
import com.example.billsledger.beneficiary.transformer.BeneficiaryEntityToDtoConverter;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class BeneficiaryService {

    private final BeneficiaryRepository beneficiaryRepository;
    private BeneficiaryDtoToEntityConverter beneficiaryDtoToEntityConverter;
    private final BeneficiaryEntityToDtoConverter beneficiaryEntityToDtoConverter;

    public BeneficiaryDto addName(BeneficiaryDto beneficiaryDto) {
        BeneficiaryDto beneficiaryDtoToSave = new BeneficiaryDto();
        String userName = beneficiaryDto.getUserName();
        Long number = beneficiaryDto.getNumber();
        Beneficiary beneficiaryExistedUserName = beneficiaryRepository.findByUserName(userName);
        Beneficiary beneficiaryExistedNumber = beneficiaryRepository.findByNumber(number);
        if (beneficiaryExistedUserName != null){
            beneficiaryDto.setMessage("UserName is already exist");
            beneficiaryDtoToSave = beneficiaryDto;
        }else if(beneficiaryExistedNumber != null){
            beneficiaryDto.setMessage("Phone Number is already exist");
            beneficiaryDtoToSave = beneficiaryDto;
        }else {
            Beneficiary beneficiary = beneficiaryDtoToEntityConverter.dtoToEntity(beneficiaryDto);
            beneficiaryDtoToSave = beneficiaryEntityToDtoConverter.entityToDto(beneficiaryRepository.save(beneficiary));
        }
        return beneficiaryDtoToSave;
    }

    public List<BeneficiaryDto> getNames() {
        List<Beneficiary> beneficiaries = beneficiaryRepository.findAll();
        return beneficiaryEntityToDtoConverter.entityToDto(beneficiaries);
    }
}
