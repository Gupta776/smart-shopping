package com.smartshopping.productservice.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartshopping.productservice.model.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	Users findByUserName(String userName);
	Users findByContactNumber(long contactNumber);
	//@Query(nativeQuery = true, value = "select sum(me_price) from menu_item left join cart on ct_pr_id = me_id where ct_us_id = :id")
	//public double getCartTotal(int id);
	
	@Query(nativeQuery= true, value="select * from user where us_status='P';")
	public List<Users> getAllAdmins();
	
	@Query(nativeQuery= true, value="select * from user where us_user_type='U';")
	public List<Users> getAllUsers();

	@Query(nativeQuery= true, value="select * from user where us_user_id= :userName")
	public Users getUserItem(String userName);
	
}