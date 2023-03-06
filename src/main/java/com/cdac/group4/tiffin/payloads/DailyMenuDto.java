package com.cdac.group4.tiffin.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DailyMenuDto {
	private int menuId;
	private int tiffinId;
	private double price;
}
