package com.funda.registeraccount.entity;

import com.funda.registeraccount.dto.RolesDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



@NoArgsConstructor@Setter@Getter
@AllArgsConstructor
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String username;
    String password;
    String status;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "id",
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @ToString.Exclude// exclude lazy attributes
    List<Roles> roles = new ArrayList<>();

    /*helper meothods to both sides of association in synce*/
    public void addRoles(Roles roles){
        this.roles.add(roles);
        roles.setUser(this);

    }
    public void removeRole(Roles roles){
        roles.setUser(null);
        this.roles.remove(roles);

    }
    public void removeRoles(){
        Iterator <Roles> iterator = this.roles.iterator();
        while(iterator.hasNext()){
            Roles role = iterator.next();
            role.setUser(null);
            iterator.remove();

        }
    }
}
