package com.example.billsledger.loginusers.controller;

import com.example.billsledger.loginusers.model.dto.RolesDto;
import com.example.billsledger.loginusers.service.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class RolesController {

    private final RolesService rolesService;

    @PostMapping("/add-role")
    private RolesDto saveRoles(@RequestBody RolesDto rolesDto) {
        return rolesService.saveRoles(rolesDto);
    }

    @GetMapping("/get-roles")
    private List<RolesDto> getRoles() {
        return rolesService.getRoles();
    }
}
