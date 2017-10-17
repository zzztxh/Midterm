package com.cisc181.core;


public class PersonException extends Exception {
	private Person person;
	
	public PersonException(Person p, String Message) {
		super(Message);
		this.person = p;
	}
	
	public Person getP() {
		return person;
	}
}