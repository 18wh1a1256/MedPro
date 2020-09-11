package com.ts.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rest.dto.Doctor;
import com.rest.dto.Patient;
import com.rest.dto.Pharmacy;

public class HibernateTemplate {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static int addObject(Object obj) {
		System.out.println("Inside Template...");
		int result = 0;

		Transaction tx = null;

		try {

			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();

			session.save(obj);

			tx.commit();

			result = 1;

		} catch (Exception e) {

			tx.rollback();

			e.printStackTrace();
		}

		return result;
	}

	public static Object getObject(Class c, Serializable serializable) {
		Object obj = null;

		try {
			return sessionFactory.openSession().get(c, serializable);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return obj;
	}

	/*
	 * public static Object getObjectByUserPass(String loginId,String password)
	 * {
	 * 
	 * String queryString =
	 * "from Employee where email = :loginId and password =:password"; Query
	 * query = sessionFactory.openSession().createQuery(queryString);
	 * query.setString("loginId", loginId); query.setString("password",
	 * password); Object queryResult = query.uniqueResult(); Employee employee =
	 * (Employee)queryResult; return employee; } public static Object
	 * getObjectByEmail(String email) {
	 * 
	 * String queryString = "from Employee where email = :email"; Query query =
	 * sessionFactory.openSession().createQuery(queryString);
	 * query.setString("email", email); Object queryResult =
	 * query.uniqueResult(); Employee employee = (Employee)queryResult; return
	 * employee; }
	 */

	public static List<Object> getObjectListByQuery(String query) {
		return sessionFactory.openSession().createQuery(query).list();
	}

	public static int updateObject(Object obj) {
		int result = 0;

		Transaction tx = null;

		try {

			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();

			session.saveOrUpdate(obj);

			tx.commit();

			result = 1;

		} catch (Exception e) {

			tx.rollback();

			e.printStackTrace();
		}

		return result;
	}

	public static int deleteObject(Class c, Serializable serializable) {
		int result = 0;

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		try {

			Object obj = session.get(c, serializable);

			session.delete(obj);

			tx.commit();

			result = 1;

		} catch (Exception e) {

			e.printStackTrace();

			tx.rollback();
		}

		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(c);
		Criterion nameCriterion = Restrictions.eq(columName, value);
		criteria.add(nameCriterion);
		return criteria.list();
	}

	public static Object getObjectByPatUsername(String patUsername, String patPassword) {
		String queryString = "from Patient where patUsername = :patUsername and patPassword =:patPassword";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("patUsername", patUsername);
		query.setString("patPassword", patPassword);
		Object queryResult = query.uniqueResult();
		Patient patient = (Patient) queryResult;
		return patient;
	}

	public static Object getObjectByPharmUsername(String pharmUsername, String pharmPassword) {
		String queryString = "from Pharmacy where pharmUsername = :pharmUsername and pharmPassword =:pharmPassword";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("pharmUsername", pharmUsername);
		query.setString("pharmPassword", pharmPassword);
		Object queryResult = query.uniqueResult();
		Pharmacy pharmacy = (Pharmacy) queryResult;
		return pharmacy;
	}

	public static Object getObjectByDocUsername(String docUsername, String docPassword) {
		String queryString = "from Doctor where docUsername = :docUsername and docPassword =:docPassword";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("docUsername", docUsername);
		query.setString("docPassword", docPassword);
		Object queryResult = query.uniqueResult();
		Doctor doctor = (Doctor) queryResult;
		return doctor;
	}

}