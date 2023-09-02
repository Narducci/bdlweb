package com.bdlproject.bdlweb.repositories;

import com.bdlproject.bdlweb.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

// Responsável por operações com o banco de dados da tabela Expense
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
