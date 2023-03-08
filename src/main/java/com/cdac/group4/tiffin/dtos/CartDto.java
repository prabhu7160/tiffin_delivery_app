package com.cdac.group4.tiffin.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CartDto {
	private int cartId;
	private int tiffinId;
	private int userId;
}
