package com.moneymatters.test.parsers;

import com.moneymatters.mediators.TransactionMediator;
import com.moneymatters.test.common.AbstractMoneyMattersTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionTest extends AbstractMoneyMattersTest {

    @Autowired
    private TransactionMediator transactionMediator;

    @Test
    public void test1() {

        transactionMediator.addCategory("Fun");
    }
}
