package com.phissy.expensetracker.service;

import com.phissy.expensetracker.entity.Expense;
import com.phissy.expensetracker.exception.ResourceNotFoundException;
import com.phissy.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = getExpenseById(expenseId);
        expenseRepository.delete(expense);
    }

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Long expenseId, Expense newExpense) {
        Expense expense = getExpenseById(expenseId);
        expense.setName(newExpense.getName() != null ? newExpense.getName() : expense.getName());
        expense.setDescription(newExpense.getDescription() != null ? newExpense.getDescription() : expense.getDescription());
        expense.setAmount(newExpense.getAmount() != null ? newExpense.getAmount() : expense.getAmount());
        expense.setCategory(newExpense.getCategory() != null ? newExpense.getCategory() : expense.getCategory());
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long expenseId) {
        Optional<Expense> expense = expenseRepository.findById(expenseId);
        if (expense.isPresent()){
            return expense.get();
        }
        throw new ResourceNotFoundException("Expense not found for id "+expenseId);
    }
}
