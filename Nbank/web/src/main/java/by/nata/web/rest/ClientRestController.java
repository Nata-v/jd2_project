package by.nata.web.rest;

import by.nata.service.ClientService;
import by.nata.service.model.Client;
import by.nata.service.model.ClientAddress;
import by.nata.service.model.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//http://localhost:8080/web/static/swagger/swagger.json
@RestController
public class ClientRestController {

    private final ClientService clientService;
@Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

//    @GetMapping(value = "/api/clients")
//    public List<Client> getClients(
//            @RequestParam(name = "offset") int offset,
//            @RequestParam(name = "limit") int limit
//    ) {
//        return clientService.findAllClients(); //readAll(offset, limit);
//    }

    @GetMapping(value = "/api/clients/{id}")
    public Client getClient(
            @PathVariable("id") String id) {
        return clientService.findClientById(id);
    }

    @PostMapping(value = "/api/clients/{id}")
    public Client createClient(
            @PathVariable("id") String id,
            @RequestBody Client client, @RequestBody ClientDetails clientDetails,@RequestBody ClientAddress clientAddress) {
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
