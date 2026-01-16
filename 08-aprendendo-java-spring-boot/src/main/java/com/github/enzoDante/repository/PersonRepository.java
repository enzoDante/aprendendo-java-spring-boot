package com.github.enzoDante.repository;

import com.github.enzoDante.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
