package edu.itstep.cityadder.city;

import edu.itstep.cityadder.city.Exception.CityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }
    @GetMapping(path = "/cities")
    public List<City> getCitiesPlace(){
        return cityService.getCityPlace();
    }

    @PostMapping(path = "/cities")
    public void registerNewCityPlace(@RequestBody City cityPlace){
        cityService.addNewCityPlace(cityPlace);
    }

    @GetMapping("/cities/id/{id}")
    public Optional<City> getCityById(@PathVariable Long id){
        return Optional.ofNullable(cityService.getCityById(id).orElseThrow(() -> new CityNotFoundException(id)));
    }
    @DeleteMapping(path = "{id}")
    public void deleteCityPlace(@PathVariable("id") Long id){
        cityService.deleteCityPlace(id);
    }

    @PutMapping(path = "{id}")
    public void updateCityPlace(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String cityPlace,
            @RequestParam(required = false) String country){
        cityService.updateCity(id, cityPlace, country);
    }
}