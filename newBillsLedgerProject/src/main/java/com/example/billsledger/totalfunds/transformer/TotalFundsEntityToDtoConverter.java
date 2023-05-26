package com.example.billsledger.totalfunds.transformer;

import com.example.billsledger.totalfunds.model.dto.TotalFundsDto;
import com.example.billsledger.totalfunds.model.entity.TotalFunds;
import com.example.billsledger.transformer.AbstractCopyProperties;

import org.springframework.stereotype.Component;


@Component
public class TotalFundsEntityToDtoConverter extends AbstractCopyProperties<TotalFunds,TotalFundsDto> {
}
