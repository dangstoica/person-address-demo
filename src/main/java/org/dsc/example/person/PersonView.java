package org.dsc.example.person;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.dsc.example.person.model.City;
import org.dsc.example.person.model.Country;
import org.dsc.example.person.model.Person;
import org.dsc.example.person.model.PersonRelationshipsType;

@ViewScoped
@ManagedBean(name = "personView")
@Named
public class PersonView {

	private Person person = new Person();

	@Inject
	PersonManager manager;

	@Inject
	AddressManager addressManager;

	public Person getPerson() {
		return person;
	}

	public void createPerson() {
		this.person = new Person();
	}

	public void save(Person person) {
		manager.save(person);
		createPerson();
	}

	public void delete(Person person) {

	}

	public List<Person> getAllPersons() {
		return manager.getAllPersons();
	}

	public List<Country> getCountries() {
		return addressManager.getCountries();
	}

	public List<City> getCities() {
		return addressManager.getCities();
	}

	public void setCityById(Long id) {
		City city = addressManager.findCityById(id);
		this.person.getAddress().setCity(city);
	}

	public Long getCityById() {
		return this.person.getAddress().getCity().getCityId();
	}

	public PersonRelationshipsType[] getRelationships() {
		return PersonRelationshipsType.values();
	}
}
