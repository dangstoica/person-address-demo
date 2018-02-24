package org.dsc.example.person.model;

/**
 * @author dan.stoica
 * @version 1.0
 * @created 22-Feb-2018 2:02:22 PM
 */
public class PersonRelationships {

	public Person parent;
	public Person child;
	public PersonRelationshipsType personRelationshipsType;

	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

	public Person getChild() {
		return child;
	}

	public void setChild(Person child) {
		this.child = child;
	}

	public PersonRelationshipsType getPersonRelationshipsType() {
		return personRelationshipsType;
	}

	public void setPersonRelationshipsType(PersonRelationshipsType personRelationshipsType) {
		this.personRelationshipsType = personRelationshipsType;
	}

}