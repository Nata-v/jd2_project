package by.nata.web.rest;

import by.nata.data.dao.TransactionsDao;
import by.nata.data.model.TransactionsDto;
import by.nata.service.*;
import by.nata.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Open in browser: http://localhost:8080/web/clients
 * http://localhost:8080/web/static/swagger/index.html
 */
@RestController
@Secured("ADMIN")
public class AdminController {
    private final ClientService clientService;
    private final ClientDetailsService clientDetailsService;
    private final AccountService accountService;
    private final CardService cardService;
    private final TransactionsService transactionsService;
    private final TransactionsDao transactionsDao;
@Autowired
    public AdminController(ClientService clientService, ClientDetailsService clientDetailsService, AccountService accountService, CardService cardService, TransactionsService transactionsService, TransactionsDao transactionsDao) {
        this.clientService = clientService;
    this.clientDetailsService = clientDetailsService;
    this.accountService = accountService;
    this.cardService = cardService;
    this.transactionsService = transactionsService;
    this.transactionsDao = transactionsDao;
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
        List<Card> cards = cardService.getAllCards();
        if (cards.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
    @GetMapping("/allTransactions")
    public ResponseEntity<List<Transactions>> findAllTransactions(Transactions transactions){
        List<Transactions> transactionsList = transactionsService.findAllTransactions();
        if (transactionsList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transactionsList, HttpStatus.OK);
    }


    @GetMapping("/allTransactionsPage")
    public ResponseEntity<List<TransactionsDto>> findAllTransactions(
            @RequestParam(name = "offset",  required = false, defaultValue = "0") Integer offset,
            @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit) {

        if (offset != null && limit != null) {
            List<TransactionsDto> paginatedTransactions = transactionsDao.getTransactions(offset, limit);

            if (paginatedTransactions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(paginatedTransactions, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
