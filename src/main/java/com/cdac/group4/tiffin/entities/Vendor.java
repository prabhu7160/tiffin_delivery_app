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
@Table(name="Vendors")
@NoArgsConstructor
@Getter
@Setter
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendor_id")
	private int vendorId;
	@Column(name="menu_id")
	private int menuId;
	@Column(name="vendor_name")
	private String vendorName;
	private String mobile;
	private String email;
	private String pincode;
	@Column(name="gst_number4")
	private String gstNo;	

}
