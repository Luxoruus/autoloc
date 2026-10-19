package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @GetMapping("/getAll")
    public List<Vehicule> getAllVehicules(){
        return vehiculeService.afficherVehicules();
    }

    @GetMapping("/get/{idVehicule}")
    public Vehicule getVehicule(@PathVariable Long idVehicule){
        System.out.println(idVehicule);
        return vehiculeService.afficherVehiculeById(idVehicule);
    }

    @PostMapping("/new")
    public Vehicule addVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping("/edit")
    public Vehicule editVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @DeleteMapping("/delete/{idVehicule}")
    public void deleteVehicule(@PathVariable Long idVehicule){
        vehiculeService.supprimerVehiculeById(idVehicule);
    }
}
