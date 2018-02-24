/**
 * 
 */
package org.dsc.example.person;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.dsc.example.person.model.City;
import org.dsc.example.person.model.Country;
import org.dsc.example.person.model.Person;

/**
 * @author dan.stoica
 *
 */
@ManagedBean
@Named
@SessionScoped
public class PersonManager {

	@Inject
	PersonPersistenceService persister;
	
	public void save(Person person) {
		persister.create(person);
	}

	public void delete(Person person) {

	}

	public List<Person> getAllPersons() {
		return persister.findAllPersons();
	}

}
