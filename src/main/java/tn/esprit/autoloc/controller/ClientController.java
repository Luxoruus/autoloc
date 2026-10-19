package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final IClientService clientService;

    @GetMapping("/getAll")
    public List<Client> getAllClients(){
        return clientService.afficherClients();
    }

    @GetMapping("/get/{idClient}")
    public Client getClient(@PathVariable Long idClient){
        System.out.println(idClient);
        return clientService.afficherClientById(idClient);
    }

    @PostMapping("/new")
    public Client addClient(@RequestBody Client client){
        return clientService.ajouterClient(client);
    }

    @PutMapping("/edit")
    public Client editClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @DeleteMapping("/delete/{idClient}")
    public void deleteClient(@PathVariable Long idClient){
        clientService.supprimerClientById(idClient);
    }
}
