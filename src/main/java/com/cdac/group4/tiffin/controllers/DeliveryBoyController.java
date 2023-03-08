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

import com.cdac.group4.tiffin.dtos.ApiResponse;
import com.cdac.group4.tiffin.dtos.DeliveryBoyDto;
import com.cdac.group4.tiffin.services.DeliveryBoyService;

@RestController
@RequestMapping("api/deliveryBoys")
public class DeliveryBoyController {
	
	@Autowired
	private DeliveryBoyService dboyService;
	
	//POST - for creating user
	@PostMapping("/")
	public ResponseEntity<DeliveryBoyDto> createDeliveryBoy(@Valid @RequestBody DeliveryBoyDto dboyDto){
		
		DeliveryBoyDto createDboyDto = this.dboyService.createDeliveryBoy(dboyDto);
		
		return new ResponseEntity<>(createDboyDto,HttpStatus.CREATED); 
		
	}
	
	//PUT - for updating user
	@PutMapping("/{dboyId}")
	public ResponseEntity<DeliveryBoyDto> updateDeliveryBoy(@RequestBody DeliveryBoyDto dboyDto, @PathVariable Integer dboyId){
		
		//could also be like(,@PathVariable("userId") Integer anyId)
		
		DeliveryBoyDto updatedDboy= this.dboyService.updateDeliveryBoy(dboyDto,dboyId);
		return ResponseEntity.ok(updatedDboy);
		
	}
	
	//DELETE - for deleting user
	
	@DeleteMapping("/{dboyId}")
	public ResponseEntity<ApiResponse> deleteDeliveryBoy(@PathVariable Integer dboyId ){
		this.dboyService.deleteDeliveryBoy(dboyId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Delivery Boy deleted successfully",true), HttpStatus.OK);
	}
	
	//GET - get user data(all)
	
	@GetMapping("/")
	public ResponseEntity<List<DeliveryBoyDto>> getAllDeliveryBoy(){
		return ResponseEntity.ok(this.dboyService.getAllDeliveryBoy());
	}
	
	//GET - get user data(from id)
	
	@GetMapping("/{dboyId}")
	public ResponseEntity<DeliveryBoyDto> getDeliveryBoyById(@PathVariable Integer dboyId){
		return ResponseEntity.ok(this.dboyService.getDeliveryBoyById(dboyId));
		}	

}
