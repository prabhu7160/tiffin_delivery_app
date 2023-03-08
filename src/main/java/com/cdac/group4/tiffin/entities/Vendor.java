package com.cdac.group4.tiffin.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vendor_id", unique=true)
	private int vendorId;
	@Column(name="menu_id")
	private int menuId;
	@Column(name="vendor_name")
	private String vendorName;
	@Column(unique=true)
	private String mobile;
	@Column(unique=true)
	private String email;
	private String password;
	
	private String pincode;
	@Column(name="gst_number",unique=true)
	private String gstNo;
	private String street;
	private String address;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pincode", referencedColumnName = "pincode", insertable = false, updatable = false)
    private Area area;

}
