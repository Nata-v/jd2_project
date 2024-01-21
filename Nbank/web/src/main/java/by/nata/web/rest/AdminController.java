package by.nata.web.rest;

import by.nata.service.*;
import by.nata.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Open in browser: http://localhost:8080/web/clients
 */
@RestController
@Secured("ADMIN")
public class AdminController {
    private final ClientService clientService;
    private final ClientDetailsService clientDetailsService;
    private final AccountService accountService;
    private final CardService cardService;
    private final TransactionsService transactionsService;
@Autowired
    public AdminController(ClientService clientService, ClientDetailsService clientDetailsService, AccountService accountService, CardService cardService, TransactionsService transactionsService) {
        this.clientService = clientService;
    this.clientDetailsService = clientDetailsService;
    this.accountService = accountService;
    this.cardService = cardService;
    this.transactionsService = transactionsService;
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

    @GetMapping("/allAccounts")
    public ResponseEntity<List<Account>> findAllAccounts(Account account){
        List<Account> accounts = accountService.getAllAccounts();
        if (accounts.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/allCards")
    public ResponseEntity<List<Card>> findAllCards(Card card){
       // List<Card> cards = cardService.findAllCards();
       // if (cards.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      //  return new ResponseEntity<>(cards, HttpStatus.OK);
        return null;
    }
    @GetMapping("/allTransactions")
    public ResponseEntity<List<Transactions>> findAllTransactions(Transactions transactions){
        List<Transactions> transactionsList = transactionsService.findAllTransactions();
        if (transactionsList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transactionsList, HttpStatus.OK);
    }
}
