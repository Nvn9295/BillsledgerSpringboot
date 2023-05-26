package com.example.billsledger.transferfunds.transformer;

import com.example.billsledger.transferfunds.model.dto.TransferFundsDto;
import com.example.billsledger.transferfunds.model.entity.TransferFund;
import com.example.billsledger.transformer.AbstractCopyProperties;

import org.springframework.stereotype.Component;


@Component
public class TransferFundsDtoToEntityConverter extends AbstractCopyProperties<TransferFundsDto,TransferFund> {
}