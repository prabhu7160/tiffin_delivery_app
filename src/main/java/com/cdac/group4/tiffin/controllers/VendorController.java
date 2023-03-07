package com.cdac.group4.tiffin.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.group4.tiffin.payloads.ApiResponse;
import com.cdac.group4.tiffin.payloads.VendorDto;
import com.cdac.group4.tiffin.services.VendorService;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	//POST - for creating user
	@PostMapping("/")
	public ResponseEntity<VendorDto> createUser(@Valid @RequestBody VendorDto vendorDto){
		
		VendorDto createVendorDto = this.vendorService.createVendor(vendorDto);
		
		return new ResponseEntity<>(createVendorDto,HttpStatus.CREATED); 
		
	}
	
	//PUT - for updating user
	@PutMapping("/{vendorId}")
	public ResponseEntity<VendorDto> updateVendor(@RequestBody VendorDto vendorDto, @PathVariable Integer vendorId){
		
		//could also be like(,@PathVariable("vendorId") Integer anyId)
		
		VendorDto updatedVendor= this.vendorService.updateVendor(vendorDto,vendorId);
		return ResponseEntity.ok(updatedVendor);
		
	}
	
	//DELETE - for deleting user
	
	@DeleteMapping("/{vendorId}")
	public ResponseEntity<ApiResponse> deleteVendor(@PathVariable Integer vendorId ){
		this.vendorService.deleteVendor(vendorId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("vendor deleted successfully",true), HttpStatus.OK);
	}
	
	//GET - get user data(all)
	
	@GetMapping("/")
	public ResponseEntity<List<VendorDto>> getAllVendor(){
		return ResponseEntity.ok(this.vendorService.getAllVendor());
	}
	
	//GET - get user data(from id)
	
	@GetMapping("/{vendorId}")
	public ResponseEntity<VendorDto> getVendorById(@PathVariable Integer vendorId){
		return ResponseEntity.ok(this.vendorService.getVendorById(vendorId));
		}

}
