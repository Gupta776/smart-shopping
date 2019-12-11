package com.smartshopping.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartshopping.productservice.model.Offer;
import com.smartshopping.productservice.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

//	Products findById(int id);
	@Query(nativeQuery = true, value = "SELECT * FROM offer WHERE DATE(of_date) = CURDATE()")
	public List<Offer> getCurrentOffer(); 
	
	@Query(nativeQuery = true, value = "select * from product INNER JOIN bill_Details ON (pr_id = product_pr_id) group by product_pr_id Order by sum(quantity) desc;")
	List<Products> getProductArray1();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product where pr_id not in (select pr_id from product INNER JOIN bill_details ON (pr_id = product_pr_id) group by product_pr_id Order by sum(quantity) desc);")
	List<Products> getProductArray2();
}
