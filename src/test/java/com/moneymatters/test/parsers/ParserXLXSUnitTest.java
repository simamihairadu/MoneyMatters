package com.moneymatters.test.parsers;

import com.moneymatters.data.domain.Transaction;
import com.moneymatters.mediators.TransactionMediator;
import com.moneymatters.parsers.ParserXLSX;
import com.moneymatters.test.common.AbstractMoneyMattersTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
}
