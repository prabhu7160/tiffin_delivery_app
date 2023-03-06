package com.cdac.group4.tiffin.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	private String name;
	private String email;
	private String pincode;
	private String street;
	private String houseName;
	private String roomNo;
	private String mobile;
	
	
}
