package com.lincor.javatest.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {

    private Long id;
    private String category;
    private String cost;
    private BigDecimal value;
    private String payment;
    private LocalDate date;
    private Long userId;


}
