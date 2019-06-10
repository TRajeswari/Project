package com.raj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart
{
@Id	
int cartId;
@Column
int productId;
@Column
String productName;


@Column
int productPrice;
@Column
String productSupplier;
@Column
int productQuantity;
@Column
int total;

public void setCartId(int cartId)
{
	this.cartId = cartId;
}

public int getCartId()
{
	return cartId;
}
public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public int getProductPrice() {
	return productPrice;
}

public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}

public String getProductSupplier() {
	return productSupplier;
}

public void setProductSupplier(String productSupplier) {
	this.productSupplier = productSupplier;
}

public int getProductQuantity() {
	return productQuantity;
}

public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}
public int getTotal()
{
	return total;
}

public void setTotal(int total)
{
	this.total = total;
}



}
