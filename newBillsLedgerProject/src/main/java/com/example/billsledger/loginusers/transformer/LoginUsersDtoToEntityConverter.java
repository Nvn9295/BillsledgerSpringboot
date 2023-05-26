package com.example.billsledger.loginusers.transformer;

import com.example.billsledger.loginusers.model.dto.LoginUsersDto;
import com.example.billsledger.loginusers.model.entity.LoginUsers;
import com.example.billsledger.transformer.AbstractCopyProperties;
import org.springframework.stereotype.Component;

@Component
public class LoginUsersDtoToEntityConverter extends AbstractCopyProperties<LoginUsersDto, LoginUsers> {
}
