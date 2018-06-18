package com.bridgelabz.creationaldesignpatterns;

public enum EnumSingleton {
	INSTANCE,
	INSTANCE1;
	public static void display() {
		System.out.println(INSTANCE.hashCode());
		System.out.println(INSTANCE1.hashCode());
	}
	public static void main(String[] args) {
		display();
	}
}
