package com.cdac.group4.tiffin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.group4.tiffin.entities.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
