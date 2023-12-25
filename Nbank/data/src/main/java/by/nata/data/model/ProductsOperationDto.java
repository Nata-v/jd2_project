package by.nata.data.model;

import by.nata.data.entity.Account;
import by.nata.data.entity.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
@Getter
public final class ProductsOperationDto implements Serializable {
    private static final long serialVersionUID = 872596861734532685L;

    private final String id;

    private final ProductType productType;

    private final ZonedDateTime dateStartOperation;

    private final ZonedDateTime dateEndOperation;

    private final BigDecimal amount;
    private final Integer interestRate;
    private final Account accountId;

    public ProductsOperationDto(String id, ProductType productType, ZonedDateTime dateStartOperation, ZonedDateTime dateEndOperation, BigDecimal amount, Integer interestRate, Account accountId) {
        this.id = id;
        this.productType = productType;
        this.dateStartOperation = dateStartOperation;
        this.dateEndOperation = dateEndOperation;
        this.amount = amount;
        this.interestRate = interestRate;
        this.accountId = accountId;
    }
}
