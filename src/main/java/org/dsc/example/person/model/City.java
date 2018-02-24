package org.dsc.example.person.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author dan.stoica
 * @version 1.0
 * @created 22-Feb-2018 2:02:21 PM
 */
@Entity
@Table(name = "city")
@NamedQueries({
    @NamedQuery(name="City.findAll",
                query="SELECT c FROM City c"),
    @NamedQuery(name="City.findByName",
                query="SELECT c FROM City c WHERE c.name = :name"),
})
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "city_id")
	public Long cityId;

	public String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")
	public Country country;

	public City() {

	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}