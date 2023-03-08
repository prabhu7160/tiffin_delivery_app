package com.cdac.group4.tiffin.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AreaDto {

	@NotNull
	private int areaId;
	@NotEmpty
	@NotBlank
	private String pincode;
	private String city;
	private String state;
}
