package com.example.billsledger.funds.service;

import com.example.billsledger.funds.model.dto.FundsDto;
import com.example.billsledger.funds.model.entity.Funds;
import com.example.billsledger.funds.repository.FundsRepository;
import com.example.billsledger.funds.transformer.FundsDtoToEntityConverter;
import com.example.billsledger.funds.transformer.FundsEntityToDtoConverter;
import com.example.billsledger.totalfunds.model.entity.TotalFunds;
import com.example.billsledger.totalfunds.service.TotalFundsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FundsService {
    public FundsRepository repository;
    public FundsDtoToEntityConverter fundsConverterDtoToEntity;
    public FundsEntityToDtoConverter fundsConverterEntityToDto;
    public TotalFundsService totalFundsService;


    public FundsDto saveFunds(FundsDto fundsDto) {
        Funds funds = fundsConverterDtoToEntity.dtoToEntity(fundsDto);
        FundsDto fundsDtoToSave = new FundsDto();

        if (fundsDto.getAmount() > 0) {
            fundsDtoToSave = fundsConverterEntityToDto.entityToDto(repository.save(funds));
            TotalFunds totalFunds = new TotalFunds();
            totalFunds.setBankBalance(fundsDto.getAmount());
            totalFunds.setSource(fundsDto.getSource());
            totalFundsService.saveTotalFund(totalFunds);
        }
        return fundsDtoToSave;
    }

    public List<FundsDto> getFunds() {
        return fundsConverterEntityToDto.entityToDto(repository.findAll());
    }

}
