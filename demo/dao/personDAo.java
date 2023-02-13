package com.example.demo.dao;
import com.example.demo.model.person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface personDAo {
    boolean insertPerson(UUID id, person person);
    default boolean insertPerson(person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    List<person> selectAllPeople();
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, person person);
    Optional<person> selectPersonById(UUID id);

    person selectPersonByEmail_paword(String email,String password);
}
