package com.example.money_management.Services;

import com.example.money_management.Model.Transaction;
import com.example.money_management.Model.User;
import com.example.money_management.Repository.TransactionRepository;
import com.example.money_management.Repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;
    private final UserRepositoty userRepositoty;

    public TransactionService(
            TransactionRepository transactionRepository,
            UserRepositoty userRepositoty
    ) {
        this.transactionRepository = transactionRepository;
        this.userRepositoty = userRepositoty;
    }

    public List<Transaction> getAllTransactions () {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionService (Long user_id) {
        Optional<User> currentUser = userRepositoty.findById(user_id);
        if(currentUser.isPresent()){
            return transactionRepository.findAllByUserId(user_id);
        }else {
            return getAllTransactions();
        }
    }

    public Transaction createNewTransaction(Transaction transaction){
        transaction.setCreated_date(new Date());
        return this.transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction updateParams) {
        Transaction transactionParams = this.transactionRepository.findById(id)
                                            .orElseThrow(() -> new IllegalArgumentException("Transaction not found !!"));
        transactionParams.setAmount(updateParams.getAmount());
        transactionParams.setDescription(updateParams.getDescription());
        transactionParams.setCategory(updateParams.getCategory());
        transactionParams.setUpdated_date(new Date());
        return this.transactionRepository.save(transactionParams);
    }
}
