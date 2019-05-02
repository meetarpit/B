package com.booking.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.booking.dao.OfferDao;
import com.booking.model.Offer;

/*Repository implementation for offer*/
@Repository
@Transactional
public class OfferDaoImpl implements OfferDao{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
		
	}
	
	public void createOffer(Offer offer) {
		// TODO Auto-generated method stub
		currentSession().save(offer);
		
	}

	public void updateOffer(Offer offer) {
		// TODO Auto-generated method stub
		currentSession().update(offer);
	}

	public void deleteOffer(Offer offer) {
		// TODO Auto-generated method stub
		currentSession().delete(offer);
	}

	public Offer edit(int id) {
		// TODO Auto-generated method stub
		return find(id);
	}

	public Offer find(int id) {
		// TODO Auto-generated method stub
		return (Offer) currentSession().get(Offer.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Offer> getAll() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(Offer.class).list();
	}

	public List<Offer> find() {
		// TODO Auto-generated method stub
	Criteria ct=currentSession().createCriteria(Offer.class);
	Criterion salary = Restrictions.eq("isActive", true);
	Criterion name = Restrictions.eq("isExpired", false);
	LogicalExpression andExp = Restrictions.and(salary, name);
	ct.add(andExp);
	@SuppressWarnings("unchecked")
	List<Offer>offerlist=ct.list();
		return offerlist;
	}

	public List<Offer> findExpired() {
		// TODO Auto-generated method stub
		Criteria ct=currentSession().createCriteria(Offer.class);
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
	    String strDate = formatter.format(date);  
		ct.add(Restrictions.lt("enddate", strDate));
		@SuppressWarnings("unchecked")
		List<Offer>offerExp=ct.list();
		return offerExp;
	}

	public List<Offer> getAllOffer(String filter) {
		 Criteria ct = currentSession().createCriteria(Offer.class);          
	        Criterion offername = Restrictions.ilike("offerName",filter,MatchMode.ANYWHERE);
	        ct.add(offername);
	        @SuppressWarnings("unchecked")
			List<Offer> results = ct.list();
	        System.out.println("results : "+results.size());
	        return results;
		
	}

	public List<Offer> UserOffer(String filter) {
		Criteria ct = currentSession().createCriteria(Offer.class);          
        Criterion offername = Restrictions.ilike("offerName",filter,MatchMode.ANYWHERE);
        Criterion isActive = Restrictions.eq("isActive", true);
    	Criterion isExpired = Restrictions.eq("isExpired", false);
    	Conjunction conjunction = Restrictions.conjunction();
    	conjunction.add( offername);
    	conjunction.add(isExpired);
    	conjunction.add(isActive);
        ct.add(conjunction);
        @SuppressWarnings("unchecked")
		List<Offer> results = ct.list();
        System.out.println("results : "+results.size());
        return results;
	}

	
}
