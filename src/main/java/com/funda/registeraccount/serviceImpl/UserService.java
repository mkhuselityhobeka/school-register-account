package com.funda.registeraccount.serviceImpl;

import com.funda.registeraccount.dto.RolesDTO;
import com.funda.registeraccount.dto.UserDTO;
import com.funda.registeraccount.entity.Roles;
import com.funda.registeraccount.entity.User;
import com.funda.registeraccount.mapper.UserMapperImpl;
import com.funda.registeraccount.service.UserReposotory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        User user = userMapper.UserDTOtoUser(userDTO);
        List<Roles> roles = userMapper.RolesDTOtoRoles(userDTO.getRolesDTO());
        roles.forEach(role -> role.setUser(user));
        user.setRoles(roles);
        User createdUser = userReposotory.save(user);
        List<RolesDTO> rolesDTO = userMapper.RolestoRolesDTO(roles);
        userDTO = userMapper.UsertoUserDTO(createdUser);
        userDTO.setRolesDTO(rolesDTO);
        return userDTO;
    }

    /**
     *
     * @param username
     * @return userDto
     */
    public UserDTO findUserByUsername(String username){
        User user = userReposotory.findByUsername(username);
        List<Roles> roles = user.getRoles();
        if(user != null){
            List<RolesDTO> rolesDTOS = userMapper.RolestoRolesDTO(roles);
            UserDTO userDTO = userMapper.UsertoUserDTO(user);
            userDTO.setRolesDTO(rolesDTOS);
            return userDTO;
        }
        return null;
    }

    /**
     * @info update user details
     * @param userDTO
     * @return userDto
     */
    public UserDTO updateUser(UserDTO userDTO){

        User user = userReposotory.findByUsername(userDTO.getUsername());
        List<Roles> roles = user.getRoles();
        Long userId = user.getId();
        if(userId != null){
            user = userMapper.UserDTOtoUser(userDTO);
            user.setId(userId);
            User finalUser = user;
            user.setRoles(roles);
            user = userReposotory.save(user);
            List<RolesDTO> rolesDTO = userMapper.RolestoRolesDTO(roles);
            userDTO = userMapper.UsertoUserDTO(user);
            userDTO.setRolesDTO(rolesDTO);
            return userDTO;
        }

        return null;
    }

    /**
     * DELETE user account
     * @param id
     */
    public void removeUser(Long id){
        Optional<User> user = userReposotory.findById(id);
        if(user.isPresent()){
            User userToDelete = user.get();
            userReposotory.delete(userToDelete);
        }
    }

    /**
     *
     * @param status
     * @param id
     * @return UserDTO
     */
    public void updateStatus(String status, Long id){
        Optional<User> optional = userReposotory.findById(id);
        if(optional.isPresent()){
           userReposotory.updateUserStatus(status,id);

        }

    }


    /**
     *
     * @param pageable
     * @return
     */
    public Page<User> returnAllUsers(Pageable pageable){
        Page<User>users = userReposotory.findAll(pageable);
        return users;
    }

}
