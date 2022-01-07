package com.apiuxprueba.api.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apiuxprueba.api.model.Person;
import com.apiuxprueba.api.repository.PersonRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository repository;


    @GetMapping("/persons")
    public List<Person> allPersons(){
        return repository.findAll();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/person")
    public Person createPerson(@Valid @RequestBody Person person) {
        return repository.save(person);
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable Long id ,@Valid @RequestBody Person personDetails) {
        Optional<Person> personData = repository.findById(id);
        Person p = personData.get();
        p.setName(personDetails.getName());
        p.setUserName(personDetails.getUserName());
        p.setDate(personDetails.getDate());
        return repository.save(p);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("response", "Usuario eliminado");
            repository.deleteById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
