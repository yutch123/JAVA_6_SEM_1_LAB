package com.psuti.raz.controller;

import com.psuti.raz.Repository.CapitalsRepository;
import com.psuti.raz.entity.Capital;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/capitals")
@RestController
public class CapitalRestController {
    private final CapitalsRepository capitalsRepository;

    @Autowired
    public CapitalRestController(CapitalsRepository capitalsRepository) {
        this.capitalsRepository = capitalsRepository;
    }

    @GetMapping
    public List<Capital> getAll() {
        return capitalsRepository.findAll();
    }

    @GetMapping("/{name}")
    public Capital getByName(@PathVariable("name") String name) {
        return capitalsRepository.findByName(name);
    }


    @DeleteMapping("/{name}")
    public void remove(@PathVariable("name") String name) {
        capitalsRepository.deleteCapitalBy(name);
    }

    @PutMapping
    public Capital update(@RequestBody Capital capital) {
        if (capitalsRepository.existsByName(capital.getName())) {
            return capitalsRepository.save(capital);
        }
        throw new EntityExistsException("Capital with name:'" + capital.getName() + "' doesn't exists");
    }

    @PostMapping
    public Capital create(@RequestBody Capital capital) {
        String name = capital.getName();
        if (name != null) {
            if (capitalsRepository.existsByName(capital.getName())) {
                throw new EntityExistsException("Capital already exists");
            }
        }
        return capitalsRepository.save(capital);
    }
}
