package com.example.billsledger.expenses.model.dto;


import jakarta.servlet.Registration;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Data
public class ExpensesDto {
    private Long id;
    private String date;
    private String transactionDetails;
    private Double amount;
    private String expensesCategory;
    private String source;
    private String spentBy;
    private Long billReceipt;
    private String message;
}

//@Component
//public class RegistrationConverter{
//    public Registration dtoToEntity(RegistrationDto registrationDto){
//        Registration registration = new Registration();
//        registration.setEmailId(registrationDto.getEmailId());
//        registration.setPassword(registrationDto.getPassword());
//        BeanUtils.copyProperties(registrationDto,registration);
//        return registration;
//    }
//
//
//    public List<Registration> dtoToEntity (List<RegistrationDto> registrationDtoList){
//        return registrationDtoList.stream().map( x -> registrationDtoList(x)).collect(Collectors.toList());
//    }
//}






// Transformer is used to convert data from entity to dto and dto to entity


