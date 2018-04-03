package com.healthservices.hospitalservices;

import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;

import com.healthservices.hospitalservices.dao.model.City;
import com.healthservices.hospitalservices.dao.model.Hospital;
import com.healthservices.hospitalservices.dao.model.Service;
import com.healthservices.hospitalservices.dao.model.State;

@EnableDiscoveryClient
@SpringBootApplication
public class HospitalServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalServicesApplication.class, args);
	}
}

@Component
class SampleDataCLR implements CommandLineRunner {

	private final HospitalRepository hospitalRepository;
	private final ServiceRepository serviceRepository;
	private final CityRepository cityRepository;
	private final StateRepository stateRepository;

	@Autowired
	public SampleDataCLR(HospitalRepository hospitalRepository,
			ServiceRepository serviceRepository,CityRepository cityRepository, StateRepository stateRepository) {
		this.hospitalRepository = hospitalRepository;
		this.serviceRepository = serviceRepository;
		this.cityRepository = cityRepository;
		this.stateRepository = stateRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		State state = new State("karnataka");
		stateRepository.save(state);
		Stream.of("bangalore", "mangalore", "mysore", "tumkur").forEach( c -> {
			City city = new City(c);
			city.setState(state);
			cityRepository.save(city);
			Stream.of("Apollo", "Manipal", "St. John", "Fortis").forEach(
					h -> {
						Hospital hospital = new Hospital(h);
						hospital.setCity(city);
						hospitalRepository.save(hospital);
						Stream.of("X-Ray", "MRI", "Angioplasty", "Chemotherapy")
								.forEach(t -> {
									Service s = new Service(t);
									s.setHospital(hospital);
									s.setPrice(Math.random());
									serviceRepository.save(s);
								});
					});
		});
		
		hospitalRepository.findAll().forEach(System.out::println);
		
		serviceRepository.findAll().forEach(System.out::println);
	}
}

@RepositoryRestResource
interface HospitalRepository extends JpaRepository<Hospital, Long> {

	@RestResource(path = "by-name")
	Collection<Hospital> findByHospitalName(@Param("hn") String hn);
}

@RepositoryRestResource
interface ServiceRepository extends JpaRepository<Service, Long> {

}

@RepositoryRestResource
interface CityRepository extends JpaRepository<City, String> {

}

@RepositoryRestResource
interface StateRepository extends JpaRepository<State, String> {

}
