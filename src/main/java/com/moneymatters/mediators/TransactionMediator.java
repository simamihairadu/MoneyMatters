package com.moneymatters.mediators;

import com.moneymatters.data.domain.Transaction;
import com.moneymatters.repositories.TransactionRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TransactionMediator {

    @Autowired
    private TransactionRepository transactionRepository;

    public void addTransaction(Transaction transaction)
    {
        transactionRepository.save(transaction);
    }
}
