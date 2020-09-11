package com.rest.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@XmlRootElement
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "patId")
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue
	private int patId;
	private String patUsername;
	private String patFirstName;
	private String patLastName;
	private String patAddress;
	private String patPassword;
	private String patContact;
	private int patAge;

	@ManyToOne
	@JoinColumn(name = "docId")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "pharmId")
	private Pharmacy pharmacy;

	/*
	 * @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	 * 
	 * @Fetch(value = FetchMode.SUBSELECT) private List<Doctor> doctorList = new
	 * ArrayList<Doctor>();
	 * 
	 * 
	 * @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	 * 
	 * @Fetch(value = FetchMode.SUBSELECT) private List<Pharmacy> pharmacyList =
	 * new ArrayList<Pharmacy>();
	 */

	public Patient() {
		super();
	}

	public int getPatId() {
		return patId;
	}

	public void setPatId(int patId) {
		this.patId = patId;
	}

	public String getPatUsername() {
		return patUsername;
	}

	public void setPatUsername(String patUsername) {
		this.patUsername = patUsername;
	}

	public String getPatPassword() {
		return patPassword;
	}

	public void setPatPassword(String patPassword) {
		this.patPassword = patPassword;
	}

	public String getPatFirstName() {
		return patFirstName;
	}

	public void setPatFirstName(String patFirstName) {
		this.patFirstName = patFirstName;
	}

	public String getPatLastName() {
		return patLastName;
	}

	public void setPatLastName(String patLastName) {
		this.patLastName = patLastName;
	}

	public String getPatAddress() {
		return patAddress;
	}

	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}

	public String getPatContact() {
		return patContact;
	}

	public void setPatContact(String patContact) {
		this.patContact = patContact;
	}

	public int getPatAge() {
		return patAge;
	}

	public void setPatAge(int patAge) {
		this.patAge = patAge;
	}

	/*
	 * public List<Doctor> getDoctorList() { return doctorList; }
	 * 
	 * public void setDoctorList(List<Doctor> doctorList) { this.doctorList =
	 * doctorList; }
	 * 
	 * public List<Pharmacy> getPharmacyList() { return pharmacyList; }
	 * 
	 * public void setPharmacyList(List<Pharmacy> pharmacyList) {
	 * this.pharmacyList = pharmacyList; }
	 */

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
}