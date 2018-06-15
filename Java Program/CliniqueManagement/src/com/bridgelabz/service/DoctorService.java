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
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.bridgelabz.model.Doctor;

public interface DoctorService
{
	public void showDoctorDetails() throws FileNotFoundException, IOException, ParseException ;
	public Doctor searchDoctorByName();
	public Doctor searchDoctorById();

	//public void searchDoctorBySpecialisation();

	public ArrayList<Doctor> searchDoctorByAvailability();
	public ArrayList<Doctor> searchDoctorBySpecialisation(ArrayList<Doctor> list, String specialization);
	void searchPopularSpecialization();
	void searchPopulardoctor();

}
