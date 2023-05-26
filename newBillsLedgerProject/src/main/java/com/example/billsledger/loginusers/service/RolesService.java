package com.example.billsledger.loginusers.service;

import com.example.billsledger.loginusers.model.dto.RolesDto;
import com.example.billsledger.loginusers.model.entity.Roles;
import com.example.billsledger.loginusers.repository.RolesRepository;
import com.example.billsledger.loginusers.transformer.RolesDtoToEntityConverter;
import com.example.billsledger.loginusers.transformer.RolesEntityToDtoConverter;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RolesService {

    private RolesRepository rolesRepository;
    private RolesEntityToDtoConverter rolesEntityToDtoConverter;
    private RolesDtoToEntityConverter rolesDtoToEntityConverter;

    public RolesDto saveRoles(RolesDto rolesDto) {
        Roles roles = rolesDtoToEntityConverter.dtoToEntity(rolesDto);
        RolesDto rolesDto1 = rolesEntityToDtoConverter.entityToDto(rolesRepository.save(roles));
        return rolesDto1;
    }

    public List<RolesDto> getRoles() {
        List<Roles> roles = rolesRepository.findAll();
        List<RolesDto> rolesDto = rolesEntityToDtoConverter.entityToDto(roles);
        return rolesDto;
    }
}
