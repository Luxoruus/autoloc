package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
public class EmployeController {
    private final IEmployeService employeService;

    @GetMapping("/getAll")
    public List<Employe> getAllEmployes(){
        return employeService.afficherEmployes();
    }

    @GetMapping("/get/{idEmploye}")
    public Employe getEmploye(@PathVariable Long idEmploye){
        System.out.println(idEmploye);
        return employeService.afficherEmployeById(idEmploye);
    }

    @PostMapping("/new")
    public Employe addEmploye(@RequestBody Employe employe){
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/edit")
    public Employe editEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @DeleteMapping("/delete/{idEmploye}")
    public void deleteEmploye(@PathVariable Long idEmploye){
        employeService.supprimerEmployeById(idEmploye);
    }
}
