package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import com.rest.dto.Patient;
import com.ts.db.HibernateTemplate;

public class PatDAO {
	private SessionFactory factory = null;

	/*
	 * public Patient getEmpByUserPass(String loginId,String password) {
	 * 
	 * return (Patient)HibernateTemplate.getObjectByUserPass(loginId,password);
	 * }
	 */

	public Object getPatientByPatUsername(String patUsername, String patPassword) {
		return (Object) HibernateTemplate.getObjectByPatUsername(patUsername, patPassword);
	}

	public int register(Patient patient) {
		System.out.println("Inside patient registration");
		return HibernateTemplate.addObject(patient);
	}

	public List<Patient> getAllPatients() {
		List<Patient> patients = (List) HibernateTemplate.getObjectListByQuery("From Patient");
		System.out.println("Inside All Patient ..." + patients);
		return patients;
	}

	public Patient getPatient(int id) {
		return (Patient) HibernateTemplate.getObject(Patient.class, id);
	}

	public int deletePat(Class Patient, int patId) {
		return HibernateTemplate.deleteObject(Patient.class, patId);
	}

	/*
	 * public void getPatient(int deptId) { String query=
	 * "from Patient where deptId = 1";
	 * System.out.println("get employees is called..."); List<Object> obj =
	 * (List<Object>) HibernateTemplate.getObjectListByQuery(query);
	 * System.out.println("Testing get patient :" + obj); for(Object pat: obj){
	 * Patient patient = (Patient)pat;
	 * System.out.println(patient.getPatFirstName()); } }
	 */
	/*
	 * public Patient getEmpByEmail(String email) { return
	 * (Employee)HibernateTemplate.getObjectByEmail(email); }
	 */
}