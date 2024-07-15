package org.itstep.app3;

import org.itstep.app2.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller //!!!
@RequestMapping("/persons")
public class PersonController {
    private List<Person> persons = new ArrayList<>();
    {
        persons.add(new Person(1L, "Иван", "Иванов"));
        persons.add(new Person(2L, "John", "Doe"));
        persons.add(new Person(3L, "Jane", "Smith"));
        persons.add(new Person(4L, "Bob", "Johnson"));
    }

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message", "Привет из Freemarker");
        return "index";
    }

    @GetMapping({"/","","index"})
    public String gelAllPersons(Model model){
        model.addAttribute("persons", persons);
        return "persons";
    }

    @PostMapping({"/",""})
    public String createPerson(Model model, @ModelAttribute("person") Person person){
        System.out.println("ok");
        persons.add(person);
        model.addAttribute("persons", persons);
        return "/persons";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(Model model, @PathVariable("id") Long id){
        Person person =
                persons.stream()
                        .filter(p->p.getId().equals(id))
                        .findFirst()
                        .orElse(null);
        persons.remove(person);
        model.addAttribute("persons", persons);
        return "/persons";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(Model model, @PathVariable("id") Long id, @ModelAttribute("person") Person person){
        Person personOld = persons.stream()
                        .filter(p->p.getId().equals(id))
                        .findFirst()
                        .orElse(null);
        personOld.setName(person.getName());
        personOld.setSurname(person.getSurname());
        model.addAttribute("persons", persons);
        return "/persons";
    }
}

