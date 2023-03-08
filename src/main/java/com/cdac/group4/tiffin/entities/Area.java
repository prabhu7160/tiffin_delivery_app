package com.cdac.group4.tiffin.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(unique=true)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int areaId;
	@Column(name="pincode",unique=true)
	private String pincode;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	
	@OneToMany(mappedBy = "area")
    private List<Vendor> vendors;
	
}
