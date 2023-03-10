package com.cdac.group4.tiffin.services;

import java.util.List;

import com.cdac.group4.tiffin.dtos.UserDto;
import com.cdac.group4.tiffin.dtos.UserResponse;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy);
	void deleteUser(Integer userId);
}
