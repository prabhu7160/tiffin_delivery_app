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
@Table(name="Area")
@NoArgsConstructor
@Getter
@Setter
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pincode;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	
}
