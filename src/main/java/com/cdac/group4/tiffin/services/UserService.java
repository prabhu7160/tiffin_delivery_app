package com.cdac.group4.tiffin.services;

import java.util.List;

import com.cdac.group4.tiffin.dtos.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
