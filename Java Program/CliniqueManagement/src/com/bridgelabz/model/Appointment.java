/******************************************************************************
 *  
 *  Purpose:  
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   11-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.model;

public class Appointment
{
	String patientName;
	long patientId;
	String doctorName;
	long doctorId;
	public String getPatientName() 
	{
		return patientName;
	}
	public void setPatientName(String patientName) 
	{
		this.patientName = patientName;
	}
	public long getPatientId()
	{
		return patientId;
	}
	public void setPatientId(long patientId)
	{
		this.patientId = patientId;
	}
	public String getDoctorName()
	{
		return doctorName;
	}
	public void setDoctorName(String doctorName)
	{
		this.doctorName = doctorName;
	}
	public long getDoctorId() 
	{
		return doctorId;
	}
	public void setDoctorId(long doctorId) 
	{
		this.doctorId = doctorId;
	}
	public void setTimeStamp(String timeStamp) {
		// TODO Auto-generated method stub
		
	}
}
