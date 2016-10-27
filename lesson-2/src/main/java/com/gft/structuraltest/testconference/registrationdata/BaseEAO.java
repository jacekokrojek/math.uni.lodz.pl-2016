package com.gft.structuraltest.testconference.registrationdata;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: mjancy
 * Date: 05.03.14
 * Time: 11:02
 */
public abstract class BaseEAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Criteria getCriteria(){
        return getSession().createCriteria(getEntityClass());
    }

    public abstract Class getEntityClass();
}
