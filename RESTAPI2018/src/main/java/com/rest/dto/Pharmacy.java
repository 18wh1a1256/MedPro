package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity ;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity
public class Pharmacy {
@Id@GeneratedValue
private int pharmId;
private String pharmUsername;
private String pharmName;
private String pharmContact;
private String pharmAddress;
private String pharmPassword;

/* @ManyToOne
@JoinColumn(name = "patId")
private Patient patient;
*/
@OneToMany(mappedBy = "pharmacy", cascade=CascadeType.ALL)
@JsonBackReference
private List<Patient> patientList = new ArrayList<Patient>();

public Pharmacy() {
super();
}





public int getPharmId() {
return pharmId;
}
public void setPharmId(int pharmId) {
this.pharmId = pharmId;
}
public String getPharmUsername() {
return pharmUsername;
}
public void setPharmUsername(String pharmUsername) {
this.pharmUsername = pharmUsername;
}
public String getPharmName() {
return pharmName;
}
public void setPharmName(String pharmName) {
this.pharmName = pharmName;
}
public String getPharmContact() {
return pharmContact;
}
public void setPharmContact(String pharmContact) {
this.pharmContact = pharmContact;
}
public String getPharmAddress() {
return pharmAddress;
}
public void setPharmAddress(String pharmAddress) {
this.pharmAddress = pharmAddress;
}
public String getPharmPassword() {
return pharmPassword;
}
    public void setPharmPassword(String pharmPassword) {
this.pharmPassword = pharmPassword;
}

/* public Patient getPatient() {
return patient;
}


public void setPatient(Patient patient) {
this.patient = patient;
}
*/

public List<Patient> getPatientList() {
return patientList;
}

public void setPatientList(List<Patient> patientList) {
this.patientList = patientList;
}
}