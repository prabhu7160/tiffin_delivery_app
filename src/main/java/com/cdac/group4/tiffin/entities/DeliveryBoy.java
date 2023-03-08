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
@Table(name="Delivery_Boy")
@NoArgsConstructor
@Getter
@Setter
public class DeliveryBoy {
	
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int deliveryBoyId;
	@Column(name="name")
	private String deliveryBoyName;
	@Column(name="phone")
	private String deliveryBoyPhone;
	@Column(name="email")
	private String deliveryBoyEmail;

}
