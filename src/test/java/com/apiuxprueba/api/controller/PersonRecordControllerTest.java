package com.apiuxprueba.api.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.apiuxprueba.api.model.Person;
import com.apiuxprueba.api.repository.PersonRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@SpringBootTest
public class PersonRecordControllerTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void createPerson() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date date = formatter.parse("07-01-2022");
        Person p = new Person();
        p.setName("Macarena");
        p.setUserName("mripamonti");
        p.setDate(date);
        personRepository.save(p);
        assertNotNull(personRepository.findById(1L).get());
    }

    @Test
    public void readAll(){
        List<Person> person = personRepository.findAll();
        assertThat(person).size().isGreaterThan(0);
    }

    @Test
    public void singlePerson(){
        Person p = personRepository.findById(1L).get();
        assertEquals("Macarena", p.getName());
    }

    @Test
    public void updatePerson(){
        Person p = personRepository.findById(1L).get();
        p.setName("Maca");
        personRepository.save(p);
        assertNotEquals("Macarena", personRepository.findById(1L).get().getName());
    }

    @Test
    public void deletePerson(){
        personRepository.deleteById(1L);
        assertThat(personRepository.existsById(1L)).isFalse();
    }

}
