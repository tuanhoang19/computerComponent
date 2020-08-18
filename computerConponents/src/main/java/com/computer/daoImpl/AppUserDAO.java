package com.computer.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.computer.entity.AppUser;
@Repository
@Transactional
public class AppUserDAO {
	 
    @Autowired
    private EntityManager entityManager;
 
    public AppUser findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
 
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
 
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public AppUser getUser(String username)
    {
    	Query query = entityManager.createQuery("Select e from AppUser e Where e.userName= :name",AppUser.class);
    	query.setParameter("name",username);
    	AppUser appuser=(AppUser) query.getSingleResult();
    	return appuser;
    }
 
}

