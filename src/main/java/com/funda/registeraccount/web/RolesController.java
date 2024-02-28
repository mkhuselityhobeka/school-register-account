package com.funda.registeraccount.web;


import com.funda.registeraccount.dto.RolesDTO;
import com.funda.registeraccount.serviceImpl.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
@RequiredArgsConstructor
public class RolesController {

    private final RolesService rolesService;

    @PostMapping("create/role")
    public RolesDTO createRole(@RequestBody RolesDTO rolesDTO){

        return new ResponseEntity<RolesDTO>(rolesService.creatsRoles(rolesDTO), HttpStatus.CREATED).getBody();
    }
}
