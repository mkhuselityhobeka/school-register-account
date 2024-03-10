package com.funda.registeraccount.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class RolesDTO {

    Long id;
    String name;
    String description;
    UserDTO userDTO;
}
