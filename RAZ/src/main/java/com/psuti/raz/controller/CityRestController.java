package com.psuti.raz.controller;

import com.psuti.raz.Repository.CityRepository;
import com.psuti.raz.entity.City;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityRestController {
    private final CityRepository cityRepository;

    @Autowired
    public CityRestController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @GetMapping("/{name}")
    public City getByName(@PathVariable("name") String name) {
        return cityRepository.findByName(name);
    }
    @PutMapping
    public City update(@RequestBody City city) {
        if (cityRepository.existsByName(city.getName())) {
            return cityRepository.save(city);
        }
        throw new EntityExistsException("City with name:'" + city.getName() + "' doesn't exists");
    }

    @PostMapping
    public City create(@RequestBody City city) {
        String name = city.getName();
        if (name != null) {
            if (cityRepository.existsByName(name)) {
                throw new EntityExistsException("City already exists");
            }
        }
        return cityRepository.save(city);
    }

    @DeleteMapping("/{name}")
    public void remove(@PathVariable("name") String name) {
        cityRepository.deleteCityBy(name);
    }

}
