package com.moneymatters.controllers;

import com.moneymatters.data.domain.transactions.Transaction;
import com.moneymatters.mediators.TransactionMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionMediator transactionMediator;

    @GetMapping("/add")
    public void addTransaction()
    {
        transactionMediator.addTransaction(new Transaction(
                new Date(),
                new BigDecimal("20.00"),
                new BigDecimal("0.00"),
                ""));
    }
}
