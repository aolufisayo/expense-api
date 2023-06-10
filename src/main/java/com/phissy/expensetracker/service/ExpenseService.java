package com.phissy.expensetracker.service;

import com.phissy.expensetracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    void deleteExpense(Long expenseId);
    Expense addExpense(Expense expense);
    Expense updateExpense(Long expenseId, Expense expense);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long expenseId);
}
