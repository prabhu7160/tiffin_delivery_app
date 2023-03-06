package com.cdac.group4.tiffin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Tiffin")
@NoArgsConstructor
@Getter
@Setter
public class Tiffin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tiffin_id")
	private int tiffinId;
	@Column(name="type_id")
	private int typeId;
	@Column(name="vendor_id")
	private int vendorId;
	@Column(name="description")
	private String description;	
	private double price;
	private String image;


}
