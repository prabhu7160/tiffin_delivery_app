package com.cdac.group4.tiffin.services;

import java.util.List;

import com.cdac.group4.tiffin.dtos.DeliveryBoyDto;

public interface DeliveryBoyService {
	
	DeliveryBoyDto createDeliveryBoy(DeliveryBoyDto dboy);
	DeliveryBoyDto updateDeliveryBoy(DeliveryBoyDto dboy, Integer dboyId);
	DeliveryBoyDto getDeliveryBoyById(Integer dboyId);
	List<DeliveryBoyDto> getAllDeliveryBoy();
	void deleteDeliveryBoy(Integer dboyId);
}
