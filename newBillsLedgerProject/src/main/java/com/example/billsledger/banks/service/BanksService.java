package com.example.billsledger.banks.service;

import com.example.billsledger.banks.model.dto.BanksDto;
import com.example.billsledger.banks.model.entity.Banks;
import com.example.billsledger.banks.repository.BanksRepository;
import com.example.billsledger.banks.transformer.BanksDtoToEntityTransformer;
import com.example.billsledger.banks.transformer.BanksEntityToDtoTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class BanksService {
    private BanksRepository banksRepository;
    private BanksDtoToEntityTransformer banksDtoToEntityConverter;
    private BanksEntityToDtoTransformer banksEntityToDtoConverter;

    public BanksDto addBank(BanksDto banksDto) {
        Banks banks =new Banks();
        BanksDto banksDtoToSave= new BanksDto();
        Banks addBank = banksDtoToEntityConverter.dtoToEntity(banksDto);
        banks=banksRepository.findBanksByBankName(addBank.getBankName());
        if (banks != null){
          banksDto.setMessage(banksDto.getBankName()+"is already exist");
        }
        else{
         banksDtoToSave = banksEntityToDtoConverter.entityToDto(banksRepository.save(addBank));
        }

        return banksDtoToSave;
    }

    public List<BanksDto> getBanks() {
        List<Banks> addBanks = banksRepository.findAll();
        return banksEntityToDtoConverter.entityToDto(addBanks);
    }

}
