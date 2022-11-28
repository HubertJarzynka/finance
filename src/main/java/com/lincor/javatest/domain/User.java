package com.lincor.javatest.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;




@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            targetEntity = Expense.class,
            fetch = FetchType.EAGER,
            mappedBy = "user")

    private final List<Expense> expenseList = new ArrayList<>();



}
