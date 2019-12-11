package com.smartshopping.productservice.model;

import java.util.Date;
import java.util.List;

public class UserBill {
	private int userId;
	private float originalAmount;
	private float totalAmount;
	private Date purchaseDate;
	private List<ProductList> productList;
	private int rewardPoints;
	private int finalRewardPoints;
	
	public UserBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBill(int userId, float originalAmount, float totalAmount, Date purchaseDate,
			List<ProductList> productList, int rewardPoints, int finalRewardPoints) {
		super();
		this.userId = userId;
		this.originalAmount = originalAmount;
		this.totalAmount = totalAmount;
		this.purchaseDate = purchaseDate;
		this.productList = productList;
		this.rewardPoints = rewardPoints;
		this.finalRewardPoints = finalRewardPoints;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public List<ProductList> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductList> productList) {
		this.productList = productList;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
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

	@Override
	public String toString() {
		return "UserBill [userId=" + userId + ", originalAmount=" + originalAmount + ", totalAmount=" + totalAmount
				+ ", purchaseDate=" + purchaseDate + ", productList=" + productList + ", rewardPoints=" + rewardPoints
				+ ", finalRewardPoints=" + finalRewardPoints + "]";
	}

//	@Override
//	public String toString() {
//		return "UserBill [userId=" + userId + ", totalAmount=" + totalAmount + ", purchaseDate=" + purchaseDate
//				+ ", productList=" + productList + ", rewardPoints=" + rewardPoints + "]";
//	}
	
	
	
}
