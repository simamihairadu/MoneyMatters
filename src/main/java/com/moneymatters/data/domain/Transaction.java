package com.moneymatters.data.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column(name = "date")
    private Date transactionDate;

    @Column(name = "debit_amount")
    private BigDecimal debitAmount;

    @Column(name = "credit_amount")
    private BigDecimal creditAmount;

    @Column(name = "description")
    private String description;

    public Transaction(Date transactionDate, BigDecimal debitAmount, BigDecimal creditAmount, String description) {
        this.transactionDate = transactionDate;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.description = description.split("\\|")[0];
    }

    public Transaction() {}
}
