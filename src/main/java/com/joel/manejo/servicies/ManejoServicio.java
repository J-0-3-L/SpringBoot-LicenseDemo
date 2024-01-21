package com.joel.manejo.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.manejo.models.License;
import com.joel.manejo.models.Person;
import com.joel.manejo.repositories.LicenseRepository;
import com.joel.manejo.repositories.PersonRepository;

@Service
public class ManejoServicio {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private LicenseRepository licenseRepo;

    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }
    
    public Person getPersonById(Long id) {
        return personRepo.findById(id).orElse(null);
    }
    
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    public void saveLicense(License license) {
        licenseRepo.save(license);
    }

    public String getNextLicenseNumber() {
        Long count = licenseRepo.count();
        return String.format("%06d", count + 1);
    }
    
    public void deletePersonById(Long id) {
        personRepo.deleteById(id);
    }

    public List<License> getAllLicensesWithPerson() {
        return licenseRepo.findAllWithPerson();
    }
    
}