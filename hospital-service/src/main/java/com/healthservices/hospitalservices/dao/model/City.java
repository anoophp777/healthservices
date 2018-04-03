package com.healthservices.hospitalservices.dao.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id
    private String cityName;
	
	@OneToMany(mappedBy="city")
	private Collection<Hospital> hospitals;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stateName")
	private State state;
	
	public Collection<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(Collection<Hospital> hospitals) {
		this.hospitals = hospitals;
	}

    public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City() {
	}
    
    public City(String cityName){
    	this.cityName = cityName;
    }
    
    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                '}';
    }
}
