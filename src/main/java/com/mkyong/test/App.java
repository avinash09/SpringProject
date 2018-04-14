package com.mkyong.test;


import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;

import com.mkyong.persistence.HibernateUtil;
import com.mkyong.web.datalayer.Employee;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class App {
	
	public static void main(String[] args) throws UnknownHostException {
		/*List list = testCriteria();
		JSONArray jsonArray = new JSONArray(list);
		System.out.println(jsonArray.toString());*/
		
		// Since 2.10.0, uses MongoClient
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		
		List<String> dbs = mongo.getDatabaseNames();
		for(String db : dbs){
			System.out.println(db);
		}
		DB db = mongo.getDB("test");
		DBCollection mycol = db.getCollection("mycol");
		DBCursor doccursor = mycol.find();
		
		while(doccursor.hasNext()) {
			System.out.println(doccursor.next());
		}

		/*Employee em1 = new Employee("Mary Smith", 25d);
		Employee em2 = new Employee("John Aces", 32d);
		Employee em3 = new Employee("Ian Young", 29d);
		
		System.out.println(" =======CREATE =======");
		create(em1);
		create(em2);
		create(em3);
		System.out.println(" =======READ =======");
		List<Employee> ems1 = read();
		for(Employee e: ems1) {
			System.out.println(e.toString());
		}
		System.out.println(" =======UPDATE =======");
		em1.setAge(44d);
		em1.setName("Mary Rose");
		update(em1);
		System.out.println(" =======READ =======");
		List<Employee> ems2 = read();
		for(Employee e: ems2) {
			System.out.println(e.toString());
		}
		System.out.println(" =======DELETE ======= ");
		delete(em2.getId());
		System.out.println(" =======READ =======");
		List<Employee> ems3 = read();
		for(Employee e: ems3) {
			System.out.println(e.toString());
		}
		System.out.println(" =======DELETE ALL ======= ");
		deleteAll();
		System.out.println(" =======READ =======");
		List<Employee> ems4 = read();
		for(Employee e: ems4) {
			System.out.println(e.toString());
		}*/
		System.exit(0);
	}
	
	public static List testCriteria() {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.between(Employee.AGE, 20d,30d));
		criteria.setFirstResult(3);
		criteria.setMaxResults(6);
		criteria.addOrder(Order.asc(Employee.NAME));
		
		List<Employee> employees = criteria.list();
		HibernateUtil.shutdown();
		System.out.println("Found " + employees.size() + " Employees");
		return employees;

	}

	public static Long create(Employee e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Successfully created " + e.toString());
		return e.getId();

	}

	public static List<Employee> read() {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Employee> employees = session.createQuery("FROM Employee").list();
		 HibernateUtil.shutdown();
		System.out.println("Found " + employees.size() + " Employees");
		return employees;

	}

	public static void update(Employee e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee em = (Employee) session.load(Employee.class, e.getId());
		em.setName(e.getName());
		em.setAge(e.getAge());
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Successfully updated " + e.toString());

	}

	public static void delete(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Successfully deleted " + e.toString());

	}

	public static Employee findByID(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee e = (Employee) session.load(Employee.class, id);
		HibernateUtil.shutdown();
		return e;
	}
	
	public static void deleteAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Employee ");
		query.executeUpdate();
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Successfully deleted all employees.");

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

