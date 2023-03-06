package com.cdac.group4.tiffin.payloads;

import com.cdac.group4.tiffin.entities.enums.TiffinTypeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TiffinTypeDto {

	private int typeId;
	private TiffinTypeEnum type;
}
