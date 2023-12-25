package by.nata.data.model;

import by.nata.data.entity.Account;
import by.nata.data.entity.Client;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
public final class AccountDto implements Serializable {
    private static final long serialVersionUID = 818061212323220354L;

    private final String accountId;


    private final Client client;

    private final String accountNumber;

    private final ZonedDateTime dateOpen;


    private final BigDecimal balance;

    public AccountDto(String accountId, Client client, String accountNumber, ZonedDateTime dateOpen, BigDecimal balance) {
        this.accountId = accountId;
        this.client = client;
        this.accountNumber = accountNumber;
        this.dateOpen = dateOpen;
        this.balance = balance;
    }





//    public static AccountDto valueOf(Account account){
//
//        return new AccountDto(
//                account.getAccountId(),
//                account.getClient(),
//                account.getAccountNumber(),
//                account.getDateOpen(),
//                account.getBalance()
//        );
//    }

}
