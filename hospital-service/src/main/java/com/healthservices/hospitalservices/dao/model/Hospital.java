package com.healthservices.hospitalservices.dao.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	
	@Id
    @GeneratedValue
    private Long hospitalId;

    private String hospitalName;
    
    @OneToMany(mappedBy="hospital")
	private Collection<Service> services;

    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cityName")
    private City city;
    
    public Hospital() {
	}
    
    public Collection<Service> getServices() {
		return services;
	}

	public void setServices(Collection<Service> services) {
		this.services = services;
	}

    public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
    public String toString() {
        return "Hospital{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }

    public Hospital(String reservationName) {
        this.hospitalName = reservationName;
    }
    
    public String getHospitalName() {
        return hospitalName;
    }

}
