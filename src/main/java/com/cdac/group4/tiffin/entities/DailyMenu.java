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
@Table(name="DailyMenu")
@NoArgsConstructor
@Getter
@Setter
public class DailyMenu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="menu_id")
	private int menuId;
	@Column(name="tiffin_id")
	private int tiffinId;
	@Column(name="price")
	private double price;

}
