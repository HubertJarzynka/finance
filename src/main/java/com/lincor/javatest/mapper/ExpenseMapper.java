package com.lincor.javatest.mapper;


import com.lincor.javatest.domain.Expense;
import com.lincor.javatest.dto.ExpenseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseMapper {

    public Expense mapToExpense(final Expense Expense) {
        return Expense.builder()
                .category(Expense.getCategory())
                .cost(Expense.getCost())
                .value(Expense.getValue())
                .payment(Expense.getPayment())
                .date(Expense.getDate())
                .user(Expense.getUser())
                .build();

    }



    public ExpenseDto mapToExpenseDto(final ExpenseDto expenseDto) {
        return ExpenseDto.builder()
                .category(expenseDto.getCategory())
                .cost(expenseDto.getCost())
                .value(expenseDto.getValue())
                .payment(expenseDto.getPayment())
                .date(expenseDto.getDate())
                .userId(expenseDto.getUserId())
                .build();
    }


    public List<Expense> mapToExpenseDtoList(final List<Expense> expenseList) {
        return expenseList.stream()
                .map(this::mapToExpense)
                .collect(Collectors.toList());
    }

}
