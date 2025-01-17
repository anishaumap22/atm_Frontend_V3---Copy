package com.atm.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.entities.Transaction;
import com.atm.repositorie.TransactionRepository;
import com.atm.serviceinterface.TransactionServiceInterface;

@Service
public class TransactionService implements TransactionServiceInterface{
	
	@Autowired
	private  TransactionRepository transactionRepository;

	
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

 
    public void saveTransaction(Transaction transaction) {
        try {
            // Ensure all required fields are set
            if (transaction.getInsertedOn() == null) {
                transaction.setInsertedOn(LocalDateTime.now());
            }
            if (transaction.getUpdatedOn() == null) {
                transaction.setUpdatedOn(LocalDateTime.now());
            }

            transactionRepository.save(transaction);
            System.out.println("Transaction saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }
  
	public List<Transaction> FindAlltranc()
	{
		return transactionRepository.findAll();
	}

	public void saveTransaction(Object upiStatus) {
		// TODO Auto-generated method stub
		
	}

	
}