/******************************************************************************
 *  
 *  Purpose:  
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   11-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.serviceimplementation;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.utility.Utility;


public class ManagerServiceImplementation implements ManagerService
{
	static String appointmentFile = "/home/bridgelabz/Documents/sweta/"
			+ "BasicPrograms/CliniqueManagement/src/com/bridgelabz/files/Patient.json";
	
	static ArrayList<Appointment> appointmentList = new ArrayList<>();
	Doctor doctor = null;
	Patient patient = null;
	
	public ManagerServiceImplementation(String appointmentFile) {
		Utility.convertJsonToList(appointmentFile,appointmentList);
	}

	public ManagerServiceImplementation() {
		
	}

	@Override
	public void addDoctor() 
	{
		doctor = new Doctor();
		System.out.println("Enter Doctor Name: ");
		String doctorName = Utility.readString();
		doctor.setDoctorName(doctorName);
		long doctorId = Utility.getRandomRange(100, 1000);
		if (DoctorServiceImplementation.doctorList == null) {
			doctor.setDoctorId(doctorId);
		} else {
			for (int i = 0; i < DoctorServiceImplementation.doctorList.size(); i++) {

				if (doctorId == DoctorServiceImplementation.doctorList.get(i).getDoctorId()) {
					doctorId = Utility.getRandomRange(100, 1000);
					continue;
				} 
			}
			doctor.setDoctorId(doctorId);
		}
		System.out.println(doctorId);
		System.out.println("Enter Specialization: ");
		String specialization = Utility.readString();
		doctor.setSpecialization(specialization);
		System.out.println("Enter Availibility period in AM/PM or BOTH");
		String period = Utility.readString();
		doctor.setAvailability(period);
		DoctorServiceImplementation.doctorList.add(doctor);
		Utility.toJSON(DoctorServiceImplementation.doctorList, DoctorServiceImplementation.doctorFile);
		System.out.println("Doctor details added successfully!");
		
	}

	@Override
	public void updateDoctorDetails(int index) 
	{
		System.out.println("What do you want to update ?");
		System.out.println("1. Doctor Specialization\t\t 2. Doctor Availabilty time");
		int option = Utility.readInteger();
		switch (option) {
		case 1:
			System.out.println("Enter new Specialization");
			String newSpecialization = Utility.readString();
			DoctorServiceImplementation.doctorList.get(index).setSpecialization(newSpecialization);
			Utility.toJSON(DoctorServiceImplementation.doctorList, DoctorServiceImplementation.doctorFile);
			System.out.println("Data updated successfully!");
			break;
		case 2:
			System.out.println("Enter new TimeSlot");
			String newTimeSlot = Utility.readString();
			DoctorServiceImplementation.doctorList.get(index).setAvailability(newTimeSlot);
			Utility.toJSON(DoctorServiceImplementation.doctorList, DoctorServiceImplementation.doctorFile);
			System.out.println("Data updated successfully!");
			break;
		default:
			System.out.println("No such option");
		}
	}

	@Override
	public void deleteDoctor(int index) throws IOException
	{
		DoctorServiceImplementation.doctorList.remove(index);
		Utility.toJSON(DoctorServiceImplementation.doctorList, DoctorServiceImplementation.doctorFile);
		System.out.println("Doctor details deleted successfully!");
	}

	@Override
	public Patient addPatient(String mobile) 
	{
		patient = new Patient();
		System.out.println("Enter Patient Name: ");
		String patientName = Utility.readString();
		patient.setPatientName(patientName);
		long patientId = Utility.getRandomRange(10, 100);
		if (DoctorServiceImplementation.doctorList == null) {
			patient.setPatientId(patientId);
		} else {
			for (int i = 0; i < DoctorServiceImplementation.doctorList.size(); i++) {
				if (patientId == DoctorServiceImplementation.doctorList.get(i).getDoctorId()) {
					patientId = Utility.getRandomRange(10, 100);
					continue;
				}
			}
			patient.setPatientId(patientId);
		}
		patient.setMobileNumber(mobile);
		System.out.println("Enter patient age:");
		long age = Utility.readLong();
		patient.setAgeOfPatient(age);;
		//PatientServiceImplemtation.patientList.add(patient);
		PatientServiceImplementation.patientList.add(patient);
		Utility.toJSON(PatientServiceImplementation.patientList, PatientServiceImplementation.patientFile);
		System.out.println("Patient details added successfully!");
		return patient;
	}

	@Override
	public void updatePatientDetails(int index)
	{
		System.out.println("What do you want to update ?");
		System.out.println("1. Mobile Number\t\t 2. Patient Age");
		int option = Utility.readInteger();
		switch (option) {
		case 1:
			System.out.println("Enter new MobileNumber");
			String newMobile = Utility.readString();
			
			PatientServiceImplementation.patientList.get(index).setMobileNumber(newMobile);
			Utility.toJSON(PatientServiceImplementation.patientList, PatientServiceImplementation.patientFile);
			System.out.println("Data updated successfully!");
			break;
		case 2:
			System.out.println("Enter age");
			long newAge = Utility.readLong();
			PatientServiceImplementation.patientList.get(index).setAgeOfPatient(newAge);
			Utility.toJSON(PatientServiceImplementation.patientList, PatientServiceImplementation.patientFile);
			System.out.println("Data updated successfully!");
			break;
		default:
			System.out.println("No such option");
		}
	
	}

	@Override
	public void deletePatient(int index) {
		//PatientServiceImplemtation.patientList.remove(pindex);
		PatientServiceImplementation.patientList.remove(index);
		Utility.toJSON(PatientServiceImplementation.patientList, PatientServiceImplementation.patientFile);
		System.out.println("Patient details deleted successfully!");
	}

	
public void close() throws IOException, ParseException
{
	System.out.println("Do you want to close?/n Press YES[0]/NO[1]");
	int option = Utility.readInteger();
	switch(option)
	{
	case 0: System.out.println("Thanks");
		System.exit(0);
	
	break;
	case 1:
		CliniqueManager.doSelectOptions();
		break;
	}
}
	

}
