package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @GetMapping("/getAll")
    public List<Maintenance> getAllMaintenances(){
        return maintenanceService.afficherMaintenances();
    }

    @GetMapping("/get/{idMaintenance}")
    public Maintenance getMaintenance(@PathVariable Long idMaintenance){
        System.out.println(idMaintenance);
        return maintenanceService.afficherMaintenanceById(idMaintenance);
    }

    @PostMapping("/new")
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance){
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping("/edit")
    public Maintenance editMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @DeleteMapping("/delete/{idMaintenance}")
    public void deleteMaintenance(@PathVariable Long idMaintenance){
        maintenanceService.supprimerMaintenanceById(idMaintenance);
    }
}
