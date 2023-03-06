package com.cdac.group4.tiffin.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class VendorDto {

	private int vendorId;
	private int menuId;
	private String vendorName;
	private String mobile;
	private String email;
	private String pincode;
	private String gstNo;
	
}
