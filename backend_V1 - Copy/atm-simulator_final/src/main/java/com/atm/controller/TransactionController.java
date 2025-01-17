package com.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atm.entities.Atm;
import com.atm.entities.Transaction;
import com.atm.services.TransactionService;

@RestController

public class TransactionController {
	@Autowired
	private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
	

    
	public void insertTransactionDetails(@RequestBody Transaction details)
	{
		transactionService.saveTransaction(details);
		System.out.println("Inserted Successful" + details);
	}
    
    @GetMapping("/api/Getalltranc")
	public List<Transaction> getAlltranc()
	{
		return transactionService.FindAlltranc();
	}
	

}