package com.github.enzoDante.controllers;

import com.github.enzoDante.model.Person;
import com.github.enzoDante.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;

    @GetMapping(value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") Long id){
        return service.findById(id);

    }
    @GetMapping(value = "/all",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }

    @PostMapping(value = "/create",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person createPerson(@RequestBody Person p){
        return service.create(p);
    }
    @PutMapping(value = "/update",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person updatePerson(@RequestBody Person p){
        return service.update(p);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
