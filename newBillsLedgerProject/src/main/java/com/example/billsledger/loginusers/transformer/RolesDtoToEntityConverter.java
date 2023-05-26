package com.example.billsledger.loginusers.transformer;

import com.example.billsledger.loginusers.model.dto.RolesDto;
import com.example.billsledger.loginusers.model.entity.Roles;
import com.example.billsledger.transformer.AbstractCopyProperties;
import org.springframework.stereotype.Component;

@Component
public class RolesDtoToEntityConverter extends AbstractCopyProperties<RolesDto,Roles> {
}
