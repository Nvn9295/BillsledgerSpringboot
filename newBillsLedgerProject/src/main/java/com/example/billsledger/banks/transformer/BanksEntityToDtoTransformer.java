package com.example.billsledger.banks.transformer;

import com.example.billsledger.banks.model.dto.BanksDto;
import com.example.billsledger.banks.model.entity.Banks;
import com.example.billsledger.transformer.AbstractCopyProperties;
import org.springframework.stereotype.Component;


@Component
public class BanksEntityToDtoTransformer extends AbstractCopyProperties<Banks,BanksDto> {

}
