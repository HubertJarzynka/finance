package com.lincor.javatest.ExpenseTest;

import com.lincor.javatest.domain.Expense;
import com.lincor.javatest.domain.User;
import com.lincor.javatest.dto.ExpenseDto;
import com.lincor.javatest.eception.ExpenseNotFoundException;
import com.lincor.javatest.eception.UserNotFoundException;
import com.lincor.javatest.repository.ExpenseRepository;
import com.lincor.javatest.repository.UserRepository;
import com.lincor.javatest.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ExpenseTestSuite {

    @InjectMocks
    private ExpenseService expenseService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ExpenseRepository expenseRepository;

    @Test
    void shouldGetAllExpenses() {
        //Given
        Expense expense = initExpense();
        List<Expense> expenseList = Collections.singletonList(expense);

        when(expenseRepository.findAll()).thenReturn(expenseList);

        //When
        List<Expense> resultList = expenseService.getAllExpenses();

        //Then
        assertNotNull(resultList);
        assertEquals(1, resultList.size());
    }


    @Test
    void shouldCreateExpense() throws UserNotFoundException, ExpenseNotFoundException {
        //Given
        User user = initUser();
        Expense expense = initExpense();
        ExpenseDto expenseDto = initExpenseDto();

        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        when(expenseRepository.findById(any())).thenReturn(Optional.of(expense));
        when(expenseRepository.save(any())).thenReturn(expense);

        //When
        Expense createdExpense = expenseService.createExpense(expenseDto);

        //Then
        assertEquals(createdExpense.getCategory(), expense.getCategory());
        assertEquals(createdExpense.getUser(), expense.getUser());

    }

    @Test
    void shouldUpdateExpense() throws UserNotFoundException, ExpenseNotFoundException {
        //Given
        User user = initUser();
        Expense expense = initExpense();
        ExpenseDto expenseDto = initExpenseDto();

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(expenseRepository.findById(1L)).thenReturn(Optional.of(expense));


        //When
        Expense modifiedExpense = expenseService.updateExpense(expenseDto);

        //Then
        assertEquals(expenseDto.getUserId(), modifiedExpense.getUser().getId());
        assertEquals(expenseDto.getId(), modifiedExpense.getUser().getId());

    }




    private User initUser() {
        return User.builder()
                .id(1L)
                .name("Jan")
                .password("1234")
                .build();

    }

    private Expense initExpense(){
        User user = initUser();

        return Expense.builder()
                .id(1L)
                .category("x")
                .cost("11111")
                .value(new BigDecimal(100))
                .payment("card")
                .date(LocalDate.of(2022,2,2))
                .user(user)
                .build();
    }

    private ExpenseDto initExpenseDto() {
        return ExpenseDto.builder()
                .id(1L)
                .category("x")
                .cost("11111")
                .value(new BigDecimal(100))
                .payment("card")
                .date(LocalDate.of(2022,2,2))
                .userId(1L)
                .build();

    }
}
