package com.example.money_management.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    private String category;
    @Getter
    @Setter
    private String description;
    @Setter
    @Getter
    private Date created_date;
    @Setter
    private Date updated_date;
    @Setter
    private String created_by;
    @Getter
    @Setter
    private double amount;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private int user_id;

    public long getId() {
        return id;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public Transaction() {
        this.type = com.example.money_management.Enum.Transaction.EXPENSE.toString();
    }

}
