package org.dsc.example.person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.dsc.example.person.model.City;
import org.dsc.example.person.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author dan.stoica
 *
 */
@Service
@Scope("singleton")
@Transactional
public class PersonPersistenceService {
	Logger log = LoggerFactory.getLogger(getClass());

	@PersistenceContext
	private EntityManager em;

	// private final AtomicLong idGenerator = new AtomicLong();
	// Map<Long, ToDoItem> items = new HashMap<>();

	public Person findPerson(Long itemId) throws ItemNotFoundException {
		Person person = em.find(Person.class, itemId);
		if (person != null) {
			log.trace("Lookup Person {} succesfull", person);
			return person;
		}
		log.error("fail to find Item {} ", person);
		throw new ItemNotFoundException();
	}

	public Person create(Person person) {
		log.debug("Create new Item request : {}", person);
		Long cityId = person.getAddress().getCity().getCityId();
		City city = em.find(City.class, cityId);
		person.getAddress().setCity(city);
		em.persist(person.address);
		em.persist(person);
		em.flush();
		return person;
	}

	public Person update(Person person) throws ItemNotFoundException {
		log.debug("Update request for item with id:{}", person.getPersonId());
		Person item = em.find(Person.class, person.getPersonId());
		if (item != null) {
			em.merge(item);
			em.flush();
			return item;
		}
		throw new ItemNotFoundException();
	}

	public void delete(Long itemId) {
		try {
			Person item = em.getReference(Person.class, itemId);
			em.remove(item);
		} catch (EntityNotFoundException e) {
			log.error("Item already removed for id:{}", itemId);
		}
	}

	public List<Person> findAllPersons() {
		Query q = em.createNamedQuery("Person.findAll");
		return q.getResultList();

	}

}
