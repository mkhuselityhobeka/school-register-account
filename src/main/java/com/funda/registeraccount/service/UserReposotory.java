package com.funda.registeraccount.service;

import com.funda.registeraccount.dto.UserDTO;
import com.funda.registeraccount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
;import javax.transaction.Transactional;

@Repository
public interface UserReposotory extends JpaRepository<User,Long>{

    User findByUsername(String username);

    /**
     * updating the status user attribute
     * @param status
     * @return
     */


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("Update User u SET u.status = :status WHERE u.id = :id")
    void updateUserStatus(String status,Long id);
}
