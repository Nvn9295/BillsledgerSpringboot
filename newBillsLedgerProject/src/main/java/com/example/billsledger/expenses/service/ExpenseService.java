package com.example.billsledger.expenses.service;

import com.example.billsledger.constants.SourceConstants;
import com.example.billsledger.expenses.model.dto.ExpensesDto;
import com.example.billsledger.expenses.model.entity.Expense;
import com.example.billsledger.expenses.repository.ExpenseRepository;
import com.example.billsledger.expenses.transformer.ExpensesDtoToEntityConverter;
import com.example.billsledger.expenses.transformer.ExpensesEntityToDtoConverter;
import com.example.billsledger.totalfunds.model.entity.TotalFunds;
import com.example.billsledger.totalfunds.service.TotalFundsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpensesDtoToEntityConverter expensesDtoToEntityConverter;
    private final ExpensesEntityToDtoConverter expensesEntityToDtoConverter;
    private final TotalFundsService totalFundsService;

    public ExpensesDto saveExpense(ExpensesDto expensesDto) {
        List<TotalFunds> totalFunds = totalFundsService.getLastAvailableFunds();
        Expense expense = expensesDtoToEntityConverter.dtoToEntity(expensesDto);
        ExpensesDto expensesDtoEntityToDto = new ExpensesDto();
        if (expense.getAmount() != null && expense.getAmount() <= totalFunds.get(0).getBankBalance() && expense.getSource().equals("HDFC")) {
            expensesDtoEntityToDto = expensesEntityToDtoConverter.entityToDto(expenseRepository.save(expense));
            TotalFunds totalFundsToSave = new TotalFunds();
            totalFundsToSave.setExpenses(expensesDto.getAmount());
            totalFundsToSave.setSource(expensesDto.getSource());
            totalFundsService.saveTotalFund(totalFundsToSave);
        } else if (expense.getAmount() != null  && expense.getAmount() > totalFunds.get(0).getBankBalance()) {
            expensesDtoEntityToDto.setMessage("The amount  " + expense.getAmount() + "  is greater the bank balance");
        } else if (expense.getAmount() == 0) {
            expensesDtoEntityToDto.setMessage("The amount you entered is = " + expense.getAmount());
        }
        if (expense.getAmount() != null && expense.getAmount() >0 && expense.getSource().equals(SourceConstants.SOURCE) && totalFunds.get(0).getWalletBalance()>0) {
            expensesDtoEntityToDto = expensesEntityToDtoConverter.entityToDto(expenseRepository.save(expense));
            TotalFunds totalFundsToSave = new TotalFunds();
            totalFundsToSave.setExpenses(expensesDto.getAmount());
            totalFundsToSave.setSource(expensesDto.getSource());
            totalFundsService.saveTotalFund(totalFundsToSave);
        }
        return expensesDtoEntityToDto;
    }

    public List<ExpensesDto> findAll() {
        List<Expense> expense = expenseRepository.findAll();
        List<ExpensesDto> expensesDto = expensesEntityToDtoConverter.entityToDto(expense);
        return expensesDto;
    }
}
