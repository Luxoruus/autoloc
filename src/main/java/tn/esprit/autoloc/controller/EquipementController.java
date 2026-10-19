package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementController {
    private final IEquipementService equipementService;

    @GetMapping("/getAll")
    public List<Equipement> getAllEquipements(){
        return equipementService.afficherEquipements();
    }

    @GetMapping("/get/{idEquipement}")
    public Equipement getEquipement(@PathVariable Long idEquipement){
        System.out.println(idEquipement);
        return equipementService.afficherEquipementById(idEquipement);
    }

    @PostMapping("/new")
    public Equipement addEquipement(@RequestBody Equipement equipement){
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/edit")
    public Equipement editEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @DeleteMapping("/delete/{idEquipement}")
    public void deleteEquipement(@PathVariable Long idEquipement){
        equipementService.supprimerEquipementById(idEquipement);
    }
}
