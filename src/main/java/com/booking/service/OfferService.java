package com.booking.service;

import java.util.List;

import com.booking.model.Offer;

/*service interface for offers*/
public interface OfferService {

	public void createOffer(Offer offer);
	public void updateOffer(Offer offer);
	public void deleteOffer(Offer offer);
	public Offer edit(int id);
	public Offer find(int id);
	public List<Offer> getAll();
	public List<Offer> find();
	public List<Offer> findExpired();
	public  List<Offer> getAllOffer(String filter);
	public List<Offer> UserOffer(String filter);
}
