package by.nata.web.controllers;

import by.nata.service.ClientDetailsService;
import by.nata.service.ClientService;
import by.nata.service.model.Client;
import by.nata.service.model.ClientDetails;
import by.nata.service.model.ClientFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Open in browser: http://localhost:8080/web/clients
 */
@RestController
public class AdminController {
    private final ClientService clientService;
    private final ClientDetailsService clientDetailsService;
@Autowired
    public AdminController(ClientService clientService, ClientDetailsService clientDetailsService) {
        this.clientService = clientService;
    this.clientDetailsService = clientDetailsService;
}
//@PreAuthorize("hasAnyAuthority('ADMIN')")
@GetMapping("/clientDetails")
    public ResponseEntity<List<ClientDetails>> findClientDetailsById(ClientFilter clientFilter){
    List<ClientDetails> clients = clientDetailsService.findAllByFilter(clientFilter);
    if (clients.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> findAllClients(Client client){
        List<Client> clients = clientService.findAllClients();
        if (clients.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
