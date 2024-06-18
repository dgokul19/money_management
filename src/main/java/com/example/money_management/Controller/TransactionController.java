package com.example.money_management.Controller;

import com.example.money_management.Model.Transaction;
import com.example.money_management.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/list")
    public ResponseEntity<List<Transaction>> getAllTransactions (@RequestParam(required = false, defaultValue = "") Long user_id) {
        List<Transaction> responseData = transactionService.getTransactionService(user_id);
        System.out.println("user_id"+ user_id);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Transaction> createNewTransaction (@RequestBody Transaction requestBody) {
        Transaction response = transactionService.createNewTransaction(requestBody);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    };

    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction updateParam,@PathVariable Long id){
        Transaction response = transactionService.updateTransaction(id, updateParam);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
