package com.cdac.group4.tiffin.payloads;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty(message="Username cannot be empty")
	@Size(min=4, message="Username must be more than 4 characters")
	private String name;
	
	@Email(message="Email address is not valid!!")
	private String email;
	
	@NotEmpty
	private String pincode;
	private String street;
	private String houseName;
	private String roomNo;
	private String mobile;
	
	@NotEmpty
	@Size(min=3,max=10,message="Password must be min of 3 chars and max of 10 chars!")
	//@Pattern(regexp="")
	private String password;
	
}
