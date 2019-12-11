package com.smartshopping.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartshopping.authenticationservice.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	Users findByUserName(String userName);

	//@Query(nativeQuery = true, value = "select sum(me_price) from menu_item left join cart on ct_pr_id = me_id where ct_us_id = :id")
	//public double getCartTotal(int id);
}