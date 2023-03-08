package com.cdac.group4.tiffin.services;

import java.util.List;

import com.cdac.group4.tiffin.dtos.VendorDto;

public interface VendorService {

	//create
	VendorDto createVendor(VendorDto vendorDto);
	//update
	VendorDto updateVendor(VendorDto vendorDto, Integer vendorId);
	//delete
	void  deleteVendor(Integer vendorId);
	//get
	VendorDto getVendorById(Integer vendorId);
	//get all
	List<VendorDto> getAllVendor();
}
