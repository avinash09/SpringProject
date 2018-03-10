package com.mkyong.persistence.Dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.mkyong.persistence.HibernateUtil;
import com.mkyong.web.datalayer.Employee;

@Component("employeedao")
public class EmployeeDao {
	
	public static Long create(Employee e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Successfully created " + e.toString());
		return e.getId();

	}

}
