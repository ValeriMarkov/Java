package edu.itstep.cityadder.city;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CityConfig implements CommandLineRunner {

    private final CityRepository cityRepository;

    public CityConfig(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Logger logger = Logger.getLogger(CityConfig.class.getName());
        logger.info("Saving cities...");

        City city1 = new City("New York", "USA");
        City city2 = new City("Paris", "France");
        City city3 = new City("Tokyo", "Japan");

        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);

        logger.info("Cities saved.");
    }
}