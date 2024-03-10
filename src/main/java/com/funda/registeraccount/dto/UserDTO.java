package com.funda.registeraccount.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@NoArgsConstructor@AllArgsConstructor
@Component
@Builder
public class UserDTO {

    Long id;
    String firstName;
    String lastName;
    String username;
    String password;
    String status;
    List<RolesDTO> rolesDTO;
}
