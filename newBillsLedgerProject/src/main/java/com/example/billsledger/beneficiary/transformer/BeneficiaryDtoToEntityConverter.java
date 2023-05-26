package com.example.billsledger.beneficiary.transformer;

import com.example.billsledger.beneficiary.model.dto.BeneficiaryDto;
import com.example.billsledger.beneficiary.model.entity.Beneficiary;
import com.example.billsledger.transformer.AbstractCopyProperties;
import org.springframework.stereotype.Component;


@Component
public class BeneficiaryDtoToEntityConverter extends AbstractCopyProperties<BeneficiaryDto, Beneficiary> {

}
