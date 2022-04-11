package com.moneymatters.test.common;

import com.moneymatters.data.domain.Transaction;
import com.moneymatters.mediators.TransactionMediator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public abstract class AbstractMoneyMattersTest {

    @Autowired
    protected DataSource dataSource;


    /**
     * Truncating all tables in order to have a clean db to test on.
     *
     */
    @BeforeAll
    public void deleteTableData() throws SQLException {

        String truncateScript = "D:\\Dev\\moneymatters\\src\\test\\java\\com\\moneymatters\\test\\resource\\truncate_tables.sql";

        ScriptUtils.executeSqlScript(dataSource.getConnection(),
                new FileSystemResource(truncateScript));

        System.out.println("Deleting all table data.");
    }
}
