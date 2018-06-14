
/******************************************************************************
 *  
 *  Purpose: Pojo class for inventory data management 
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   31-05-2018
 *
 ******************************************************************************/

package com.bridgelabz.objectoriented;

import java.util.ArrayList;

public class InventoryPojoManagement
{
	ArrayList<Product> riceList = new ArrayList<Product>();	
	ArrayList<Product> pulseList = new ArrayList<Product>();
	ArrayList<Product> wheatList = new ArrayList<Product>();	
	
	public ArrayList<Product> getRiceList()
	{
		return riceList;
	}

	public ArrayList<Product> getPulseList() {
		return pulseList;
	}

	public void setPulseList(ArrayList<Product> pulseList) {
		this.pulseList = pulseList;
	}

	public ArrayList<Product> getWheatList() {
		return wheatList;
	}

	public void setWheatList(ArrayList<Product> wheatList) {
		this.wheatList = wheatList;
	}

	public void setRiceList(ArrayList<Product> riceList) {
		this.riceList = riceList;
	}
}
