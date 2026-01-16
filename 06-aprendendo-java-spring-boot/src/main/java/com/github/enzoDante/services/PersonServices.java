package com.github.enzoDante.services;

import com.github.enzoDante.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    private List<Person> persons = new ArrayList<Person>();

    public List<Person> findAll(){
        logger.info("Finding all Persons");
        List<Person> personss = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person p = mockPerson(i);
            personss.add(p);
        }
        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person");
//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setFirstName("Leandro");
//        person.setLastName("Costa");
//        person.setAddress("Uberlandia mg");
//        person.setGender("Male");
        for(Person p : persons){
            if(p.getId() == Long.parseLong(id)){
                return p;
            }
        }
        throw new IllegalArgumentException("Pessoa não encontrada");
    }
    public Person create(Person person){
        logger.info("Creating one Person");
        persons.add(person);
        return person;
    }
    public Person update(Person person){
        logger.info("Updating one Person");
        for(Person p : persons){
            if(p.getId().equals(person.getId())){
                p.setFirstName(person.getFirstName());
                p.setLastName(person.getLastName());
                p.setAddress(person.getAddress());
                p.setGender(person.getGender());
                return p;
            }
        }
        throw new IllegalArgumentException("Person not found");
    }
    public void delete(String id){
        logger.info("Deleting one Person");
        for(Person p : persons){
            if(p.getId() == Long.parseLong(id)){
                persons.remove(p);
                return;
            }
        }
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("some address in Brasil");
        person.setGender("Male");
        return person;
    }
}
