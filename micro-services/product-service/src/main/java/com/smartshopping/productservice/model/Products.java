package com.smartshopping.productservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "pr_id")
	private int id;
	@NotNull
	@Column(name = "pr_product_name")
	private String productName;
	@NotNull
	@Column(name = "pr_product_type")
	private int productType;
	@NotNull
	@Column(name = "pr_brand")
	private String brand;
	@NotNull
	@Column(name = "pr_quantity_type")
	private long quantityType;
	@NotNull
	@Column(name = "pr_rate_per_quantity")
	private int ratePerQuantity;
	@NotNull
	@Column(name = "pr_stock_count")
	private int stockCount;
	@NotNull
	@Column(name = "pr_add_date")
	private Date addDate;
	@NotNull
	@Column(name = "pr_aisle")
	private String aisle;
	@NotNull
	@Column(name = "pr_shelf")
	private String shelf;
	@NotNull
	@Column(name = "pr_date_of_manufacture")
	private Date dateOfManufacture;
	@NotNull
	@Column(name = "pr_date_of_expiry")
	private Date dateOfExpiry;
	@NotNull
	@Column(name = "pr_product_image")
	private String image;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(@NotNull int id, @NotNull String productName, @NotNull int productType,
			@NotNull String brand, @NotNull long quantityType, @NotNull int ratePerQuantity,
			@NotNull int stockCount, @NotNull Date addDate, @NotNull String aisle, @NotNull String shelf,
			@NotNull Date dateOfManufacture, @NotNull Date dateOfExpiry, @NotNull String image) {
		super();
		this.id = id;
		this.productName = productName;
		this.productType = productType;
		this.brand = brand;
		this.quantityType = quantityType;
		this.ratePerQuantity = ratePerQuantity;
		this.stockCount = stockCount;
		this.addDate = addDate;
		this.aisle = aisle;
		this.shelf = shelf;
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public long getQuantityType() {
		return quantityType;
	}
	public void setQuantityType(long quantityType) {
		this.quantityType = quantityType;
	}
	public int getRatePerQuantity() {
		return ratePerQuantity;
	}
	public void setRatePerQuantity(int ratePerQuantity) {
		this.ratePerQuantity = ratePerQuantity;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAisle() {
		return aisle;
	}
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Products [id=" + id  + ", productName=" + productName + ", productType="
				+ productType + ", brand=" + brand + ", quantityType=" + quantityType + ", ratePerQuantity="
				+ ratePerQuantity + ", stockCount=" + stockCount + ", addDate=" + addDate + ", aisle=" + aisle
				+ ", shelf=" + shelf + ", dateOfManufacture=" + dateOfManufacture + ", dateOfExpiry=" + dateOfExpiry
				+ ", image=" + image + "]";
	}
	
	
}
