package com.funda.registeraccount.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Component
public class RolesDTO {

    String id;
    String name;
    String description;
    @ManyToOne
    UserDTO user;
}
