package org.dsc.example.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.dsc.example.person.model.City;
import org.dsc.example.person.model.Country;

/**
 * @author dan.stoica
 *
 */
@ManagedBean
@Named
@SessionScoped
public class AddressManager {

	@Inject
	AddressPersistenceService addreesService;

	private List<Country> countries;

	private List<City> cities;
	
	Map<String, City> citiesMap = new HashMap<>();

	public void addCity(String key, City city) {
		citiesMap.put(key, city);
	}

	public City findCityByName(String name) {
		return citiesMap.get(name);
	}

	public List<Country> getCountries() {
		countries = countries == null ? countries = addreesService.findCountries() : countries;
		return countries;
	}

	public List<City> getCities() {
		cities = cities == null ? cities = addreesService.findCities() : cities;
		return cities;
	}


	public City findCityById(Long id) {
		return addreesService.findCityById(id);
	}

}
