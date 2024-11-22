package sg.nus.edu.iss.vttp_5a_ssf_day15l.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.nus.edu.iss.vttp_5a_ssf_day15l.model.Person;
import sg.nus.edu.iss.vttp_5a_ssf_day15l.service.PersonService;

@Controller
@RequestMapping("/tests")
public class TestController {
    @Autowired
    PersonService personSvc;

    @ResponseBody
    @GetMapping("/add")
    public String addPerson() {
        Person p = new Person(1, "darryl", "darryl@nus.edu.sg");
        personSvc.addPerson("persons", p);
        p = new Person(2, "chuk", "chuk@nus.edu.sg");
        personSvc.addPerson("persons", p);
        p = new Person(3, "kenneth", "kenneth@nus.edu.sg");
        personSvc.addPerson("persons", p);

        return "added persons successfully";
    }

    @GetMapping("/persons")
    public String personFindAll(Model model) {
        model.addAttribute("persons", personSvc.findAll("persons"));
        return "personlist";
    }
    
    @ResponseBody
    @GetMapping("/delete")
    public Boolean deletePerson() {

        Person p = new Person(3, "kenneth", "kenneth@nus.edu.sg");
        return personSvc.delete("persons", p);
    }
}