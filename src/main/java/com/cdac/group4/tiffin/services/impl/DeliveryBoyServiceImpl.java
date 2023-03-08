package com.cdac.group4.tiffin.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.group4.tiffin.dtos.DeliveryBoyDto;
import com.cdac.group4.tiffin.entities.DeliveryBoy;
import com.cdac.group4.tiffin.exceptions.ResourceNotFoundException;
import com.cdac.group4.tiffin.repositories.DeliveryBoyRepo;
import com.cdac.group4.tiffin.services.DeliveryBoyService;

@Service
public class DeliveryBoyServiceImpl implements DeliveryBoyService {

	@Autowired
	private DeliveryBoyRepo dboyRepo;
	@Override
	public DeliveryBoyDto createDeliveryBoy(DeliveryBoyDto dboyDto) {
		// TODO Auto-generated method stub
		DeliveryBoy dboy = this.dtoToDeliveryBoy(dboyDto);
		DeliveryBoy savedDboy = this.dboyRepo.save(dboy);
		return this.deliveryBoyToDto(savedDboy);
	}

	@Override
	public DeliveryBoyDto updateDeliveryBoy(DeliveryBoyDto dboyDto, Integer dboyId) {
		// TODO Auto-generated method stub
		DeliveryBoy dboy=this.dboyRepo.findById(dboyId).orElseThrow(()->new ResourceNotFoundException("DeliveryBoy","dboyId",dboyId));
		
		dboy.setDeliveryBoyId(dboyDto.getDeliveryBoyId());
		dboy.setDeliveryBoyName(dboyDto.getDeliveryBoyName());
		dboy.setDeliveryBoyEmail(dboyDto.getDeliveryBoyEmail());
		dboy.setDeliveryBoyPhone(dboyDto.getDeliveryBoyPhone());
		
		DeliveryBoy updatedDboy = this.dboyRepo.save(dboy);
		DeliveryBoyDto updatedDboyDto = this.deliveryBoyToDto(updatedDboy);
		return updatedDboyDto;
	}

	@Override
	public DeliveryBoyDto getDeliveryBoyById(Integer dboyId) {
		// TODO Auto-generated method stub
		DeliveryBoy dboy = this.dboyRepo.findById(dboyId).orElseThrow(()->new ResourceNotFoundException("DeliveryBoy","dboyId",dboyId));
		
		return this.deliveryBoyToDto(dboy);
	}

	@Override
	public List<DeliveryBoyDto> getAllDeliveryBoy() {
		// TODO Auto-generated method stub
		List<DeliveryBoy> dboys = this.dboyRepo.findAll();
		List<DeliveryBoyDto> dboysDto = dboys.stream().map(dboy->this.deliveryBoyToDto(dboy)).collect(Collectors.toList());
		return dboysDto;
	}

	@Override
	public void deleteDeliveryBoy(Integer dboyId) {
		// TODO Auto-generated method stub
		
		DeliveryBoy dboy = this.dboyRepo.findById(dboyId).orElseThrow(()->new ResourceNotFoundException("DeliveryBoy","dboyId",dboyId));
		
		this.dboyRepo.delete(dboy);

	}
	private DeliveryBoy dtoToDeliveryBoy(DeliveryBoyDto dboyDto)
	{
		DeliveryBoy dboy = new DeliveryBoy();
		dboy.setDeliveryBoyId(dboyDto.getDeliveryBoyId());
		dboy.setDeliveryBoyName(dboyDto.getDeliveryBoyName());
		dboy.setDeliveryBoyEmail(dboyDto.getDeliveryBoyEmail());
		dboy.setDeliveryBoyPhone(dboyDto.getDeliveryBoyPhone());
		return dboy;
		
	}
	
	private DeliveryBoyDto deliveryBoyToDto(DeliveryBoy dboy)
	{
		DeliveryBoyDto dboyDto = new DeliveryBoyDto();
		dboyDto.setDeliveryBoyId(dboy.getDeliveryBoyId());
		dboyDto.setDeliveryBoyName(dboy.getDeliveryBoyName());
		dboyDto.setDeliveryBoyEmail(dboy.getDeliveryBoyEmail());
		dboyDto.setDeliveryBoyPhone(dboy.getDeliveryBoyPhone());
		return dboyDto;
		
	}
	/*
	 * private int deliveryBoyId;
	@NotEmpty(message="Deliver boy name cannot be empty")
	@NotNull(message="Deliver boy name cannot be null")
	private String deliveryBoyName;
	@NotNull(message="Deliver boy name cannot be null")
	@NotEmpty(message="Deliver boy name cannot be empty")
	private String deliveryBoyPhone;
	@Email(message="Enter proper email id")
	private String deliveryBoyEmail;
	 */

}
