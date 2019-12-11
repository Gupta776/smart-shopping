package com.smartshopping.productservice.services;

import java.util.List;

import javax.validation.Valid;

import com.smartshopping.productservice.model.Bill;
import com.smartshopping.productservice.model.UserBill;

public interface BillService {
	public List<Bill> getAllBills();

	public void userBills(@Valid UserBill userBill);

	public  List<Bill> getBillByBillId(String userName);
}
