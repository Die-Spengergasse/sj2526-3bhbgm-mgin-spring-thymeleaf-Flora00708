package at.spengergasse.spring_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// keine abhängigkeit, wird auch automatisch geladen
@Controller
public class HelloController {

//get mapping heißt, das wenn get 8080 aufgerufen wird, kommt diese méthode dran
// unter view --> tool windows --> endpoints, bekommt man alle dinge auf die man über die website kommt also welche in der adresse hinters / kommen könnnen
    // modell view controller konzept
    @GetMapping("")
    public  String index(Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        model.addAttribute("today", LocalDate.now().format(dtf));
        return "index";
    }
}
