package com.funda.registeraccount.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.funda.registeraccount.dto.UserDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String name;
    String description;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude@JsonBackReference
    User user;
}
