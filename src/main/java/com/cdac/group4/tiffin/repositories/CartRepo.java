package com.cdac.group4.tiffin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.group4.tiffin.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}
