package com.funda.registeraccount.mapper;

import com.funda.registeraccount.dto.RolesDTO;
import com.funda.registeraccount.entity.Roles;
import org.mapstruct.Mapper;

@Mapper
public interface RolesMapper {

     Roles RolesDTOtoRoles(RolesDTO rolesDTO);
     RolesDTO RolestoRolesDTO(Roles roles);
}
