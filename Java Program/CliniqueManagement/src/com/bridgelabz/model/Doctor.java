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

public class Doctor {
	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", specialization=" + specialization + ", doctorId=" + doctorId
				+ ", availability=" + availability + ", countOfPatients=" + countOfPatients + "]";
	}
	String doctorName ;
	String specialization;
	long doctorId;
	String availability;
	Long countOfPatients;
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Long getCountOfPatients() {
		return countOfPatients;
	}
	public void setCountOfPatients(Long countOfPatients) {
		this.countOfPatients = countOfPatients;
	}
}
