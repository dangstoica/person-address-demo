package org.dsc.example.person.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author dan.stoica
 * @version 1.0
 * @created 22-Feb-2018 2:02:22 PM
 */
@Entity
public class PersonRelationships {

	@Id
	@Column(name="realationship_id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	public Person parent;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clild_id")
	public Person child;
	
	@Enumerated(EnumType.STRING)
	@Column(name="relationship_type")
	public PersonRelationshipsType personRelationshipsType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonRelationships other = (PersonRelationships) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}