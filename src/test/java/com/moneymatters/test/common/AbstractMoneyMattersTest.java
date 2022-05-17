package com.moneymatters.test.common;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public abstract class AbstractMoneyMattersTest {

    @Autowired
    protected DataSource dataSource;

    @BeforeAll
    protected void beforeEveryTest() throws SQLException {
        deleteTableData();
    }

    /**
     * Truncating all tables in order to have a clean db to test on.
     *
     */
    public void deleteTableData() throws SQLException {

        File truncateScript = new File("D:\\Dev\\MoneyMatters\\src\\test\\java\\com\\moneymatters\\test\\resource\\truncate_tables.sql");
        File addCategoriesScript = new File("D:\\Dev\\MoneyMatters\\src\\test\\java\\com\\moneymatters\\test\\resource\\add_categories.sql");

        Connection conn = dataSource.getConnection();

        System.out.println("Deleting all table data.");
        ScriptUtils.executeSqlScript(conn, new FileSystemResource(truncateScript));

        System.out.println("Adding default categories.");
        ScriptUtils.executeSqlScript(conn, new FileSystemResource(addCategoriesScript));;
    }
}
