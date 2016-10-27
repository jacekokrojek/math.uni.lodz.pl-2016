package com.gft.structuraltest.testconference.registrationdata;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class RegistrationEAO extends BaseEAO {

	private static final Logger logger = Logger.getLogger(RegistrationEAO.class);

    @Override
    public Class getEntityClass() {
        return RegistrationEntity.class;
    }

	public void persist(RegistrationEntity entity) throws Exception{
		logger.debug("Persisting the following Registration entity: " + entity);
		getSession().persist(entity);
	}

	public void merge(RegistrationEntity entity) throws Exception{
		logger.debug("Merging the following Registration entity: " + entity);
		getSession().merge(entity);
	}

	public List<RegistrationEntity> getRegistrations(int rangeStart, int rangeEnd,
			String firstName, String lastName, String email, String phone, String city, String interests, boolean correct) {

		Criteria criteria = getCriteria();

		if (firstName !=null && firstName.length() > 0){
			criteria.add(Restrictions.like("firstName", firstName, MatchMode.START));
		}

		if (lastName != null && lastName.length() > 0) {
			criteria.add(Restrictions.like("lastName", lastName, MatchMode.START));
		}

		if (email != null && email.length() > 0) {
			criteria.add(Restrictions.like("email", email, MatchMode.START));
		}
		if (phone != null && phone.length() > 0) {
			criteria.add(Restrictions.like("phone", phone, MatchMode.START));
		}
		if (city != null && city.length() > 0) {
			criteria.add(Restrictions.like("city", city, MatchMode.START));
		}
		if (interests != null && interests.length() > 0) {
			criteria.add(Restrictions.like("interests", interests, MatchMode.START));
		}

		if (correct) {
			criteria.add(Restrictions.eq("correct", new Boolean(correct)));
		}

		criteria.setFirstResult(rangeStart);
		if (rangeEnd > 0) {
			criteria.setMaxResults(rangeEnd - rangeStart);
		}

		return criteria.list();
	}

	public List<RegistrationEntity> getAllRegistrations(){
		Criteria criteria = getCriteria();
		return criteria.list();
	}

	public int getRegistrationsCount(String firstName, String lastName,	String email, String phone, String city,String interests, boolean confirmation){

		Criteria criteria = getCriteria();

		if (firstName !=null && firstName.length() > 0){
			criteria.add(Restrictions.like("firstName", firstName, MatchMode.START));
		}

		if (lastName != null && lastName.length() > 0) {
			criteria.add(Restrictions.like("lastName", lastName, MatchMode.START));
		}

		if (email != null && email.length() > 0) {
			criteria.add(Restrictions.like("email", email, MatchMode.START));
		}
		if (phone != null && phone.length() > 0) {
			criteria.add(Restrictions.like("phone", phone, MatchMode.START));
		}
		if (city != null && city.length() > 0) {
			criteria.add(Restrictions.like("city", city, MatchMode.START));
		}
		if (interests != null && interests.length() > 0) {
			criteria.add(Restrictions.like("interests", interests, MatchMode.START));
		}

		if (confirmation) {
			criteria.add(Restrictions.eq("confirmed", new Boolean(confirmation)));
		}

		Long number =  (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();		
		return number.intValue();
	}


	public void removeRegistration(long registrationId)	throws Exception {
		RegistrationEntity deleting = 
				(RegistrationEntity) getSession().get(RegistrationEntity.class, registrationId);
		if (deleting == null) {
			throw new Exception("Could not find registration to be deleted.");
		}
		getSession().delete(deleting);
	}
	
	public RegistrationEntity getSingleRegistrationById(long registrationId) throws Exception {
		return (RegistrationEntity) getSession().get(RegistrationEntity.class, registrationId);
	}
	
	public RegistrationEntity getSingleRegistrationByPrizeLevel(int prizeLevel) throws Exception {
		Criteria criteria = getCriteria();
		if (prizeLevel > 0) {
			criteria.add(Restrictions.eq("prize", prizeLevel));
		}
		return (RegistrationEntity) criteria.uniqueResult();
	}
	
	public RegistrationEntity mergeSingleRegistration(RegistrationEntity entity) throws Exception {
		return (RegistrationEntity) getSession().merge(entity);
	}
	/**
	 * Searches for an existing RegistrationEntity with a given name 
	 * @param email - the email of the registration we are looking for
	 * @return existing RegistrationEntity object otherwise returns null
	 */
	public RegistrationEntity returnExistingRegistration(String email) {
		Criteria criteria = getCriteria();
		if (email != null && email.length() > 0) {
			criteria.add(Restrictions.like("email", email, MatchMode.START));
		}
		return (RegistrationEntity) criteria.uniqueResult();
	}
}
