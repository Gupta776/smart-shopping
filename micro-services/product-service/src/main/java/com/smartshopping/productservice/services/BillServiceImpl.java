package com.smartshopping.productservice.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopping.productservice.model.Bill;
import com.smartshopping.productservice.model.BillDetails;
import com.smartshopping.productservice.model.ProductList;
import com.smartshopping.productservice.model.Products;
import com.smartshopping.productservice.model.UserBill;
import com.smartshopping.productservice.model.Users;
import com.smartshopping.productservice.repository.BillRepository;
import com.smartshopping.productservice.repository.OfferRepository;
import com.smartshopping.productservice.repository.ProductRepository;
import com.smartshopping.productservice.repository.UsersRepository;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	BillRepository billRepository;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OfferRepository offerRepository; 
	public List<Bill> getAllBills(){
		return this.billRepository.findAll();
	}
	
	public void userBills(@Valid UserBill userBill) {
		System.out.println("in service");
		System.out.println(userBill);
		System.out.println("final reward points"+userBill.getFinalRewardPoints());
		System.out.println("reward points" + userBill.getRewardPoints());
		Bill bill = new Bill();
		Users userDetails = new Users();
		userDetails = userRepository.findById(userBill.getUserId()).get();
		System.out.println("final reward points");
		System.out.println(userBill.getFinalRewardPoints());
		
		userDetails.setFinalRewardPoints((int)userBill.getFinalRewardPoints());
		userRepository.save(userDetails);
		bill.setFinalRewardPoints((int)userBill.getFinalRewardPoints());
		bill.setPurchaseDate(userBill.getPurchaseDate());
		bill.setTotalAmount(userBill.getTotalAmount());
		bill.setRewardPoints((int)userBill.getRewardPoints());
		bill.setOriginalAmount(userBill.getOriginalAmount());
		bill.setUser(userDetails);
		
		
		billRepository.save(bill);
		System.out.println(bill);
		
		int billId = billRepository.findMaximunBillId();
		System.out.println("bs1");
		System.out.println(billId);
		//bill1 is the bill row of newly added details
																Bill bill1 = billRepository.findByBillId(billId).get();
		System.out.println("bs2");
		System.out.println(bill1);
		List<BillDetails> billDetailsList = new ArrayList<BillDetails>();
//		
//																	List<Products> productLists = new ArrayList<Products>();
		System.out.println(userBill.getProductList());
		
		List<Integer> offerCodes = offerRepository.findOfferCodes(userBill.getPurchaseDate());
		long dt = 0 ;
		for(int i=0; i<userBill.getProductList().size() ;i++) {
			System.out.println(i);
			ProductList pd = userBill.getProductList().get(i);
			Products product = productRepository.findById(pd.getId()).get();
			int quantity = pd.getQuantity();
			if(offerCodes.contains(pd.getId())) {
				float rate1 = (float)(( offerRepository.findDiscountByCode(pd.getId()) * product.getRatePerQuantity()/100));
				
				dt+=(rate1 * quantity);
			}
			//dt is the discounted amount
			
			System.out.println("bs3");
			System.out.println(product);
			//int quantity = pd.getQuantity();
			product.setStockCount(product.getStockCount()-quantity);
			System.out.println(pd.getQuantity());
			billDetailsList.add( new BillDetails( billId, pd.getId(), pd.getQuantity()));
		}
		System.out.println("bs4");
		
			bill.setBillDetailsList(billDetailsList);
				System.out.println(bill.getBillDetailsList());
				System.out.println("bs5");
				System.out.println(billRepository.save(bill));
				System.out.println("bs6");
		 billRepository.save(bill);	
	}





	@Override
	public List<Bill> getBillByBillId(String userName) {
		// TODO Auto-generated method stub
		return billRepository.getBill(userName);
	}

	
}
