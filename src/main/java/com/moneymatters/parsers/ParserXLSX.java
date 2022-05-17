package com.moneymatters.parsers;

import com.moneymatters.data.domain.transactions.Transaction;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParserXLSX {

    private static int TRANS_DATE_POS = 1;
    private static int DEBIT_AMOUNT_POS = 2;
    private static int CREDIT_AMOUNT_POS = 3;
    private static int DESCRIPTION_AMOUNT_POS = 11;

    /**
     * Extract the transactions from an Excel file.
     *
     * @param excelFile the Excel file that the transactions will be extracted from
     * @return
     */
    public List<Transaction> readTransactions(String excelFile) {

        List<Transaction> transactions = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(excelFile));
            transactions = readAllSheets(workbook);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    /**
     * Go through all the sheets of the workbook and extract the transactions.
     *
     * @param workbook
     * @return
     */
    private List<Transaction> readAllSheets(XSSFWorkbook workbook) {

        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

            transactions.addAll(readSheet(workbook.getSheetAt(i)));
        }

        return transactions;
    }

    /**
     * Read a specific Excel sheet and extract the transaction. The values are expected at specific indices.
     *
     * @param sheet
     * @return
     */
    private List<Transaction> readSheet(XSSFSheet sheet) {

        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            try {
                Transaction transaction = new Transaction(
                        new SimpleDateFormat("dd/MM/yyyy").parse(sheet.getRow(i).getCell(TRANS_DATE_POS).getStringCellValue()),
                        BigDecimal.valueOf(sheet.getRow(i).getCell(DEBIT_AMOUNT_POS).getNumericCellValue()),
                        BigDecimal.valueOf(sheet.getRow(i).getCell(CREDIT_AMOUNT_POS).getNumericCellValue()),
                        sheet.getRow(i).getCell(DESCRIPTION_AMOUNT_POS).getStringCellValue()
                );

                transactions.add(transaction);

            } catch (Exception exception) {

                System.out.println("Invalid transaction");
            }
        }

        return transactions;
    }
}
