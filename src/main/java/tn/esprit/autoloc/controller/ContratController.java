package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {
    private final IContratService contratService;

    @GetMapping("/getAll")
    public List<Contrat> getAllContrats(){
        return contratService.afficherContrats();
    }

    @GetMapping("/get/{idContrat}")
    public Contrat getContrat(@PathVariable Long idContrat){
        System.out.println(idContrat);
        return contratService.afficherContratById(idContrat);
    }

    @PostMapping("/new")
    public Contrat addContrat(@RequestBody Contrat contrat){
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping("/edit")
    public Contrat editContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @DeleteMapping("/delete/{idContrat}")
    public void deleteContrat(@PathVariable Long idContrat){
        contratService.supprimerContratById(idContrat);
    }
}
