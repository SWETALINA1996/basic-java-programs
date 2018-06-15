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
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.service.DoctorService;
import com.bridgelabz.utility.Utility;

public class DoctorServiceImplementation implements DoctorService
{
	static String doctorFile = "/home/bridgelabz/Documents/sweta/"
			+ "BasicPrograms/CliniqueManagement/src/com/bridgelabz/files/Doctor.json";

	
	static ArrayList<Doctor> doctorList = new ArrayList<>();

	public DoctorServiceImplementation(String doctorFile2)
	{
		Utility.convertJsonToList(doctorFile,doctorList);
	}
	public DoctorServiceImplementation()
	{
	}

	@Override
	public void showDoctorDetails() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		
			Object object = parser.parse(new FileReader(doctorFile));
			JSONArray doctorArray = (JSONArray) object;
			for (int i = 0; i < doctorArray.size(); i++) {
				JSONObject details = (JSONObject) doctorArray.get(i);
				System.out.println("index : " + i + " " + details);
			}
	
		
	}

	@Override
	public Doctor searchDoctorByName() 
	{
		System.out.println("Enter doctor name:");
		String searchName=Utility.readString();
		for(int i=0;i<doctorList.size();i++)
		{
			if(doctorList.get(i).getDoctorName().equalsIgnoreCase(searchName))
			{
				return doctorList.get(i);
			}
		}
		return null;

	}

	


	@Override
	public ArrayList<Doctor> searchDoctorByAvailability() 
	{
		ArrayList<Doctor>list=new ArrayList<>();
		System.out.println("Enter doctor Availability:");
		String available=Utility.readString();
		for(int i=0;i<doctorList.size();i++)
		{
			if(doctorList.get(i).getAvailability().equalsIgnoreCase(available))
			{
				list.add(doctorList.get(i));
			}
		}
		return list;
	}

	public ArrayList<Doctor> searchDoctorBySpecialization(ArrayList<Doctor>list,String specialization)
	{
		for(int i=0;i<doctorList.size();i++)
		{
			if(doctorList.get(i).getSpecialization().equalsIgnoreCase(specialization))
			{
				list.add(doctorList.get(i));
			}
		}
		return list;
	}
	
	@Override
	public Doctor searchDoctorById()
	{
		System.out.println("Enter doctor ID:");
		long doctorId=Utility.readLong();
		for(int i=0;i<doctorList.size();i++)
		{
			if(doctorList.get(i).getDoctorId()==doctorId)
			{
				return doctorList.get(i);
			}
		}
		return null;
	
	}

	@Override
	public void searchPopulardoctor() {
		ArrayList<Doctor>popularDoctor=	checkPopularity();
		for(int i =0;i<popularDoctor.size();i++)
		{
			System.out.println("Popular doctor is : "+popularDoctor.get(i).getDoctorName());
		}
	}

	@Override
	public void searchPopularSpecialization() {
		ArrayList<Doctor>popularSpecialization=checkPopularity();
		for(int i=0;i<popularSpecialization.size();i++)
		{
			System.out.println("Popular Specialization : "+popularSpecialization.get(i).getSpecialization());
		}
	}
	private ArrayList<Doctor> checkPopularity() {
		ArrayList<Long>patientCount=new ArrayList<>();
		ArrayList<Doctor>popularDoctor=new ArrayList<>();
		for(int i=0;i<doctorList.size();i++)
		{
			patientCount.add(doctorList.get(i).getCountOfPatients());
		}
		Collections.sort(patientCount);
		int rank=patientCount.size()-1;
		for(int i=0;i<doctorList.size();i++)
		{
		if(patientCount.get(rank)==doctorList.get(i).getCountOfPatients())
			{
				popularDoctor.add(doctorList.get(i));
			}
		}
		return popularDoctor;
	}
	@Override
	public ArrayList<Doctor> searchDoctorBySpecialisation(ArrayList<Doctor> list, String specialization) {
		
		return null;
	}

}
