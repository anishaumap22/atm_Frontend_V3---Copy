package com.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.entities.Card;
import com.atm.entities.Customer;
import com.atm.entities.Transfer;
import com.atm.serviceinterface.CustomerServiceInterface;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class CustomerController {
	@Autowired
	private CustomerServiceInterface CustomerServiceRef;
	
	@GetMapping("/Getcustomer")
	public List<Customer> getAllCustomer()
	{
		return CustomerServiceRef.CustomerDetails();
	}
	
	@PostMapping("/InsertCustomer/details")
	public void insertDetails(@RequestBody Customer details)
	{
		CustomerServiceRef.insertCustomerDetails(details);
		System.out.println("Inserted Successful" + details);
	}
	
	@PostMapping("/InsertCustomer/CustomerDetails")
	public void insertArrayOfCustomerDetails(@RequestBody List<Customer> CustomerDetails)
	{
		CustomerServiceRef.insertArrayOfCustomerDetails(CustomerDetails);
		System.out.println("Inserted records successfully.");
	}
	
	@GetMapping("/findbyid/{id}")
	public Customer findCustomerById(@PathVariable int id)
	{
		return CustomerServiceRef.findCustomerById(id);
	}
	
	@GetMapping("/findbyname/{name}")
	public Customer findCustomerByName(@PathVariable String name)
	{
		return CustomerServiceRef.findCustomerByName(name);
	}
	
	@PostMapping("/DeleteCustomer/{id}")
	public void deleteCustomerById(@PathVariable int id)
	{
		CustomerServiceRef.deleteCustomerById(id);
	}
	
	@PostMapping("/UpdateCustomer/CustomerDetails")
	public void updateCustomer(@RequestBody Customer CustomerDetail)
	{
		CustomerServiceRef.updateCustomer(CustomerDetail);
	}
	
	@PostMapping("/UpdatearrayCustomer/listCustomerDetails")
	public void updateArrayCustomer(@RequestBody List<Customer> listCustomerDetail)
	{
		CustomerServiceRef.updateArrayCustomer(listCustomerDetail);
	}
	
	@PostMapping("/Login")
	public Customer checkAuthorization(@RequestBody Card details) {
		System.out.println(details);
		return CustomerServiceRef.checkCardNoAndPin(details);
		
		
	}
	
	@PostMapping("/moneytransfer/accounts/details")
	public void accTransfer(@RequestBody Transfer details) {
		System.out.println(details);
		CustomerServiceRef.accTransfer(details);
	}
	
	@PostMapping("/moneytransfer/upi/details")
    public void upiTransfer(@RequestBody Transfer details) {
    	CustomerServiceRef.upiTransfer(details);
    }
	
	
	@GetMapping("/p/{custId}")
	public double balance(@PathVariable("custId")int custId)
	{
		System.out.println(custId);
		return CustomerServiceRef.balance(custId);
	}
	
}
