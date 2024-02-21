package com.funda.registeraccount.service;

import com.funda.registeraccount.dto.UserDTO;
import com.funda.registeraccount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposotory extends JpaRepository<User,Long>{


}
