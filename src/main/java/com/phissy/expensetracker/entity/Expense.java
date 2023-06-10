package com.phissy.expensetracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tbl_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="expense_name")
    @NotBlank(message = "Expense name cannot be null")
    private String name;

    @NotBlank(message = "Expense description cannot be null")
    private String description;

    @NotBlank(message = "Expense category cannot be null")
    private String category;

    @Column(name="expense_amount")
    @NotNull(message = "Expense amount cannot be null")
    private Double amount;

    @Column(name="created_at",nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;






}
