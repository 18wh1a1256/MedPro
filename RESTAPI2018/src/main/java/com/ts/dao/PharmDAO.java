package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.Pharmacy;
import com.ts.db.HibernateTemplate;

public class PharmDAO {

private SessionFactory factory = null;

public int register(Pharmacy pharm) {
return HibernateTemplate.addObject(pharm);
}

public Pharmacy getPharm(int pharmId) {
return (Pharmacy)HibernateTemplate.getObject(Pharmacy.class,pharmId);
}

public List<Pharmacy> getAllPharms() {
List<Pharmacy> pharms=(List)HibernateTemplate.getObjectListByQuery("From Pharmacy");
return pharms;
}

public List<Pharmacy> getPharmByUsername(String pharmUsername) {
return (List)HibernateTemplate.getObjectListByName(Pharmacy.class,"pharmUserName",pharmUsername);
}

public Object getPharmacyByPharmUsername(String pharmUsername, String pharmPassword) {
// TODO Auto-generated method stub
return (Object)HibernateTemplate.getObjectByPharmUsername(pharmUsername, pharmPassword);
}

}