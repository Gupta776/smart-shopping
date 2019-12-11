package com.smartshopping.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopping.productservice.model.Bill;
import com.smartshopping.productservice.model.UserBill;
import com.smartshopping.productservice.model.Users;
import com.smartshopping.productservice.services.BillService;

@RestController
@RequestMapping("/smartshopping")
public class BillController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);
	
	@Autowired
	BillService billService;
	
	@GetMapping
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}
	
	@PostMapping("/bills")
	public void postBills(@RequestBody @Valid UserBill userBill ) {
		System.out.println("from front end");
		System.out.println(userBill);
		 billService.userBills(userBill);
	}
	
	@GetMapping("/bills/{userName}")
	public  List<Bill> getBillByBillId(@PathVariable String userName) {
		return billService.getBillByBillId(userName);
	}
	 
//
//	@GetMapping("/users/customers")
//	public List<Users> getAllCustomers() {
//		return userService.getAllCustomers();
//	}
//	
//	@GetMapping("/user-bills/{userId}")
//	public List<Bill> getUserBills(@PathVariable int userId){
//		return billService.getUserBills(userId);
//	}
	
}
