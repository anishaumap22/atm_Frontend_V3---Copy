package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.entities.Withdraw;
import com.atm.entities.WithdrawResponse;

import com.atm.services.FastCashService;
import com.atm.services.WithdrawService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class FastCashController {
	
	
	
	@Autowired
	FastCashService fastCash;
	 @PostMapping("/fastcashwithdraw")
	    public WithdrawResponse withdrawVerify(@RequestBody Withdraw obj) {
		 System.out.println(obj);
		 return  fastCash.accessRequets(obj);
	}
}
