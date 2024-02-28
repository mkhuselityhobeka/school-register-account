package com.funda.registeraccount.serviceImpl;

import com.funda.registeraccount.dto.RolesDTO;
import com.funda.registeraccount.dto.UserDTO;
import com.funda.registeraccount.entity.Roles;
import com.funda.registeraccount.entity.User;
import com.funda.registeraccount.mapper.UserMapperImpl;
import com.funda.registeraccount.service.UserReposotory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserReposotory userReposotory;
    private final UserMapperImpl userMapper;


    /**
     * create new user account
     * @return userDTO
     ***/
    public UserDTO createAccount(UserDTO userDTO){
        log.debug("userDTO is {}",userDTO);
        User user = userMapper.UserDTOtoUser(userDTO);
        log.debug("user is {}",user);
        List<Roles> roles = userMapper.RolesDTOtoRoles(userDTO.getRolesDTO());
        roles.forEach(role -> role.setUser(user));
        user.setRoles(roles);
        User createdUser = userReposotory.save(user);
        List<RolesDTO> rolesDTO = userMapper.RolestoRolesDTO(roles);
        log.debug("createdUser is {}",createdUser);
        userDTO = userMapper.UsertoUserDTO(createdUser);
        userDTO.setRolesDTO(rolesDTO);
        return userDTO;
    }

}
