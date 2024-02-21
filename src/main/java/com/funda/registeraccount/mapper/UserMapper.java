package com.funda.registeraccount.mapper;

import com.funda.registeraccount.dto.RolesDTO;
import com.funda.registeraccount.dto.UserDTO;
import com.funda.registeraccount.entity.Roles;
import com.funda.registeraccount.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User UserDTOtoUser(UserDTO userDTO);

    List<Roles> RolesDTOtoRoles(List<RolesDTO> rolesDTOS);

    UserDTO UsertoUserDTO(User user);

    List<RolesDTO> RolestoRolesDTO(List<Roles> roles);

}