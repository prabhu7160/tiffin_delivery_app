package com.cdac.group4.tiffin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.group4.tiffin.entities.Area;

@Repository
public interface AreaRepo extends JpaRepository<Area, String> {

	 Area findByPincode(String pincode);
}
