package com.bdlproject.bdlweb.controllers;

// A aplicação será organizada em recursos

import com.bdlproject.bdlweb.entities.Expense;
import com.bdlproject.bdlweb.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/expenses") //no plural
public class ExpenseController {

    // O controlador implementa um recurso na API Rest (no caso a tabela Expense)

    @Autowired  // para injetar um componente
    private ExpenseRepository repository;

    @GetMapping
    public String teste() {
        Optional<Expense> result = repository.findById(1L);
        Expense expense = result.get();
        return expense.getDescription();
    }


}
