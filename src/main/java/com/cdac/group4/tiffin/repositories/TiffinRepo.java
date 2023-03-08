package com.cdac.group4.tiffin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.group4.tiffin.entities.Tiffin;

@Repository
public interface TiffinRepo extends JpaRepository<Tiffin, Integer> {

}
