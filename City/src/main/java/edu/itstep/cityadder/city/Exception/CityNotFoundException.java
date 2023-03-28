package edu.itstep.cityadder.city.Exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(Long id) { super("Could not find city with [" + id + "]"); }
}