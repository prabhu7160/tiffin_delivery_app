package com.cdac.group4.tiffin.dtos;

import java.util.List;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
	private List<UserDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	
	private boolean lastPage;
	
	
}
