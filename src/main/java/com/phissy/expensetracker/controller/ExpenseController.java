package com.phissy.expensetracker.controller;

import com.phissy.expensetracker.entity.Expense;
import com.phissy.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expenses")
    @ResponseStatus(value= HttpStatus.CREATED)
    public Expense createExpense(@Valid @RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }

    @GetMapping("/expenses/{expenseId}")
    public Expense getExpense(@PathVariable("expenseId") Long expenseId){
        return expenseService.getExpenseById(expenseId);
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @PutMapping("/expenses/{expenseId}")
    public Expense updateExpense(@PathVariable("expenseId") Long expenseId, @RequestBody Expense expense){
        return expenseService.updateExpense(expenseId, expense);
    }

    @DeleteMapping("/expenses/{expenseId}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable("expenseId") Long expenseId){
        expenseService.deleteExpense(expenseId);
    }


}
