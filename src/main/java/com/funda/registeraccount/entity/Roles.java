package com.funda.registeraccount.entity;

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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    String id;
    String name;
    String description;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
}
