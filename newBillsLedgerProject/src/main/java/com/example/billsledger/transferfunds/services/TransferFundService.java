package com.example.billsledger.transferfunds.services;

import com.example.billsledger.totalfunds.model.entity.TotalFunds;
import com.example.billsledger.totalfunds.service.TotalFundsService;
import com.example.billsledger.transferfunds.model.dto.TransferFundsDto;
import com.example.billsledger.transferfunds.model.entity.TransferFund;
import com.example.billsledger.transferfunds.repository.TransferFundRepository;
import com.example.billsledger.transferfunds.transformer.TransferFundsDtoToEntityConverter;
import com.example.billsledger.transferfunds.transformer.TransferFundsEntityToDtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@AllArgsConstructor
@Service
public class TransferFundService {
    private final TransferFundRepository repository;
    private final TransferFundsDtoToEntityConverter transferFundsConverterDtoToEntity;
    private  final TransferFundsEntityToDtoConverter transferFundsConverterEntityToDto;
    private final TotalFundsService totalFundsService;

    public TransferFundsDto saveTransferFund(TransferFundsDto transferFundsDto) {
        List<TotalFunds> totalFunds = totalFundsService.getLastAvailableFunds();

        LocalDateTime dateTime = LocalDateTime.parse(transferFundsDto.getDate(), DateTimeFormatter.ISO_DATE_TIME);
        String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        transferFundsDto.setDate(formattedDate);
        transferFundsDto.setTransactionId(transferFundsDto.getDate() + transferFundsDto.getBeneficiary() + transferFundsDto.getBeneficiaryBank());
        TransferFund transferFund = transferFundsConverterDtoToEntity.dtoToEntity(transferFundsDto);
        TransferFundsDto transferFundsDtoToSave = new TransferFundsDto();
        if (transferFund.getAmount() != null && transferFund.getAmount() != 0 && transferFund.getAmount() >0 && transferFund.getAmount() <= totalFunds.get(0).getBankBalance()) {
            transferFundsDtoToSave = transferFundsConverterEntityToDto.entityToDto(repository.save(transferFund));
            TotalFunds totalFundsSave = new TotalFunds();
            totalFundsSave.setWalletBalance(transferFund.getAmount());
            totalFundsService.saveTotalFund(totalFundsSave);
        } else if (transferFund.getAmount() != null && transferFund.getAmount() > totalFunds.get(0).getBankBalance()) {
            transferFundsDtoToSave.setMessage("The amount " + transferFund.getAmount() + " is greater than the bank balance");
        } else if ((transferFund.getAmount() == 0)) {
            transferFundsDtoToSave.setMessage("The amount you entered is = " + transferFund.getAmount());
        }else if (transferFund.getAmount() <0){
            transferFundsDtoToSave.setMessage("The amount shouldn't be negative");
        }
        return transferFundsDtoToSave;
    }

    public List<TransferFundsDto> getTransferFunds() {
        return transferFundsConverterEntityToDto.entityToDto(repository.findAll());
    }

}
