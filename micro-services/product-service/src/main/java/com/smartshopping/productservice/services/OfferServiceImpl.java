package com.smartshopping.productservice.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopping.productservice.exception.OfferAlreadyExistsException;
import com.smartshopping.productservice.model.Offer;
import com.smartshopping.productservice.model.Products;
import com.smartshopping.productservice.repository.OfferRepository;
import com.smartshopping.productservice.repository.ProductRepository;

@Service
public class OfferServiceImpl implements OfferService{
	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public void addOffer(Offer offer, int id) throws OfferAlreadyExistsException {
		Products product = productRepository.findById(id).get();
		offer.setProductId(product);
		Optional<Offer> offer2 = offerRepository.getOffer(offer.getOfferDate(), product.getId());
		if(!offer2.isPresent()) {
			offerRepository.save(offer);
		} else {
			throw new OfferAlreadyExistsException();
		}
		
	}
	
	public void updateOffer(Offer offer, int id) throws OfferAlreadyExistsException {
		Products product = productRepository.findById(id).get();
		offer.setProductId(product);
		offerRepository.save(offer);
		
	}
	
	public void deleteOffer(int id){
		offerRepository.deleteById(id);	
	}
	
	public List<Offer> getCurrentOffers() {
		return offerRepository.getCurrentOffer();
	}
	
	public List<Offer> getOffers(Date date) {
		return offerRepository.getOfferList(date);
	}
	
	public Offer getOffer(int id) {
		return offerRepository.findById(id).get();
	}
	
	public List<Offer> offerList(){
		return offerRepository.findAll();
	}
}
