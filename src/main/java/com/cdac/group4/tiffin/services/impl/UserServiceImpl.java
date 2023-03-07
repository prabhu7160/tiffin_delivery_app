package com.cdac.group4.tiffin.services.impl;

import java.util.List;
import java.util.stream.Collectors;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cdac.group4.tiffin.entities.Users;
import com.cdac.group4.tiffin.exceptions.*;
import com.cdac.group4.tiffin.payloads.UserDto;
import com.cdac.group4.tiffin.repositories.UserRepo;
import com.cdac.group4.tiffin.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo; 
	
//	@Autowired
//	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		Users user = this.dtoToUser(userDto);	
		Users savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		Users user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","UserId",userId));
		
		user.setUserName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setStreetAddress(userDto.getStreet());
		user.setHouseName(userDto.getHouseName());
		user.setPincode(userDto.getPincode());
		user.setMobile(userDto.getMobile());
		user.setRoomNo(userDto.getRoomNo());
		
		Users updatedUser = this.userRepo.save(user);
		UserDto userDto1= this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		Users user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","UserId",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<Users> users= this.userRepo.findAll();
		List<UserDto> userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}
 
	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
		Users user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","UserId",userId));
		this.userRepo.delete(user);
	}
	
	private Users dtoToUser(UserDto userDto)
	{
		Users user = new Users();
		user.setUserId(userDto.getId());
		user.setUserName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setStreetAddress(userDto.getStreet());
		user.setHouseName(userDto.getHouseName());
		user.setPincode(userDto.getPincode());
		user.setMobile(userDto.getMobile());
		user.setRoomNo(userDto.getRoomNo());
		return user;
		
	}
	
	private UserDto userToDto(Users user)
	{
		UserDto userDto = new UserDto();
		userDto.setId(user.getUserId());
		userDto.setName(user.getUserName());
		userDto.setEmail(user.getEmail());
		userDto.setStreet(user.getStreetAddress());
		userDto.setHouseName(user.getHouseName());
		userDto.setPincode(user.getPincode());
		userDto.setMobile(user.getMobile());
		userDto.setRoomNo(user.getRoomNo());
		return userDto;
		
	}

}
