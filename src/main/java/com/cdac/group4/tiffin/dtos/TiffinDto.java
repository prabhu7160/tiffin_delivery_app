package com.cdac.group4.tiffin.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TiffinDto {
	private int tiffinId;
	private int typeId;
	private String desc;
	private double price;
	private String image;
	private int vendorId;

}
