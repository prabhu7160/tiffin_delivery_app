package com.cdac.group4.tiffin.dtos;


import java.sql.Time;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
	private int orderId;
	private int vendorId;
	private int userId;
	private int tiffinId;
	private int deliveryBoyId;
	private LocalDate date;
	private Time time;

}
