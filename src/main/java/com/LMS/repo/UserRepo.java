package com.LMS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LMS.model.Users;

public interface UserRepo extends JpaRepository<Users, Long> {

    Users findByRegno(String regno);
}
