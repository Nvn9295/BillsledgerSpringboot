package com.example.billsledger.funds.transformer;

import com.example.billsledger.funds.model.dto.FundsDto;
import com.example.billsledger.funds.model.entity.Funds;
import com.example.billsledger.transformer.AbstractCopyProperties;
import org.springframework.stereotype.Component;


@Component
public class FundsEntityToDtoConverter extends AbstractCopyProperties<Funds,FundsDto> {
}
