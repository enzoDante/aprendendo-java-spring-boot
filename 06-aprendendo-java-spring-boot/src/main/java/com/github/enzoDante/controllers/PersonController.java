package com.github.enzoDante.controllers;

import com.github.enzoDante.model.Person;
import com.github.enzoDante.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") String id){
        return service.findById(id);

    }
    @RequestMapping(value = "/all",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/create",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person createPerson(@RequestBody Person p){
        return service.create(p);
    }
    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person updatePerson(@RequestBody Person p){
        return service.update(p);
    }
    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE
    )
    public void deletePerson(@PathVariable String id){
        service.delete(id);
    }
}
