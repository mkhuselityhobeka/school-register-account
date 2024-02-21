package com.funda.registeraccount.serviceImpl;

import com.funda.registeraccount.dto.UserDTO;
import com.funda.registeraccount.entity.Roles;
import com.funda.registeraccount.entity.User;
import com.funda.registeraccount.mapper.UserMapperImpl;
import com.funda.registeraccount.service.UserReposotory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReposotory userReposotory;
    private final UserMapperImpl userMapper;
    private UserDTO userDTO;

    /**
     * create new user account
     * @return userDTO
     ***/
    public UserDTO createAccount(UserDTO userDTO){
        this.userDTO = userDTO;
        User user = userMapper.UserDTOtoUser(userDTO);
        List<Roles> roles = userMapper.RolesDTOtoRoles(userDTO.getRolesDTO());
        roles.forEach(role -> role.setUser(user));
        user.setRoles(roles);
        User createdUser = userReposotory.save(user);
        userDTO = userMapper.UsertoUserDTO(createdUser);
        return userDTO;
    }
}
