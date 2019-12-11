package com.smartshopping.productservice.services;

import java.util.Date;
import java.util.List;

import com.smartshopping.productservice.exception.OfferAlreadyExistsException;
import com.smartshopping.productservice.model.Offer;

public interface OfferService {
	public void addOffer(Offer offer, int id) throws OfferAlreadyExistsException;
	public void updateOffer(Offer offer, int id) throws OfferAlreadyExistsException ;
	public void deleteOffer(int id);
	public List<Offer> getCurrentOffers();
	public List<Offer> getOffers(Date date);
	public Offer getOffer(int id);
	public List<Offer> offerList();
}
