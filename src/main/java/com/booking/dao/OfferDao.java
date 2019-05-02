package com.booking.dao;

import java.util.List;

import com.booking.model.Offer;

/*Repository for offer class*/
public interface OfferDao {

	public void createOffer(Offer offer); //used to create offer
	public void updateOffer(Offer offer); //used to edit offers
	public void deleteOffer(Offer offer); //used to delete offers
	public Offer edit(int id); //used to edit offers by id
	public Offer find(int id); //used to find offers by id
 	public List<Offer> getAll();//used to return offers list at admin side
	public List<Offer> find(); //used to return list of offers according to given condtition
	public List<Offer> findExpired();//used to return list of offer as per their expiry date
	public  List<Offer> getAllOffer(String filter); //used to return list of offer according to search will make
	public List<Offer> UserOffer(String filter);
	
}
