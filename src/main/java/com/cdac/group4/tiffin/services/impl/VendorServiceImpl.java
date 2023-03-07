package com.cdac.group4.tiffin.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.group4.tiffin.entities.Vendor;
import com.cdac.group4.tiffin.exceptions.ResourceNotFoundException;
import com.cdac.group4.tiffin.payloads.VendorDto;
import com.cdac.group4.tiffin.repositories.VendorRepo;
import com.cdac.group4.tiffin.services.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepo vendorRepo;
	
	
	@Override
	public VendorDto createVendor(VendorDto vendorDto) {
		// TODO Auto-generated method stub
		Vendor vendor = this.dtoToVendor(vendorDto);
		Vendor savedVendor = this.vendorRepo.save(vendor);
		return this.vendorToDto(savedVendor);
	}

	@Override
	public VendorDto updateVendor(VendorDto vendorDto, Integer vendorId) {
		// TODO Auto-generated method stub
		Vendor vendor = this.vendorRepo.findById(vendorId).orElseThrow(()-> new ResourceNotFoundException("Vendor","VendorId",vendorId));
//		vendor.setVendorId(vendorDto.getVendorId());
		vendor.setVendorName(vendorDto.getVendorName());
		vendor.setMobile(vendorDto.getMobile());
		vendor.setEmail(vendorDto.getEmail());
		vendor.setPincode(vendorDto.getPincode());
		vendor.setPassword(vendorDto.getPassword());
		vendor.setGstNo(vendorDto.getGstNo());
		vendor.setAddress(vendorDto.getAddress());
		
		Vendor updatedVendor = this.vendorRepo.save(vendor);
		VendorDto updatedVendorDto = this.vendorToDto(updatedVendor);
		return updatedVendorDto;
	}

	@Override
	public void deleteVendor(Integer vendorId) {
		// TODO Auto-generated method stub
		Vendor deleteVendor = this.vendorRepo.findById(vendorId).orElseThrow(()-> new ResourceNotFoundException("Vendor","VendorId",vendorId));
		this.vendorRepo.delete(deleteVendor);
	}

	@Override
	public VendorDto getVendorById(Integer vendorId) {
		// TODO Auto-generated method stub
		Vendor getVendorById = this.vendorRepo.findById(vendorId).orElseThrow(()-> new ResourceNotFoundException("Vendor","VendorId",vendorId));
		return this.vendorToDto(getVendorById);
	}

	@Override
	public List<VendorDto> getAllVendor() {
		// TODO Auto-generated method stub
		List<Vendor> vendors= this.vendorRepo.findAll();
		List<VendorDto> vendorDtos= vendors.stream().map(vendor->this.vendorToDto(vendor)).collect(Collectors.toList());
		return vendorDtos;
	}
	
	private Vendor dtoToVendor(VendorDto vendorDto)
	{
		Vendor vendor = new Vendor();
		vendor.setVendorId(vendorDto.getVendorId());
		vendor.setVendorName(vendorDto.getVendorName());
		vendor.setMobile(vendorDto.getMobile());
		vendor.setEmail(vendorDto.getEmail());
		vendor.setPincode(vendorDto.getPincode());
		vendor.setPassword(vendorDto.getPassword());
		vendor.setGstNo(vendorDto.getGstNo());
		vendor.setAddress(vendorDto.getAddress());
		return vendor;
		
	}
	
	private VendorDto vendorToDto(Vendor vendor)
	{
		VendorDto vendorDto = new VendorDto();
		vendorDto.setVendorId(vendor.getVendorId());
		vendorDto.setVendorName(vendor.getVendorName());
		vendorDto.setMobile(vendor.getMobile());
		vendorDto.setEmail(vendor.getEmail());
		vendorDto.setPincode(vendor.getPincode());
		vendorDto.setPassword(vendor.getPassword());
		vendorDto.setGstNo(vendor.getGstNo());
		vendorDto.setAddress(vendor.getAddress());
		return vendorDto;
		
	}
	/*
	 * private int menuId;
	@NotNull
	private String vendorName;
	@NotNull
	@NotEmpty
	private String mobile;
	@Email
	private String email;
	@NotEmpty
	@Size(min=3,message="password cannot be smaller than 3 chars!")
	private String password;
	private String pincode;
	private String gstNo;
	private String street;
	private String address;
	 */

}
