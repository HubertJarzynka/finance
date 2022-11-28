package com.lincor.javatest.domain;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;



@EnableJpaRepositories
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@Table(name = "EXPENSE")
public class Expense {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "CATEGORY")
    private String category;

    @NotNull
    @Column(name = "COST")
    private String cost;

    @NotNull
    @Column(name = "VALUE")
    private BigDecimal value;

    @NotNull
    @Column(name = "PAYMENT")
    private String payment;

    @NotNull
    @Column(name = "DATE")
    private LocalDate date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Expense(Long id, String category, String cost, BigDecimal value, String payment, LocalDate date, User user) {
        this.id = id;
        this.category = category;
        this.cost = cost;
        this.value = value;
        this.payment = payment;
        this.date = date;
        this.user = user;
    }

}
