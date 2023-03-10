package com.cdac.group4.tiffin.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="area")
@NoArgsConstructor
@Getter
@Setter
public class Area {
	
	
	
	@Column(name="area_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int areaId;
	@Column(name="pincode",unique=true,length=30)
	@Id
	private String pincode;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	
	@OneToMany(mappedBy="area",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Vendor> vendors = new ArrayList<>();
	
}
