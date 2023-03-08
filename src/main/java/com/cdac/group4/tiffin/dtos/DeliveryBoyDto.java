package com.cdac.group4.tiffin.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DeliveryBoyDto {
	
	
	private int deliveryBoyId;
	@NotEmpty(message="Deliver boy name cannot be empty")
	@NotNull(message="Deliver boy name cannot be null")
	private String deliveryBoyName;
	@NotNull(message="Deliver boy name cannot be null")
	@NotEmpty(message="Deliver boy name cannot be empty")
	private String deliveryBoyPhone;
	@Email(message="Enter proper email id")
	private String deliveryBoyEmail;
	
}
