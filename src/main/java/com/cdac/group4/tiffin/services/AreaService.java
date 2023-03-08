package com.cdac.group4.tiffin.services;

import java.util.List;

import com.cdac.group4.tiffin.dtos.AreaDto;

public interface AreaService {

	AreaDto createArea(AreaDto areaDto);
	AreaDto getAreaById(String pincode);
	List<AreaDto> getAllArea();
	void deleteArea(String pincode);
	AreaDto updateArea(AreaDto areaDto, String pincode);
}
