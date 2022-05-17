package com.moneymatters.mediators;

import com.moneymatters.data.domain.categories.Category;
import com.moneymatters.data.domain.transactions.Transaction;
import com.moneymatters.repositories.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     *
     *
     * @param categoryName
     */
    public void addCategory(String categoryName) {

        Category category = new Category(categoryName);

        categoryRepository.save(category);
    }

    /**
     *
     *
     * @param transaction
     */
    public void addTransaction(Transaction transaction)
    {
        transactionRepository.save(transaction);
    }
}
