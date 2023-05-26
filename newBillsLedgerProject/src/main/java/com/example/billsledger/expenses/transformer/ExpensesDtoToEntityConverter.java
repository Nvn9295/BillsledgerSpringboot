package com.example.billsledger.expenses.transformer;

import com.example.billsledger.expenses.model.dto.ExpensesDto;
import com.example.billsledger.expenses.model.entity.Expense;
import com.example.billsledger.transformer.AbstractCopyProperties;
import org.springframework.stereotype.Component;


@Component
public class ExpensesDtoToEntityConverter extends AbstractCopyProperties<ExpensesDto,Expense> {
}
