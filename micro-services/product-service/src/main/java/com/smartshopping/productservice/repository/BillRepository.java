package com.smartshopping.productservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartshopping.productservice.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	@Query(nativeQuery = true, value = "select max(b_id) from bill;")
	int findMaximunBillId();
	@Query(nativeQuery = true, value = "select max(b_d_id) from bill_details;")
	int findMaximunBillDetailsId();
@Query(nativeQuery = true, value = "SELECT * FROM bill WHERE b_id = :id ;")
Optional<Bill> findByBillId(@Param("id") int id);


@Query(nativeQuery = true, value = "SELECT bill.* FROM bill INNER JOIN user on (bill.user_us_id = user.us_id) WHERE user.us_user_id = :userName ;")
List<Bill> getBill(@Param("userName") String userName);
}
