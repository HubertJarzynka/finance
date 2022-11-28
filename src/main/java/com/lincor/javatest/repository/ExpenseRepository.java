package com.lincor.javatest.repository;

import com.lincor.excercise.DbManager;
import com.lincor.javatest.domain.Expense;
import com.lincor.javatest.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    @Override
    List<Expense> findAll();



}
