package com.example.billsledger.expenses.controller;

import com.example.billsledger.expenses.model.dto.ExpensesDto;
import com.example.billsledger.expenses.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add-expense")
    private ExpensesDto addExpense(@RequestBody ExpensesDto expensesDto) {
        return expenseService.saveExpense(expensesDto);
    }

    @GetMapping("/get-expenses")
    private List<ExpensesDto> getExpenses() {
        return expenseService.findAll();
    }
}
