package com.cdac.group4.tiffin.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.group4.tiffin.dtos.AreaDto;
import com.cdac.group4.tiffin.entities.Area;
import com.cdac.group4.tiffin.exceptions.ResourceNotFoundException;
import com.cdac.group4.tiffin.repositories.AreaRepo;
import com.cdac.group4.tiffin.services.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaRepo areaRepo;
	@Override
	public AreaDto createArea(AreaDto areaDto) {
		// TODO Auto-generated method stub
		Area area = this.dtoToArea(areaDto);	
		Area savedArea = this.areaRepo.save(area);
		return this.areaToDto(savedArea);
	}

	@Override
	public AreaDto updateArea(AreaDto areaDto, String pincode) {
		// TODO Auto-generated method stub
		Area uarea = this.areaRepo.findById(pincode).orElseThrow(()-> new ResourceNotFoundException("Area","AreaId",pincode));
		uarea.setPincode(areaDto.getPincode());;
		uarea.setCity(areaDto.getCity());
		uarea.setState(areaDto.getState());
		
		Area updatedArea = this.areaRepo.save(uarea);
		AreaDto updatedAreaDto = this.areaToDto(updatedArea);
		return updatedAreaDto;
		
	}

	@Override
	public AreaDto getAreaById(String pincode) {
		// TODO Auto-generated method stub
		Area area = this.areaRepo.findById(pincode).orElseThrow(()-> new ResourceNotFoundException("Area","AreaId",pincode));
		return this.areaToDto(area);
	}

	@Override
	public List<AreaDto> getAllArea() {
		// TODO Auto-generated method stub
		List<Area> areaList = this.areaRepo.findAll();
		List<AreaDto> areaDtos= areaList.stream().map(area->this.areaToDto(area)).collect(Collectors.toList());
		return areaDtos;
	}

	@Override
	public void deleteArea(String pincode) {
		// TODO Auto-generated method stub
		Area area = this.areaRepo.findById(pincode).orElseThrow(()-> new ResourceNotFoundException("Area","AreaId",pincode));
		this.areaRepo.delete(area);
	}
	
	private Area dtoToArea(AreaDto areaDto)
	{
		Area area = new Area();
//		area.setAreaId(areaDto.getAreaId());
		area.setPincode(areaDto.getPincode());;
		area.setCity(areaDto.getCity());
		area.setState(areaDto.getState());
		
		return area;
		
	}
	
	private AreaDto areaToDto(Area area)
	{
		AreaDto areaDto = new AreaDto();
//		areaDto.setAreaId(area.getAreaId());
		areaDto.setPincode(area.getPincode());
		areaDto.setCity(area.getCity());
		areaDto.setState(area.getState());
		return areaDto;
		
	}

}
