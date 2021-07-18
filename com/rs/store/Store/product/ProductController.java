package com.rs.store.Store.product;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rs.store.Store.customer.CustomerRepository;
import com.rs.store.Store.exception.UserNotFoundException;



@RestController
public class ProductController 
{
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CustomerRepository customerRepo;
	
	
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		return productRepo.findAll();
	}
	
	@PostMapping("/products")
	public void saveProducts(@RequestBody Product prod)
	{
		productRepo.save(prod);
	}
	
	@GetMapping("/products/{type}")
	public EntityModel<Product> getProductsByType(@PathVariable String type)
	{
		List<Product> prod = productRepo.getByType(type);
		if(prod.isEmpty())
			throw new UserNotFoundException("item type - "+type+" not found");
//		else
//			return prod;
		
		EntityModel<Product> resource = EntityModel.of(prod.get(0));
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getProducts());
		
		resource.add(linkTo.withRel("all-products"));
		
		
		return resource;
//		return product.findById(id);
//		return null;
	}
	
	@PutMapping("/products/{type}/{quantity}")
	public String  updateProducts(@PathVariable String type,@PathVariable int quantity)
	{
		if(customerRepo.countType(type)>=quantity)
		{
			customerRepo.updateType(type, quantity);
			return "Updated";
		}
		else
			return "Number of selected Items is not available";
	}
	
	@DeleteMapping("/products/{type}")
	public void deleteProducts(@PathVariable String type)
	{
		productRepo.deleteByType(type);
	}
	
	
}
