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

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bridgelabz.model.Patient;

public interface PatientService {
	public void takeAppointment() throws IOException, ParseException;
	public void showPatientDetails();
	public Patient searchPatientByName();
	public Patient searchPatientById();
	public Patient searchPatientByMobileNumber();
}
