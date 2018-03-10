package com.mkyong.persistence.Dao;

import java.util.List;

import org.hibernate.Criteria;
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
	public static List getEmployeeAll() {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		HibernateUtil.shutdown();
		System.out.println("Found " + employees.size() + " Employees");
		return employees;

	}

}
