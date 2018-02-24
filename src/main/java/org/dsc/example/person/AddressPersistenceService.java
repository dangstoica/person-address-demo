package org.dsc.example.person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.dsc.example.person.model.City;
import org.dsc.example.person.model.Country;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author dan.stoica
 *
 */
@Service
@Scope("singleton")
@Transactional
public class AddressPersistenceService {

	@PersistenceContext
	private EntityManager em;

	public List<Country> findCountries() {
		Query q = em.createNamedQuery("Country.findAll");
		return q.getResultList();
	}

	public List<City> findCities() {
		Query q = em.createNamedQuery("City.findAll");
		return q.getResultList();
	}

	public City findCityByName(String name) {
		try {
			Query q = em.createNamedQuery("City.findByName");
			q.setParameter("name", name);
			return (City) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public City findCityById(Long id) {
		try {
			City c = em.find(City.class, id);
			return c;
		} catch (Exception e) {
			return null;
		}
	}
}
