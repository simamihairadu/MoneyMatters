package com.moneymatters.repositories;

import com.moneymatters.data.domain.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
