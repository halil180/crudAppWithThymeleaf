package ch.bfh.ti.controller;


import ch.bfh.ti.PersonContainer;
import ch.bfh.ti.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class PersonController {

    private final PersonContainer personContainer;

    public PersonController(PersonContainer personContainer){
        this.personContainer = personContainer;
    }

    @RequestMapping(path = {"/","index"},method = RequestMethod.GET)
    public String index(Model model){

        List<Person> persons = personContainer.getPersons();
        model.addAttribute("persons",persons);
        model.addAttribute("person",new Person());
        return  "index";
    }

    @RequestMapping(path = "/createPerson",method = RequestMethod.POST)
    public  String createPerson(Person person,Model model){
        List<Person> persons = personContainer.getPersons();
        persons.add(person);
        model.addAttribute("persons",persons);
        model.addAttribute("person",new Person());
        return  "index";
    }

}
