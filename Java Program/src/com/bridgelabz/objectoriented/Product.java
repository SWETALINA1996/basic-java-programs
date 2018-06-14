package com.bridgelabz.objectoriented;

public class Product {

	private String name;
	private long weight;
	private long price;
	
	public String getName()
	{
		return name;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}
}
