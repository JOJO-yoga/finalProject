package com.example.finalproject.service;

import com.example.finalproject.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginService extends JpaRepository<user, Long> {
    public user findUserByName(String name);
}
