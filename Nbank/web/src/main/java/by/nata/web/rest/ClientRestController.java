package by.nata.web.rest;

import by.nata.service.ClientService;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/web/static/swagger/swagger.json
@RestController
public class ClientRestController {

    private final ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping(value = "/api/clients/{id}")
    public Client getClient(
            @PathVariable("id") String id) {
        return clientService.findClientById(id);
    }

    @PostMapping(value = "/api/clients/{id}")
    public Client createClient(
            @PathVariable("id") String id,
            @RequestBody Client client, @RequestBody ClientDetails clientDetails, @RequestBody ClientAddress clientAddress) {
        client.setId(id);
        clientService.saveNewClient(client, clientDetails, clientAddress);
        return client;
    }

    @PutMapping(value = "/api/clients/{id}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Client updateClient(
            @PathVariable("id") String id,
            Client client) {
        return client;
    }

    @DeleteMapping(value = "/api/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(
            @PathVariable("id") String id) {
        clientService.delete(id);
    }
}
