package com.smartshopping.productservice.model;





import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
	int id;
	@Column(name = "b_purchase_date")
	Date purchaseDate;
	@Column(name = "b_total_amount", columnDefinition = "DECIMAL(8,2)")
	float totalAmount;
	@Column(name = "b_reward_points")
	int rewardPoints;
	@Column(name = "b_original_amount", columnDefinition = "DECIMAL(8,2)")
	float originalAmount;
	@Column(name = "b_final_reward_points")
	int finalRewardPoints;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "bill_details", joinColumns = @JoinColumn(name = "bill_b_id"), inverseJoinColumns = @JoinColumn(name = "product_pt_code"))
//	private List<Product> productList;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_us_id", nullable = false)
    Users user;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bill_b_id")
	private List<BillDetails> billDetailsList;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public Bill(int id, Date purchaseDate, float totalAmount, int rewardPoints, float originalAmount,
			int finalRewardPoints) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.totalAmount = totalAmount;
		this.rewardPoints = rewardPoints;
		this.originalAmount = originalAmount;
		this.finalRewardPoints = finalRewardPoints;
	}




	public Bill(int id, Date purchaseDate, float totalAmount, int rewardPoints, float originalAmount,
			int finalRewardPoints, Users user) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.totalAmount = totalAmount;
		this.rewardPoints = rewardPoints;
		this.originalAmount = originalAmount;
		this.finalRewardPoints = finalRewardPoints;
		this.user = user;
	}




	public float getOriginalAmount() {
		return originalAmount;
	}




	public void setOriginalAmount(float originalAmount) {
		this.originalAmount = originalAmount;
	}




	public int getFinalRewardPoints() {
		return finalRewardPoints;
	}




	public void setFinalRewardPoints(int finalRewardPoints) {
		this.finalRewardPoints = finalRewardPoints;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}


	public List<BillDetails> getBillDetailsList() {
		return billDetailsList;
	}


	public void setBillDetailsList(List<BillDetails> billDetailsList) {
		this.billDetailsList = billDetailsList;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}




	@Override
	public String toString() {
		return "Bill [id=" + id + ", purchaseDate=" + purchaseDate + ", totalAmount=" + totalAmount + ", rewardPoints="
				+ rewardPoints + ", originalAmount=" + originalAmount + ", finalRewardPoints=" + finalRewardPoints
				+ ", user=" + user + ", billDetailsList=" + billDetailsList + "]";
	}


//	@Override
//	public String toString() {
//		return "Bill [id=" + id + ", purchaseDate=" + purchaseDate + ", totalAmount=" + totalAmount + ", rewardPoints="
//				+ rewardPoints + ", user=" + user + ", billDetailsList=" + billDetailsList + "]";
//	}

	


	
}

//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Table(name="bill")
//public class Bill {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull
//	@Column(name = "b_id")
//	private int id;
//	@NotNull
//	@Column(name = "b_purchase_date")
//	private Date purchaseDate;
//	@NotNull
//	@Column(name = "b_total_amount")
//	private int totalAmount;
//	@NotNull
//	@Column(name = "b_reward_points")
//	private int rewardPoints;
//	
//	@ManyToOne
//	@JoinColumn(name="user_us_id")
//	private Users user;
//	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "bill_details",
//	joinColumns = @JoinColumn(name = "bill_b_id"), 
//	inverseJoinColumns = @JoinColumn(name = "product_pr_id"))
//	private List<Products> product;
//	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name="bill_b_id")
//	List<BillDetails> billDetails;
//
//	public Bill() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Bill(@NotNull int id, @NotNull Date purchaseDate, @NotNull int totalAmount, @NotNull int rewardPoints) {
//		super();
//		this.id = id;
//		this.purchaseDate = purchaseDate;
//		this.totalAmount = totalAmount;
//		this.rewardPoints = rewardPoints;
//	}
//
//	public Bill(@NotNull int id, @NotNull Date purchaseDate, @NotNull int totalAmount, @NotNull int rewardPoints,
//			Users user, List<Products> product, List<BillDetails> billDetails) {
//		super();
//		this.id = id;
//		this.purchaseDate = purchaseDate;
//		this.totalAmount = totalAmount;
//		this.rewardPoints = rewardPoints;
//		this.user = user;
//		this.product = product;
//		this.billDetails = billDetails;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Date getPurchaseDate() {
//		return purchaseDate;
//	}
//
//	public void setPurchaseDate(Date purchaseDate) {
//		this.purchaseDate = purchaseDate;
//	}
//
//	public int getTotalAmount() {
//		return totalAmount;
//	}
//
//	public void setTotalAmount(int totalAmount) {
//		this.totalAmount = totalAmount;
//	}
//
//	public int getRewardPoints() {
//		return rewardPoints;
//	}
//
//	public void setRewardPoints(int rewardPoints) {
//		this.rewardPoints = rewardPoints;
//	}
//
//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}
//
//	public List<Products> getProduct() {
//		return product;
//	}
//
//	public void setProduct(List<Products> product) {
//		this.product = product;
//	}
//
//	public List<BillDetails> getBillDetails() {
//		return billDetails;
//	}
//
//	public void setBillDetails(List<BillDetails> billDetails) {
//		this.billDetails = billDetails;
//	}
//
//	@Override
//	public String toString() {
//		return "Bill [id=" + id + ", purchaseDate=" + purchaseDate + ", totalAmount=" + totalAmount + ", rewardPoints="
//				+ rewardPoints + ", user=" + user + ", product=" + product + ", billDetails=" + billDetails + "]";
//	}
//	
//	
//	
//}
