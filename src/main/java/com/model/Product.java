package com.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
//@Entity
@Component
public class Product {
	
	@NotEmpty(message = "Id is required")
	private String itemId;
	@NotEmpty(message = "Product name is required")
    private String itemName;
	@NotEmpty(message = "Product type is required")
    private String itemType;
	@NotNull
    private int itemPrice;
	@NotEmpty(message = "Product Desc is required")
    private String itemDesc;
	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", itemPrice="
				+ itemPrice + ", itemDesc=" + itemDesc + "]";
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	/*public Product(String itemId,
			 String itemName,
			 String itemType,int itemPrice,
			String itemDesc) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemDesc = itemDesc;
	}*/
}
