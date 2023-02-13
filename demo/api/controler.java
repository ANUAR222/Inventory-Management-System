package com.example.demo.api;
import com.example.demo.service.personService;
import com.example.demo.model.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileDescriptor;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/person")
@RestController
public class controler {
    private final personService personService;
    @Autowired
    public controler(personService personService) {
        this.personService = personService;
    }
    @PostMapping
    public boolean addPerson(@RequestBody person person) {
        return personService.addPerson(person);
    }
    @GetMapping
    public List<person> getAllPeople() {
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping
    public boolean deletePerson(@RequestBody person person) {
       return personService.deletePerson_by_emil(person.getEmail(),person.getPassword());
    }
    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody person person) {
        personService.updatePerson(id, person);
    }
    @PostMapping("/register")
    public void registerUser(@RequestBody person user) {
        if (personService.getPersonByEmail(user.getEmail(),user.getPassword())!=null){
            personService.addPerson(user);
        }
        return;
    }
    @GetMapping("/login")
    public UUID loginUser(@RequestBody person user) {
        if (personService.getPersonByEmail(user.getEmail(), user.getPassword()) != null){
            return personService.getPersonByEmail(user.getEmail(), user.getPassword());
        }
        return null;
    }
}
