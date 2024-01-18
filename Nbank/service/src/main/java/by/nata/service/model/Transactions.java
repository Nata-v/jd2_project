package by.nata.service.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Transactions implements Serializable {

    private static final long serialVersionUID = -5436495074173711555L;

    private  String id;
    private  String account_number;
    private  String account_number_recipient;

    private  BigDecimal amount;
    private  BigDecimal updated_amount;

    private  ZonedDateTime date;

    public Transactions() {
    }

    public Transactions(String id, String account_number, String account_number_recipient, BigDecimal amount, BigDecimal updated_amount, ZonedDateTime date) {
        this.id = id;
        this.account_number = account_number;
        this.account_number_recipient = account_number_recipient;
        this.amount = amount;
        this.updated_amount = updated_amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_number_recipient() {
        return account_number_recipient;
    }

    public void setAccount_number_recipient(String account_number_recipient) {
        this.account_number_recipient = account_number_recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getUpdated_amount() {
        return updated_amount;
    }

    public void setUpdated_amount(BigDecimal updated_amount) {
        this.updated_amount = updated_amount;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }
}
