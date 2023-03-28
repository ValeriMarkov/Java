package com.api.main.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findById(Long id);
    Optional<City> findByCityPlace(String cityPlace);
    Optional<City> findByCountry(String country);
}
