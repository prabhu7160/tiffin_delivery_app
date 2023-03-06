package com.cdac.group4.tiffin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.group4.tiffin.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
