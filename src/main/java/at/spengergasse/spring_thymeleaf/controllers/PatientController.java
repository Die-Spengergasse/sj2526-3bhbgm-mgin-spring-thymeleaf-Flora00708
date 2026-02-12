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

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/list")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll()); // find all findet alle patienten in der datenbank und gibt sie als liste zurück, damit können wir sie in der view anzeigen, die view ist die patlist.html, die wir später erstellen werden, damit können wir die patienten in der datenbank anzeigen, das ist die standardfunktionalität von jpa repository, wir müssen nur die interface erweitern und die entity klasse und den primärschlüsseltyp angeben
        return "patlist";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientRepository.save(patient);
        return  "redirect:/patient/list";
    }
}
