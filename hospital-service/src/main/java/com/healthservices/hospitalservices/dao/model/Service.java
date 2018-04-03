package com.healthservices.hospitalservices.dao.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity	
public class Service {
	
	@Id
	@GeneratedValue
	private Long serviceId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hospitalId")
	private Hospital hospital;
	
	private Double price;
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	private String serviceName;
	
	public Service(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public Service() {
	}
	
	@Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }

}
