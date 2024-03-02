package com.funda.registeraccount.service;

import com.funda.registeraccount.entity.Roles;
import com.funda.registeraccount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {


}
