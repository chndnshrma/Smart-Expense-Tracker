package com.chndn.expensetracker.controller;

import com.chndn.expensetracker.entity.RecurringRule;
import com.chndn.expensetracker.repository.RecurringRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recurring")
public class RecurringRuleController {

    @Autowired
    private RecurringRuleRepository ruleRepository;

    // Create a new recurring rule (e.g., Monthly Netflix)
    @PostMapping
    public ResponseEntity<RecurringRule> createRule(@RequestBody RecurringRule rule) {
        return ResponseEntity.ok(ruleRepository.save(rule));
    }

    // Get all active rules
    @GetMapping("/active")
    public ResponseEntity<List<RecurringRule>> getActiveRules() {
        return ResponseEntity.ok(ruleRepository.findAll());
    }
}