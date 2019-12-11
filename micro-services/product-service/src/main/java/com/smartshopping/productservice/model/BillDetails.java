package com.smartshopping.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "bill_details")
public class BillDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_d_id")
	int billDetailsId;
	
	@Column(name = "bill_b_id")
	int billId;
	
	@Column(name = "product_pr_id")
	int id;
	
	@Column(name = "quantity")
	int quantity;
	

	public BillDetails(int billId, int id, int quantity) {
		super();
		this.billId = billId;
		this.id = id;
		this.quantity = quantity;
		
	}

	public BillDetails(int billDetailsId, int billId, int id, int quantity) {
		super();
		this.billDetailsId = billDetailsId;
		this.billId = billId;
		this.id = id;
		this.quantity = quantity;
	
	}

	public BillDetails() {
		super();
	}


	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillDetails [billDetailsId=" + billDetailsId + ", billId=" + billId + ", id=" + id
				+ ", quantity=" + quantity + "]";
	}

	
	
	
}





















//@Entity
//@Table(name="bill_details")
//public class BillDetails {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull
//	@Column(name = "bill_id")
//	private int id;
//	@NotNull
//	@Column(name = "bill_b_id")
//	private int b_id;
//	@NotNull
//	@Column(name = "quantity")
//	private int quantity;
//	@NotNull
//	@Column(name = "product_pr_id")
//	private int productId;
//	public BillDetails() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public BillDetails(@NotNull int id, @NotNull int quantity) {
//		super();
//		this.id = id;
//		this.quantity = quantity;
//	}
//	public BillDetails(@NotNull int id, @NotNull int b_id, @NotNull int quantity,
//			@NotNull int productId) {
//		super();
//		this.id = id;
//		this.b_id = b_id;
//		this.quantity = quantity;
//		this.productId = productId;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public int getB_id() {
//		return b_id;
//	}
//	public void setB_id(int b_id) {
//		this.b_id = b_id;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	public int getProductId() {
//		return productId;
//	}
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//	@Override
//	public String toString() {
//		return "BillDetails [id=" + id + ", b_id=" + b_id + ", quantity=" + quantity
//				+ ", productId=" + productId + "]";
//	}
//	
//}
