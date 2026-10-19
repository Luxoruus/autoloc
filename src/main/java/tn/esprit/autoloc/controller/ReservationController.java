package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final IReservationService reservationService;

    @GetMapping("/getAll")
    public List<Reservation> getAllReservations(){
        return reservationService.afficherReservations();
    }

    @GetMapping("/get/{idReservation}")
    public Reservation getReservation(@PathVariable Long idReservation){
        System.out.println(idReservation);
        return reservationService.afficherReservationById(idReservation);
    }

    @PostMapping("/new")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping("/edit")
    public Reservation editReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteReservation(@PathVariable Long idReservation){
        reservationService.supprimerReservationById(idReservation);
    }
}
