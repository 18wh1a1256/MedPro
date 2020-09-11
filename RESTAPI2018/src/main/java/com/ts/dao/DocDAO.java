package com.ts.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest.dto.Doctor;
import com.ts.db.HibernateTemplate;

public class DocDAO {
	private SessionFactory factory = null;

	public Object getDoctorByDocUsername(String docUsername, String docPassword) {
		// TODO Auto-generated method stub
		return (Object) HibernateTemplate.getObjectByDocUsername(docUsername, docPassword);
	}

	public int register(Doctor doctor) {
		return HibernateTemplate.addObject(doctor);
	}

	public List<Doctor> getAllDoctors() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Query q1 = session.createQuery("from Doctor d");
		List<Doctor> docList = q1.list();
		session.close();
		return docList;
	}

	public Doctor getDoc(int docId) {
		return (Doctor) HibernateTemplate.getObject(Doctor.class, docId);
	}

	// public List<Doctor> getDocByDocUsername(String docUsername) {
	// return
	// (List)HibernateTemplate.getObjectListByName(Doctor.class,"docUsername",docUsername);
	// }

}
