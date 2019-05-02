package com.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booking.dao.OfferDao;
import com.booking.model.Offer;
import com.booking.service.OfferService;

/*service implementation class for offer, used to call methods defined in Dao*/

@Service
@Transactional
public class OfferServiceImpl implements OfferService{

	@Autowired
	OfferDao offerDao;
	
	public void createOffer(Offer offer) {
		// TODO Auto-generated method stub
		offerDao.createOffer(offer);
	}

	public void updateOffer(Offer offer) {
		// TODO Auto-generated method stub
		offerDao.updateOffer(offer);
	}

	public void deleteOffer(Offer offer) {
		// TODO Auto-generated method stub
		offerDao.deleteOffer(offer);
	}

	public Offer edit(int id) {
		// TODO Auto-generated method stub
		return offerDao.edit(id);
	}

	public Offer find(int id) {
		// TODO Auto-generated method stub
		return offerDao.find(id);
	}

	public List<Offer> getAll() {
		// TODO Auto-generated method stub
		return offerDao.getAll();
	}

	public List<Offer> find() {
		// TODO Auto-generated method stub
		return offerDao.find();
	}

	public List<Offer> findExpired() {
		// TODO Auto-generated method stub
		return offerDao.findExpired();
	}

	public List<Offer> getAllOffer(String filter) {
		// TODO Auto-generated method stub
		return offerDao.getAllOffer(filter);
	}

	public List<Offer> UserOffer(String filter) {
		// TODO Auto-generated method stub
		return offerDao.UserOffer(filter);
	}

	

	
}
