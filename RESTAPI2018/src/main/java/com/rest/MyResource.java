package com.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.Doctor;
import com.rest.dto.Patient;
import com.rest.dto.Pharmacy;
import com.ts.dao.DocDAO;
import com.ts.dao.PatDAO;
import com.ts.dao.PharmDAO;

@Path("myresource")
public class MyResource {
	@Path("Hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		return "Hello ! Welcome to REST API";
	}

	@Path("Hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHi() {
		return "Hi! Welcome to REST API";
	}

	@Path("regPatient")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void regPatient(Patient patient) {
		System.out.println("Data received in Register : " + patient);
		PatDAO patDao = new PatDAO();
		patDao.register(patient);
	}

	@Path("regDoctor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void regDoctor(Doctor doctor) {
		System.out.println("Data received in Register : " + doctor);
		DocDAO docDao = new DocDAO();
		docDao.register(doctor);
	}

	@Path("regPharmacy")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void regPharmacy(Pharmacy pharmacy) {
		System.out.println("Data received in Register : " + pharmacy);
		PharmDAO pharmDao = new PharmDAO();
		pharmDao.register(pharmacy);
	}

	@Path("patientLogin/{patUsername}/{patPassword}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getPatientByPatUsername(@PathParam("patUsername") String patUsername,
			@PathParam("patPassword") String patPassword) {

		PatDAO patDao = new PatDAO();
		Object patient = patDao.getPatientByPatUsername(patUsername, patPassword);
		System.out.println(patUsername);
		System.out.println("Received in getPatientByPatUsername : " + patUsername + patPassword);
		return patient;
	}

	@Path("pharmacyLogin/{pharmUsername}/{pharmPassword}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getPharmacyByPharmUsername(@PathParam("pharmUsername") String pharmUsername,
			@PathParam("pharmPassword") String pharmPassword) {

		PharmDAO pharmDao = new PharmDAO();
		Object pharmacy = pharmDao.getPharmacyByPharmUsername(pharmUsername, pharmPassword);
		System.out.println(pharmUsername);
		System.out.println("Received in getPharmacyByPharmUsername : " + pharmUsername + pharmPassword);
		return pharmacy;
	}

	@Path("doctorLogin/{docUsername}/{docPassword}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getDoctorByDocUsername(@PathParam("docUsername") String docUsername,
			@PathParam("docPassword") String docPassword) {

		DocDAO docDao = new DocDAO();
		Object doctor = docDao.getDoctorByDocUsername(docUsername, docPassword);
		System.out.println(docUsername);
		System.out.println("Received in getDoctorByDocUsername : " + docUsername + docPassword);
		return doctor;
	}

	@Path("getAllPatients")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getAllPatients() {
		System.out.println("Received in getAllpatients ");
		PatDAO patDao = new PatDAO();
		List<Patient> patient = patDao.getAllPatients();
		System.out.println(patient);
		return patient;

	}

	@Path("getAllDoctors")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getDoctorAll() {
		System.out.println("Recieved in getAllDoctors : ");
		DocDAO docDao = new DocDAO();
		List<Doctor> docList = docDao.getAllDoctors();
		return docList;
	}

	@Path("deletePat/{patId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePat(@PathParam("patId") int patId) {
		PatDAO patDao = new PatDAO();
		int result = patDao.deletePat(Patient.class, patId);
		System.out.println("delete patient " + result);

	}

}
