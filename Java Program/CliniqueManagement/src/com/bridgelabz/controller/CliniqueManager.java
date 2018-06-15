/******************************************************************************
 *  
 *  Purpose:  Clinique Management
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   11-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.serviceimplementation.DoctorServiceImplementation;
import com.bridgelabz.serviceimplementation.ManagerServiceImplementation;
import com.bridgelabz.serviceimplementation.PatientServiceImplementation;
import com.bridgelabz.utility.Utility;

public class CliniqueManager
{
	static String appointmentFile = "/home/bridgelabz/Documents/sweta/"
			+ "BasicPrograms/CliniqueManagement/src/com/bridgelabz/files/Patient.json";
	static String patientFile = "/home/bridgelabz/Documents/sweta/"
			+ "BasicPrograms/CliniqueManagement/src/com/bridgelabz/files/Patient.json";
	static String doctorFile = "/home/bridgelabz/Documents/sweta/"
			+ "BasicPrograms/CliniqueManagement/src/com/bridgelabz/files/Doctor.json";

	static DoctorServiceImplementation doctorService = new DoctorServiceImplementation(doctorFile);
	static PatientServiceImplementation patientService = new PatientServiceImplementation(patientFile);
	static ManagerServiceImplementation appointment = new ManagerServiceImplementation(appointmentFile);

public static void main(String[] args) throws IOException, ParseException {
	System.out.println("Choose one of the following options to perform operation : ");
	doSelectOptions();
}

public static void doSelectOptions() throws IOException, ParseException 
{
	System.out.println("1.Add Doctor Details");
	System.out.println("2.Delete Doctor Details");
	System.out.println("3.Update Doctor Details");
	System.out.println("4.Show DoctorList");
	System.out.println("5.Take Appointment");
	System.out.println("6.Delete Patient Details");
	System.out.println("7.Update Patient Details");
	System.out.println("8.Show PatientList");
	System.out.println("9.Search Doctor");
	System.out.println("10.Search Paitent");
	System.out.println("11.Show Popular Specialization");
	System.out.println("12.Show Popular Doctor ");
	System.out.println("13.Close Out From Application");
	int option = Utility.readInteger();
	performOperations(option);
}

private static void performOperations(int option) throws IOException, ParseException
{
	switch (option) {
	case 1:
		appointment.addDoctor();
		doSelectOptions();
		break;
	case 2:
		System.out.println("Which doctor details you want to delete ? ");
		doctorService.showDoctorDetails();
		System.out.println("Enter Index: ");
		int index = Utility.readInteger();
		appointment.deleteDoctor(index);
		doSelectOptions();
		break;
	case 3:
		System.out.println("Which doctor details you want to update ?");
		doctorService.showDoctorDetails();
		System.out.println("Enter index");
		int index1 = Utility.readInteger();
		appointment.updateDoctorDetails(index1);
		doSelectOptions();
		break;
	case 4:
		doctorService.showDoctorDetails();
		doSelectOptions();
		break;
	case 5:
		//appointment.addPatient();
		patientService.takeAppointment();
		doSelectOptions();
		break;
	case 6:
		System.out.println("Which pateint details you want to delete?");
		patientService.showPatientDetails();
		System.out.println("Enter index");
		int pindex = Utility.readInteger();
		appointment.deletePatient(pindex);
		doSelectOptions();
		break;
	case 7:
		System.out.println("Which Patient details you want to update ?");
		patientService.showPatientDetails();
		System.out.println("Enter index");
		int index2 = Utility.readInteger();
		appointment.updatePatientDetails(index2);
		doSelectOptions();
		break;
	case 8:
		patientService.showPatientDetails();
		doSelectOptions();
		break;
	case 9:
		System.out.println("Enter option by which you want to search doctor : ");
		searchDoctor();
		break;
	case 10:
		System.out.println("Enter option by which you want to search doctor : ");
		searchPatient();
		break;
	case 11:
		doctorService.searchPopularSpecialization();
		doSelectOptions();
		break;
	case 12:
		doctorService.searchPopulardoctor();
		doSelectOptions();
		break;
	case 13:
		appointment.close();
		break;
	default:
		System.err.println("No such option");
	}
}
private static void searchPatient() throws IOException, ParseException {
	System.out.println("1. search by PatientName\t\t 2. search by PatientId");
	System.out.println("\t\t3. search by Patient-mobileNumber");
	int option = Utility.readInteger();
	switch (option) {
	case 1:
		Patient byName = patientService.searchPatientByName();
		System.out.println(byName);
		doSelectOptions();
		break;
	case 2:
		Patient byId = patientService.searchPatientById();
		System.out.println(byId);
		doSelectOptions();
		break;
	case 3:
		Patient byMobile = patientService.searchPatientByMobileNumber();
		System.out.println(byMobile);
		doSelectOptions();
		break;
	default:
		System.err.println("No such option");
	}
}
public static void searchDoctor() throws IOException, ParseException {
	System.out.println("1. search by DoctorName\t\t\t2. search by DoctorId");
	System.out.println("3. search by Doctor-Specialization \t4. search by Doctor-Availability");
	int option = Utility.readInteger();
	switch (option) {
	case 1:
		Doctor byName = doctorService.searchDoctorByName();
		System.out.println(byName);
		doSelectOptions();
		break;
	case 2:
		Doctor byId = doctorService.searchDoctorById();
		System.out.println(byId);
		doSelectOptions();
		break;
	case 3:
		ArrayList<Doctor> bySpecilaization=new ArrayList<>();
		System.out.println("Enter doctor Specialization:");
		String specialization=Utility.readString();
		bySpecilaization = doctorService.searchDoctorBySpecialization(bySpecilaization,specialization);
		for (int i = 0; i < bySpecilaization.size(); i++) {
			System.out.println(bySpecilaization.get(i));
		}
		doSelectOptions();
		break;
	case 4:
		ArrayList<Doctor> byAvailable = doctorService.searchDoctorByAvailability();
		for (int i = 0; i < byAvailable.size(); i++) {
			System.out.println(byAvailable.get(i));
		}
		doSelectOptions();
		break;
	}
}
	
}
