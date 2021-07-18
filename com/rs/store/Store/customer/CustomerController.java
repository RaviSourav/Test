package com.rs.store.Store.customer;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rs.store.Store.account.AccountRepository;
import com.rs.store.Store.product.Product;
import com.rs.store.Store.product.ProductRepository;

@RestController
public class CustomerController 
{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private Product product;
	
	
	@PutMapping("/customers/")
	public String getCustomer(@RequestBody Customer customer)
	{
		
		if(customerRepo.countType(customer.gettype())>customer.getquantity())
		{
			customerRepo.updateType(customer.gettype(), customer.getquantity());
			customerRepo.save(customer);
			if(accountRepo.getByType(customer.gettype(), customer.getDate()).equals(customer.gettype()))
			{
				accountRepo.updateType(customer.gettype(),customer.getquantity(), 
						customer.getunitPrice(),customer.getDate());
			}
//			accountRepo.saveAccountDetails(customer.getDate(), customer.gettype(),
//					customer.getunitPrice(),customer.getquantity());
			return "Purchased";
		}
		else if(customerRepo.countType(customer.gettype())==customer.getquantity())
		{
			customerRepo.save(customer);
			productRepo.deleteByType(customer.gettype());
			return "Purchased";
		}
		else
			return "Number of selected Items is not available";
	}
	
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer()
	{
		return customerRepo.findAll();
	}
	
	
}


