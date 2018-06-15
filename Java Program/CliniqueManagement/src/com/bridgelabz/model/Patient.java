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

public class Patient 
{
	
@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", patientId=" + patientId + ", mobileNumber=" + mobileNumber
				+ ", ageOfPatient=" + ageOfPatient + "]";
	}
String patientName;
long patientId;
String mobileNumber;
long ageOfPatient;
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public long getPatientId() {
	return patientId;
}
public void setPatientId(long patientId) {
	this.patientId = patientId;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public long getAgeOfPatient() {
	return ageOfPatient;
}
public void setAgeOfPatient(long ageOfPatient) {
	this.ageOfPatient = ageOfPatient;
}
}
