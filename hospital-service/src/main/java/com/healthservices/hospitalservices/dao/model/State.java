package com.healthservices.hospitalservices.dao.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class State {

	@Id
	private String stateName;
	
	@OneToMany(mappedBy="state")
	private Collection<City> cities;

	public State(String stateName) {
		this.stateName = stateName;
	}

	public Collection<City> getCities() {
		return cities;
	}

	public void setCities(Collection<City> cities) {
		this.cities = cities;
	}

	public State() {
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "State{" + "stateName='" + stateName + '\'' + '}';
	}
}
