package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "docId")
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue
	private int docId;
	private String docUsername;
	private String docPassword;
	private String docFirstName;
	private String docLastName;
	private String docContact;
	private String docSpecialisation;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="patId") private Patient patient;
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Patient> patientList = new ArrayList<Patient>();

	public Doctor() {
		super();
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocPassword() {
		return docPassword;
	}

	public void setDocPassword(String docPassword) {
		this.docPassword = docPassword;
	}

	public String getDocUsername() {
		return docUsername;
	}

	public void setDocUsername(String docUsername) {
		this.docUsername = docUsername;
	}

	public String getDocFirstName() {
		return docFirstName;
	}

	public void setDocFirstName(String docFirstName) {
		this.docFirstName = docFirstName;
	}

	public String getDocLastName() {
		return docLastName;
	}

	public void setDocLastName(String docLastName) {
		this.docLastName = docLastName;
	}

	public String getDocContact() {
		return docContact;
	}

	public void setDocContact(String docContact) {
		this.docContact = docContact;
	}

	public String getDocSpecialisation() {
		return docSpecialisation;
	}

	public void setDocSpecialisation(String docSpecialisation) {
		this.docSpecialisation = docSpecialisation;
	}

	/*
	 * public Patient getPatient() { return patient; }
	 * 
	 * public void setPatient(Patient patient) { this.patient = patient; }
	 */
	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

}