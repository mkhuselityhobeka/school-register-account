package com.funda.registeraccount.serviceImpl;

import com.funda.registeraccount.dto.RolesDTO;
import com.funda.registeraccount.entity.Roles;
import com.funda.registeraccount.entity.User;
import com.funda.registeraccount.mapper.RolesMapper;
import com.funda.registeraccount.mapper.RolesMapperImpl;
import com.funda.registeraccount.mapper.UserMapper;
import com.funda.registeraccount.mapper.UserMapperImpl;
import com.funda.registeraccount.service.RolesRepository;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    RolesRepository rolesRepository;
    RolesMapperImpl rolesMapper;
    UserMapperImpl userMapper;
    public RolesService(RolesRepository rolesRepository,RolesMapperImpl rolesMapper,UserMapperImpl userMapper){
        this.rolesRepository=rolesRepository;
        this.rolesMapper = rolesMapper;
        this.userMapper = userMapper;

    }

    public RolesDTO creatsRoles(RolesDTO rolesDTO){
        Roles roles = rolesMapper.RolesDTOtoRoles(rolesDTO);
        User user = userMapper.UserDTOtoUser(rolesDTO.getUserDTO());
        roles.setUser(user);
        roles = rolesRepository.save(roles);
        rolesDTO = rolesMapper.RolestoRolesDTO(roles);
        return rolesDTO;
    }

}
