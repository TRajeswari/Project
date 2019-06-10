package com.raj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier
{
	@Id
	private int supplierId;
	@Column
	 private String supplierName;
	@Column
	private  String supplierDetails;
	@Column
	private String supplierAddress;
	
	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public void setSupplierId(int supplierId) 
	{
		this.supplierId = supplierId;
	}
	
	public int getSupplierId() 
	{
		return supplierId;
	}
	public void setSupplierName(String supplierName) 
	{
		this.supplierName = supplierName;
	}
	public String getSupplierName() 
	{
		return supplierName;
	}
	public void setSupplierDetails(String SupplierDetails) 
	{
		this.supplierDetails = supplierDetails;
	}
	
	
	public String getSupplierDetails()
	{
		return supplierDetails;
	}	
	
}
