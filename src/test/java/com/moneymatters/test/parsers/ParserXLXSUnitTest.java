package com.moneymatters.test.parsers;

import com.moneymatters.data.domain.transactions.Transaction;
import com.moneymatters.mediators.TransactionMediator;
import com.moneymatters.parsers.ParserXLSX;
import com.moneymatters.test.common.AbstractMoneyMattersTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class ParserXLXSUnitTest extends AbstractMoneyMattersTest {

    @Autowired
    private ParserXLSX parserXLSX;

    @Autowired
    private TransactionMediator transactionMediator;

    @Test
    public void test1() throws SQLException {

        List<Transaction> transactions = parserXLSX.readTransactions("E:\\downloads\\18681257.XLSX");

        for (Transaction transaction : transactions) {

            transactionMediator.addTransaction(transaction);
        }
    }

    @Test
    public void test2() throws SQLException {

        System.out.println("");
    }
}
