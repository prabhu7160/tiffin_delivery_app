package com.cdac.group4.tiffin.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class VendorDto {

	private int vendorId;
	private int menuId;
	@NotEmpty(message="name cannot be empty")
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
	
}
