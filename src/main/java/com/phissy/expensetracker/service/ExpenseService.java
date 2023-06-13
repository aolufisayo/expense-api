package com.phissy.expensetracker.service;

import com.phissy.expensetracker.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {
    void deleteExpense(Long expenseId);
    Expense addExpense(Expense expense);
    Expense updateExpense(Long expenseId, Expense expense);
    Page<Expense> getAllExpenses(Pageable page);
    Expense getExpenseById(Long expenseId);
}
