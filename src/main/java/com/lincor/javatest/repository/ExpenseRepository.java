package com.lincor.javatest.repository;

import com.lincor.javatest.domain.Expense;
import com.lincor.javatest.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    @Override
    List<Expense> findAll();

    @Query
    List<Expense> twodates();





}
