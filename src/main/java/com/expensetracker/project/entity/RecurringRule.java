package com.chndn.expensetracker.entity;

import com.expensetracker.project.entity.Category;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "recurring_rules")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecurringRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    // Frequency could be 'MONTHLY' or 'WEEKLY'
    private String frequency;

    private LocalDate nextDueDate;

    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}