package com.expensetracker.project.dto;

import com.expensetracker.project.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {

    private Double amount;
    private String description;

    // We use the Enum we created in the entity folder
    private Category category;

    // The user ID who is making this expense
    private Long userId;

    // Optional: If null, we can default to LocalDate.now() in the service
    private LocalDate date;
}