package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceController {
    private final IAgenceService agenceService;

    @GetMapping("/getAll")
    public List<Agence> getAllAgences(){
        return agenceService.afficherAgences();
    }

    @GetMapping("/get/{idAgence}")
    public Agence getAgence(@PathVariable Long idAgence){
        System.out.println(idAgence);
        return agenceService.afficherAgenceById(idAgence);
    }

    @PostMapping("/new")
    public Agence addAgence(@RequestBody Agence agence){
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping("/edit")
    public Agence editAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @DeleteMapping("/delete/{idAgence}")
    public void deleteAgence(@PathVariable Long idAgence){
        agenceService.supprimerAgenceById(idAgence);
    }
}
