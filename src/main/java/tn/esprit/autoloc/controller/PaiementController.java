package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementController {
    private final IPaiementService paiementService;

    @GetMapping("/getAll")
    public List<Paiement> getAllPaiements(){
        return paiementService.afficherPaiements();
    }

    @GetMapping("/get/{idPaiement}")
    public Paiement getPaiement(@PathVariable Long idPaiement){
        System.out.println(idPaiement);
        return paiementService.afficherPaiementById(idPaiement);
    }

    @PostMapping("/new")
    public Paiement addPaiement(@RequestBody Paiement paiement){
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping("/edit")
    public Paiement editPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @DeleteMapping("/delete/{idPaiement}")
    public void deletePaiement(@PathVariable Long idPaiement){
        paiementService.supprimerPaiementById(idPaiement);
    }
}
