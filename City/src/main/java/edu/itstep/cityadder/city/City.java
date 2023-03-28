package edu.itstep.cityadder.city;

import jakarta.persistence.*;

@Table
@Entity
public class City {

    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    @Id
    private Long id;
    private String cityPlace;
    private String country;

    public City() {
    }

    public City(String cityPlace, String country) {
        this.cityPlace = cityPlace;
        this.country = country;
    }

    public City(Long id, String cityPlace, String country) {
        this.id = id;
        this.cityPlace = cityPlace;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityPlace() {
        return cityPlace;
    }

    public void setCityPlace(String cityPlace) {
        this.cityPlace = cityPlace;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + cityPlace + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
