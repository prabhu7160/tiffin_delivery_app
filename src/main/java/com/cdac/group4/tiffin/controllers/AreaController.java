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
import com.cdac.group4.tiffin.dtos.AreaDto;
import com.cdac.group4.tiffin.services.AreaService;

@RestController
@RequestMapping("/api/areas")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	//POST - to create an area
	@PostMapping("/")
	public ResponseEntity<AreaDto> createUser(@Valid @RequestBody AreaDto areaDto){
		
		AreaDto createAreaDto = this.areaService.createArea(areaDto);
		
		return new ResponseEntity<>(createAreaDto,HttpStatus.CREATED); 
		
	}
	
	//PUT - for updating user
	@PutMapping("/{pincode}")
	public ResponseEntity<AreaDto> updateUser(@RequestBody AreaDto areaDto, @PathVariable String pincode){
		
		//could also be like(,@PathVariable("userId") Integer anyId)
		
		AreaDto updatedArea= this.areaService.updateArea(areaDto,pincode);
		return ResponseEntity.ok(updatedArea);
		
	}
	
	//DELETE - for deleting user
	
	@DeleteMapping("/{pincode}")
	public ResponseEntity<ApiResponse> deleteArea(@PathVariable String pincode ){
		this.areaService.deleteArea(pincode);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Area deleted successfully",true), HttpStatus.OK);
	}
	
	//GET - get user data(all)
	
	@GetMapping("/")
	public ResponseEntity<List<AreaDto>> getAllAreas(){
		return ResponseEntity.ok(this.areaService.getAllArea());
	}
	
	//GET - get user data(from id)
	
	@GetMapping("/{pincode}")
	public ResponseEntity<AreaDto> getAreaById(@PathVariable String pincode){
		return ResponseEntity.ok(this.areaService.getAreaById(pincode));
		}

}
