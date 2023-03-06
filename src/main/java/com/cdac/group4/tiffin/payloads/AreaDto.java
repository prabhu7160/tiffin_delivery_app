package com.cdac.group4.tiffin.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AreaDto {

	private String pincode;
	private String city;
	private String state;
}
