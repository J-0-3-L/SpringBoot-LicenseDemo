package com.joel.manejo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joel.manejo.models.License;
import com.joel.manejo.models.Person;
import com.joel.manejo.repositories.LicenseRepository;
import com.joel.manejo.repositories.PersonRepository;
import com.joel.manejo.servicies.ManejoServicio;

@Controller
public class ManejoController {

    @Autowired
    private PersonRepository repositorioPersona;
    @Autowired
    private LicenseRepository repositorioLicencia;
    @Autowired
    private ManejoServicio manejoServicio;

    // Principal
    @GetMapping("/")
    public String ini() {
        return "index";
    }

    // Mostrar All
    @GetMapping("/dashboard")
    public String dash(Model model) {
        List<Person> people = repositorioPersona.findAll();
        List<License> licensesWithPerson = manejoServicio.getAllLicensesWithPerson();
        model.addAttribute("people", people);
        model.addAttribute("permission", licensesWithPerson);
        return "Manejo";
    }

    // Mostrar for ID person
    @GetMapping("/persons/{id}")
    public String viewId(@PathVariable Long id, Model model) {
        Person persona = repositorioPersona.findById(id).orElse(null);
        model.addAttribute("person", persona);
        return "detail";
    }

    // Mostrar for ID license
    @GetMapping("/licenses/{id}")
    public String viewIdLicense(@PathVariable Long id, Model model) {
        License licencia = repositorioLicencia.findById(id).orElse(null);
        model.addAttribute("license", licencia);
        return "detail";
    }

    // Create new person
    @GetMapping("/person/new")
    public String viewAddPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/person/new")
    public String addPerson(@ModelAttribute("person") Person persona) {
        repositorioPersona.save(persona);
        return "redirect:/license/new";
    }

    // Create new license
    @GetMapping("/license/new")
    public String viewAddLicense(Model model) {
        List<Person> persons = manejoServicio.getAllPersons();
        model.addAttribute("persons", persons);
        model.addAttribute("license", new License());
        return "license";
    }

    @PostMapping("/license/new")
    public String addLicense(@ModelAttribute("license") License licencia, @RequestParam("person_id") Long personId) {
    Person persona = manejoServicio.getPersonById(personId);
    if (persona != null) {
        String licenseNumber = manejoServicio.getNextLicenseNumber();
        licencia.setNumber(licenseNumber);
        licencia.setPerson(persona);
        manejoServicio.saveLicense(licencia);
    }
        return "redirect:/dashboard";
    }



}
