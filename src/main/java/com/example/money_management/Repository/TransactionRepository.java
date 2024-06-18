package com.example.money_management.Repository;

import com.example.money_management.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    @Query("SELECT * FROM transaction t WHERE t.user_id = :user_id")
    List<Transaction> findAllByUserId(@Param("user_id") Long user_id);
}
