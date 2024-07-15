package org.itstep.app3;

import org.itstep.app2.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

