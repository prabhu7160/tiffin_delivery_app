package com.cdac.group4.tiffin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.group4.tiffin.entities.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Integer> {

}
