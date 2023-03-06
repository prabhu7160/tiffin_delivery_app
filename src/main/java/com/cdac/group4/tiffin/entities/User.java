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
@Table(name="User")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int userId;
	
	@Column(name="user_name", nullable=false, length=50, unique=true)
	private String userName;
	@Column(name="email", nullable=false, length=50,unique=true)
	private String email;
	@Column(name="mobile", length=20,unique=true)
	private String mobile;
	@Column(name="pincode", nullable=false, length=20)
	private String pincode;
	@Column(name="street" ,length=100)
	private String streetAddress;
	@Column(name="house_name", length=50)
	private String houseName;
	@Column(name="room_no", length=40)
	private String roomNo;
	
}
