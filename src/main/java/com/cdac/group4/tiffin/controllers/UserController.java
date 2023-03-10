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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.group4.tiffin.dtos.ApiResponse;
import com.cdac.group4.tiffin.dtos.UserDto;
import com.cdac.group4.tiffin.dtos.UserResponse;
import com.cdac.group4.tiffin.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//POST - for creating user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto createUserDto = this.userService.createUser(userDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED); 
		
	}
	
	//PUT - for updating user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){
		
		//could also be like(,@PathVariable("userId") Integer anyId)
		
		UserDto updatedUser= this.userService.updateUser(userDto,userId);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	//DELETE - for deleting user
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId ){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully",true), HttpStatus.OK);
	}
	
	//GET - get user data(all)
	
	@GetMapping("/users")
	public ResponseEntity<UserResponse> getAllUsers(
		@RequestParam(value="pageNumber", defaultValue = "0", required = false) Integer pageNumber,
		@RequestParam(value="pageSize", defaultValue="10", required = false) Integer pageSize,
		@RequestParam(value="sortBy", defaultValue="userId",required = false) String sortBy)
	{
//		List<UserDto> allUser = this.userService.getAllUsers(pageNumber, pageSize);
//		return ResponseEntity.ok(this.userService.getAllUsers(pageNumber, pageSize));
		UserResponse userResponse = this.userService.getAllUsers(pageNumber, pageSize,sortBy);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	
	//GET - get user data(from id)
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
		}

}
