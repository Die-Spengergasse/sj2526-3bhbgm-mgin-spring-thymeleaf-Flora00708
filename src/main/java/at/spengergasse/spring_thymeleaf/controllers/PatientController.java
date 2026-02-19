package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.entities.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;

// notations, damit das framework sie findet und instanziiert
// bei springboot müssen wir kein new schreiben sondern schreiben nur einen construktor, in dem das übergeben wird
//

// Controller ist eine notation, damit wird die klasse als controller erkannt, damit wird sie automatisch instanziiert und mit anderen klassen verbunden, die in der gleichen package oder in einem Unterpackage liegen, damit können wir auf die patienten zugreifen, die in der datenbank gespeichert sind, und wir können auch neue patienten hinzufügen, löschen und bearbeiten, das ist die standardfunktionalität von jpa repository, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben

@Controller
@RequestMapping("/patient")
// /patient wird von Requenstmappping in der urls gesucht und wenn es vorkommt, wird die methode aufgerufen, die mit der notation getmapping oder postmapping versehen ist
public class PatientController {
    private final PatientRepository patientRepository;
    // patient reposetory ist zugriff auf die patienten in der date

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // get mapping heißt, das wenn get 8080/patient/list aufgerufen wird, kommt diese méthode dran, damit können wir die patienten in der datenbank anzeigen
    @GetMapping("/list")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll()); // find all findet alle patienten in der datenbank und gibt sie als liste zurück, damit können wir sie in der view anzeigen, die view ist die patlist.html, die wir später erstellen werden, damit können wir die patienten in der datenbank anzeigen, das ist die standardfunktionalität von jpa repository, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben
        return "patlist"; // ruft patlist template auf
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient"; // ruft add_patient template auf
    }

    // post mapping kommt, wenn der patient eingegeben wurde und macht den patineten in die db
    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientRepository.save(patient);
        return  "redirect:/patient/list"; // danach scickt er uns wieder zurück zur liste
    }
}
