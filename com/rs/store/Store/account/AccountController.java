package com.rs.store.Store.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController 
{
	@Autowired
	private AccountRepository accountRepo;
	
	@GetMapping("/accounts")
	public List<Account> getSellingDetails()
	{
		return accountRepo.findAll(); 
	}
	
//	@GetMapping("/aacounts/margin/")
//	public void totalMargin()
//	{
//		accountRepo.calculateMargin();
//	}
}
