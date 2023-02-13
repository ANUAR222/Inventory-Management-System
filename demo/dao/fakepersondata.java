package com.example.demo.dao;

import com.example.demo.model.person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakedao")
public class fakepersondata implements personDAo {
    public static List<person> DB = new ArrayList<>();

    @Override
    public boolean insertPerson(UUID id, person person) {
        DB.add(new person(person.getName(), person.getEmail(),person.getPassword(), person.getPhone(), person.getAddress()));
        return true;
    }

    @Override
    public boolean insertPerson(person person) {
        if (person.getEmail().contains("@gmail.com") && person.getPassword().length() > 6){
            DB.add(new person(person.getName(), person.getEmail(), person.getPassword(), person.getPhone(), person.getAddress()));
            return true;
        }
        return false;
    }
    @Override
    public List<person> selectAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, person person) {
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if(indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new person(person.getName(), person.getEmail(),person.getPassword(), person.getPhone(), person.getAddress()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public person selectPersonByEmail_paword(String email, String password) {
      for (person p:DB) {
          if(p.getEmail().equals(email) && p.getPassword().equals(password)){
              return p;
          }
      }
        return null;
    }

    public person getpresonbyid(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
