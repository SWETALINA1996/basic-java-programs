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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.PatientService;
import com.bridgelabz.utility.Utility;

public class PatientServiceImplementation implements PatientService
{

	static String patientFile = "/home/bridgelabz/Documents/sweta/"
			+ "BasicPrograms/CliniqueManagement/src/com/bridgelabz/files/Patient.json";
	
	static ArrayList<Patient> patientList = new ArrayList<>();
	public ManagerServiceImplementation manager = new ManagerServiceImplementation();
	public DoctorServiceImplementation doctorImpl = new DoctorServiceImplementation();
	
	public PatientServiceImplementation(String patientFile2) {
		// TODO Auto-generated constructor stub
		Utility.convertJsonToList(patientFile,patientList);
	}

	@Override
	public void showPatientDetails()
	{
		JSONParser parser = new JSONParser();
		try {
			
			Object object = parser.parse(new FileReader(patientFile));
			JSONArray patientArray = (JSONArray) object;
			for (int i = 0; i < patientArray.size(); i++) {
				JSONObject details = (JSONObject) patientArray.get(i);
				System.out.println("index : " + i + " " + details);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public Patient searchPatientByName() 
	{
		System.out.println("Enter patient name:");
		String searchName = Utility.readString();
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().equals(searchName)) {
				return patientList.get(i);
			}
		}
		return null;	
	}

	@Override
	public Patient searchPatientById() 
	{
		System.out.println("Enter patient ID:");
		long pateintId = Utility.readLong();
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientId() == pateintId) {
				return patientList.get(i);
			}
		}
		return null;
	}

	@Override
	public Patient searchPatientByMobileNumber() 
	{
		System.out.println("Enter Mobile number:");
		long mobile = Utility.readLong();
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getMobileNumber().equals(mobile)) {
				return patientList.get(i);
			}
		}
		return null;
	}

	@Override
	public void takeAppointment() throws IOException, ParseException 
	{
		Appointment appointment = null;
Patient patient=null ;
		
		System.out.println("Enter your mobile number: ");
		String mobile = Utility.readString();
		
			for (int i = 0; i < patientList.size(); i++) 
			{
				if (patientList.get(i).getMobileNumber().equals(mobile))
				{
					patient = patientList.get(i);
				}
			}
		if (patient == null) {
			patient = manager.addPatient(mobile);
		}
		ArrayList<Doctor> specializedDoctorList = new ArrayList();
		System.out.println("Enter which specialized doctor you want?");
		String doctorSpecialization = Utility.readString();
		//searching specialization and store in specializationList
		specializedDoctorList.addAll(doctorImpl.searchDoctorBySpecialization(specializedDoctorList, doctorSpecialization));
		//System.out.println(specializedDoctorList);
		
		System.out.println("Enter the required time slot in AM/PM");
		String timeslot = Utility.readString();
		///////////////////////////
		
		System.out.println(specializedDoctorList.size());
		ArrayList<Doctor> DoctorperiodList = new ArrayList<Doctor>();
		//DoctorperiodList=Utility.jsonToJavaList(doctorImpl.doctorFile);
		for (int i = 0; i < specializedDoctorList.size(); i++) {
			if (timeslot.equalsIgnoreCase(specializedDoctorList.get(i).getAvailability())
					|| ("BOTH").equalsIgnoreCase(specializedDoctorList.get(i).getAvailability())) {
				DoctorperiodList.add(specializedDoctorList.get(i));
			}
		}
		if (DoctorperiodList.size() == 0) 
		{
			System.err.println("We don't have any doctor with respect to your given specialization and time.You can come some other day");
			CliniqueManager.doSelectOptions();
		} 
		else
		{
			System.out.println("Enter Id of the doctor to consult with,from the given options: ");
			//display doctor list here
			for (int i = 0; i < DoctorperiodList.size(); i++) 
			{
				System.out.println(DoctorperiodList.get(i));
			}
			long doctorId = Utility.readLong();
			for (int i = 0; i <DoctorperiodList.size(); i++) 
			{
				if (doctorId == DoctorperiodList.get(i).getDoctorId()) 
				{
					
					appointment=new Appointment();
					long patientCount = DoctorperiodList.get(i).getCountOfPatients();
					if (patientCount < 5 ) 
					{
						DoctorperiodList.get(i).setCountOfPatients(patientCount + 1);
						Utility.toJSON(DoctorServiceImplementation.doctorList, DoctorServiceImplementation.doctorFile);
						System.out.println("We are appointed Dr. " + DoctorperiodList.get(i).getDoctorName() + " to " + patient.getPatientName());
						appointment.setDoctorId(doctorId);
						appointment.setDoctorName(DoctorperiodList.get(i).getDoctorName());
						appointment.setPatientName(patient.getPatientName());
						appointment.setPatientId(patient.getPatientId());
						appointment.setTimeStamp(Utility.getTimeStamp());
						manager.appointmentList.add(appointment);
						Utility.toJSON(ManagerServiceImplementation.appointmentList, ManagerServiceImplementation.appointmentFile);
						System.out.println("you are appointed.Please wait outside.we will call you");
						CliniqueManager.doSelectOptions();
						
					} 
					else 
					{
						System.out.println("Today doctor is not available.You can come tommorow");
						System.out.println(" you want to take appointment with other doctor yes[0]/no[1]");
						int option = Utility.readInteger();
						switch (option) 
						{
							case 0:
								takeAppointment();
								break;
							case 1:
								manager.close();
								break;
						}

					}
				}
				
			}

		}
		System.out.println("No such a doctor present");
		CliniqueManager.doSelectOptions();
	}


}




