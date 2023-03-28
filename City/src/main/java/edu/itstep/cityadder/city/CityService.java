package edu.itstep.cityadder.city;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public List<City> getCityPlace(){
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id){
        return cityRepository.findById(id);
    }

    public void addNewCityPlace(City cityPlace){
        Optional<City> optionalCity= cityRepository.findById(cityPlace.getId());
        if(optionalCity.isPresent()){
            throw new IllegalStateException(" \"This id:\" + \"[\" + cityPlace.getId() + \"] is taken\"");
        }
        cityRepository.save(cityPlace);
    }

    public void deleteCityPlace(Long id) {
        boolean exists = cityRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "City with id [" + id + "] doesn't exists");
        }
        cityRepository.deleteById(id);
    }

    @Transactional
    public void updateCity(Long id,
                            String cities,
                            String country) {
        City cityPlace = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "City with id [" + id + "] doesn't exists"));

        if (cities != null &&
                cities.length() > 0 &&
                !Objects.equals(cityPlace.getCityPlace(), cities)) {
            Optional<City> cityOptional = cityRepository
                    .findByCityPlace(cities);
            if (cityOptional.isPresent()) {
                throw new IllegalStateException("City is entered");
            }
            cityPlace.setCityPlace(cities);
        }
        if (country != null &&
                country.length() > 0 &&
                !Objects.equals(cityPlace.getCountry(), country)) {
            cityPlace.setCountry(country);
        }

    }

}
