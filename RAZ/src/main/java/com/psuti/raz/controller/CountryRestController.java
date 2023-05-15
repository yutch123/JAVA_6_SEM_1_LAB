package com.psuti.raz.controller;

import com.psuti.raz.Repository.CountryRepository;
import com.psuti.raz.entity.Country;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryRestController {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryRestController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Country> getAll() {
        List<Country> countries = countryRepository.findAll();
        List<Country> countriesWithPopulation = new ArrayList<>();
        Country country;
        for (int i = 0; i < countries.size(); i++) {
            country = countryRepository.findByName(countries.get(i).getName());
            country.population = countryRepository.getPopulation(country.getName());
            countriesWithPopulation.add(country);
        }
        return countriesWithPopulation;
    }


    @GetMapping("/{name}")
    public Country getByName(@PathVariable("name") String name) {
        Country country = countryRepository.findByName(name);
        country.population = countryRepository.getPopulation(country.getName());
        return country;
    }


    @DeleteMapping("/{name}")
    public void remove(@PathVariable("name") String name) {
        countryRepository.deleteCountryBy(name);
    }

    @PutMapping
    public Country update(@RequestBody Country country) {
        if (countryRepository.existsByName(country.getName())) {
            return countryRepository.save(country);
        }
        throw new EntityExistsException("Country with name:'" + country.getName() + "' doesn't exists");
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        String name = country.getName();
        if (name != null) {
            if (countryRepository.existsByName(country.getName())) {
                throw new EntityExistsException("Country already exists");
            }
        }
        return countryRepository.save(country);
    }
}
