package com.lincor.javatest.service;

import com.lincor.javatest.domain.Expense;
import com.lincor.javatest.domain.User;
import com.lincor.javatest.dto.ExpenseDto;
import com.lincor.javatest.dto.UserDto;
import com.lincor.javatest.eception.ExpenseNotFoundException;
import com.lincor.javatest.eception.UserNotFoundException;
import com.lincor.javatest.mapper.ExpenseMapper;
import com.lincor.javatest.repository.ExpenseRepository;
import com.lincor.javatest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;
    private final UserRepository userRepository;


    public Expense createExpense (final ExpenseDto expenseDto) throws UserNotFoundException {
        User user = userRepository.findById(expenseDto.getUserId()).orElseThrow(UserNotFoundException::new);


        Expense expense = Expense.builder()
                .category(expenseDto.getCategory())
                .cost(expenseDto.getCost())
                .value(expenseDto.getValue())
                .payment(expenseDto.getPayment())
                .date(expenseDto.getDate())
                .user(user)
                .build();

        return expense;
        }

        public Expense updateExpense(ExpenseDto expenseDto) throws UserNotFoundException, ExpenseNotFoundException {
            User user = userRepository.findById(expenseDto.getUserId()).orElseThrow(UserNotFoundException::new);
            Expense expense = expenseRepository.findById(expenseDto.getId()).orElseThrow(ExpenseNotFoundException::new);

            expense.setUser(user);
            expense.setCategory(expenseDto.getCategory());
            expense.setCost(expenseDto.getCost());
            expense.setValue(expenseDto.getValue());
            expense.setPayment(expenseDto.getPayment());
            expense.setDate(expenseDto.getDate());

            return expense;

        }

        public void deleteExpense(Long id) throws ExpenseNotFoundException {
        Expense expense = expenseRepository.findById(id).orElseThrow(ExpenseNotFoundException::new);

        expense.getUser().getExpenseList().remove(expense);

        expenseRepository.deleteById(id);

        }

        public Expense updateExpense(final Expense expense) throws ExpenseNotFoundException {
            if (expenseRepository.existsById(expense.getId())) {
                expenseRepository.save(expense);
                return expense;
            } else {
                throw new ExpenseNotFoundException();
            }
        }


        public List<Expense> getAllExpenses(){
            return expenseRepository.findAll();
        }



}

