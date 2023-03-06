package com.cdac.group4.tiffin.entities;

import java.sql.Time;
import java.time.LocalDate;

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
@Table(name="Order")
@NoArgsConstructor
@Getter
@Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;
	@Column(name="vendor_id")
	private int vendorId;
	@Column(name="user_id")
	private int userId;
	@Column(name="delivery_boy_id")
	private int deliveryBoyId;
	@Column(name="tiffin_id")
	private int tiffinId;
	@Column(name="date")
	private LocalDate date;
	@Column(name="time")
	private Time time;
	

}
