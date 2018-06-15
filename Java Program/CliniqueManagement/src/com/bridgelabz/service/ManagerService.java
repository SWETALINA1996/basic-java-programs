/******************************************************************************
 *  
 *  Purpose:  
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   11-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.service;

import java.io.IOException;

import com.bridgelabz.model.Patient;

public interface ManagerService {
	public void addDoctor();
	//public void updateDoctorDetails();
	//public void deleteDoctor();
	public Patient addPatient(String mobile);
	//public void updatePatientDetails();
	//public void deletePatient();
	void deleteDoctor(int index) throws IOException;
	void updateDoctorDetails(int index);
	void updatePatientDetails(int index);
	public void deletePatient(int index);
	
}
