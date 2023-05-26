package com.example.billsledger.transferfunds.transformer;

import com.example.billsledger.transferfunds.model.dto.TransferFundsDto;
import com.example.billsledger.transferfunds.model.entity.TransferFund;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransferFundsEntityToDtoConverter {
    public TransferFundsDto entityToDto(TransferFund transferFund) {
        TransferFundsDto transferFundsDto = new TransferFundsDto();
        BeanUtils.copyProperties(transferFund, transferFundsDto);
        transferFundsDto.setTransactionId(transferFund.getTransactionId() + transferFund.getId());
        return transferFundsDto;

    }

    public List<TransferFundsDto> entityToDto(List<TransferFund> transferFunds) {
        return transferFunds.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

}
