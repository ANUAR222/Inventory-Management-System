package com.example.demo.service;

import com.example.demo.model.person;
import com.example.demo.dao.personDAo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class personService {
    private final personDAo personDAo;
    public List<person> getAllPeople() {
        return personDAo.selectAllPeople();
    }
    @Autowired
    public personService(@Qualifier("fakedao") personDAo personDAo) {
        this.personDAo = personDAo;
    }

    public boolean addPerson(person person) {
        return personDAo.insertPerson(person);
    }
    public Optional<person> getPersonById(UUID id) {
        return personDAo.selectPersonById(id);
    }
    public boolean deletePerson_by_emil(String email, String password) {
        return personDAo.deletePersonById(personDAo.selectPersonByEmail_paword(email, password).getId()) == 1;
    }
    public int deletePerson(UUID id) {
        return personDAo.deletePersonById(id);
    }
    public int updatePerson(UUID id, person person) {
        return personDAo.updatePersonById(id, person);
    }
    public UUID getPersonByEmail(String email, String password) {
        return personDAo.selectPersonByEmail_paword(email, password).getId();
    }

}
