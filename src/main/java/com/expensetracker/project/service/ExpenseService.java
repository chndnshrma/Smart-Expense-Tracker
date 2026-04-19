package com.chndn.expensetracker.service;

import com.chndn.expensetracker.model.Expense;
import com.chndn.expensetracker.model.User;
import com.chndn.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(Expense expense) {
        if (expense.getDate() == null) {
            expense.setDate(LocalDate.now());
        }
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpensesForUser(User user) {
        return expenseRepository.findByUser(user);
    }

    // This generates the report for the current month
    public Double getMonthlyReport(User user) {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        return expenseRepository.getTotalSpending(user, start, end);
    }
}